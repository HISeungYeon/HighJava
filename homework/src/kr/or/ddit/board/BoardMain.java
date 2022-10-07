package kr.or.ddit.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardMain {

	private Scanner sc = new Scanner(System.in);
	private IBoardService boardService;
	
	public BoardMain() {
		boardService = BoardServiceImpl.getInstatnce();
	}

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 게시판 등록");
		System.out.println("  2. 게시판 삭제");
		System.out.println("  3. 게시판 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 게시판 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}


	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = sc.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertBoard();
				break;
			case 2: // 자료 삭제
				deleteBoard();
				break;
			case 3: // 자료 수정
				updateBoard();
				break;
			case 4: // 전체 자료 출력
				displayBoardAll();
				break;
			case 5: // 자료 검색
				searchBoard();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	/**
	 * 회원정보 검색 메서드
	 */
	private void searchBoard() {
		/*
		 * 검색할 회원ID, 회원이름, 전화번호, 주소 등을 입력하면, 입력한 정보만 사용하여
		 * 검색하는 기능을 구현하시오. 주소는 입력한 값이 포함만 되어도 검색 되도록 한다.
		 * 입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.
		 */
		
		sc.nextLine(); // 입력 버퍼 비우기
		System.out.println();
		System.out.println("검색 할 게시판 정보를 입력하세요.");
		
		System.out.println("게시판번호 >> ");
		int boardNo = 0;
		try {
			boardNo = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			
		}
		
		System.out.println("게시판 제목 >> ");
		String boardTitle = sc.nextLine().trim();
		
		System.out.println("게시판 작성자 >> ");
		String boardWriter = sc.nextLine().trim();
		
		System.out.println("게시판 내용 >> ");
		String boardContent = sc.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		List<BoardVO> bodList = boardService.searchBoardList(bv);
		
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println(" 번호\t제 목\t작성자 이름\t\t내 용");
		System.out.println("-------------------------------------------");
		
		
		if(bodList.size() == 0) {
			System.out.println(" 출력할 게시판 정보가 없습니다.");
		}else {
			for(BoardVO bv2 : bodList) {
				System.out.println(bv2.getBoardNo() + "\t" + bv2.getBoardTitle() + "\t"
						+ bv2.getBoardWriter() + "\t\t" + bv2.getBoardContent());
			}
		}
		System.out.println("-------------------------------------------");
		System.out.println("검색 끝.");
	}

	/**
	 * 전체 회원 정보를 출력하는 메서드
	 */
	private void displayBoardAll() {
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println(" 번호\t제 목\t작성자 이름\t\t내 용");
		System.out.println("-------------------------------------------");
		
		List<BoardVO> bodList = boardService.getAllBoardList();
		
		if(bodList.size() == 0) {
			System.out.println(" 출력할 게시판 정보가 없습니다.");
		}else {
			for(BoardVO bv : bodList) {
				System.out.println(bv.getBoardNo() + "\t" + bv.getBoardTitle() + "\t"
						+ bv.getBoardWriter() + "\t\t" + bv.getBoardContent());
			}
		}
		System.out.println("-------------------------------------------");
		System.out.println("출력 끝.");
	
	}
	
	//회원정보를 삭제하기 위한 메서드
	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시판 번호를 입력하세요.");
		System.out.print("게시판 번호 >> ");
		
		int boardNo = sc.nextInt();
		
		int cnt = boardService.removeBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println(boardNo + " 게시판 삭제 성공!");
		}else {
			System.out.println(boardNo + "게시판 삭제 실패 !!");
		}
		
	}

	private void updateBoard() {
		boolean chk = false;

		int boardNo = 0;

		do {
			System.out.println();
			System.out.println("수정할 게시판 번호를 입력하세요.");
			System.out.println("게시판 번호 >> ");

			boardNo = sc.nextInt();

			chk = checkBoard(boardNo);

			if (chk == false) {
				System.out.println("게시판 번호가 " + boardNo + "인 번호는 존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}

		} while (chk == false);
		
		sc.nextLine();

		System.out.print("게시판 제목 >>");
		String boardTitle = sc.nextLine();

		System.out.print("작성자 이름 >> ");
		String boardWriter = sc.next();

		sc.nextLine(); // 입력버퍼 비우기

		System.out.print("작성 내용 >>");
		String boardContent = sc.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boardService.modifyBoard(bv);
		
		if(cnt > 0) {
			System.out.println(boardNo + " 회원 정보 수정 성공 !");
		}else {
			System.out.println(boardNo + "회원 정보 수정 실패 !!");
		}
	}

	/*
	 * 회원정보 추가하는 메서드
	 */
	private void insertBoard() {

		System.out.println();
		System.out.println("게시판 제목을 입력하세요.");
		System.out.print(">> ");

		String boardTitle = sc.next();

		System.out.print("작성자 이름 >>");
		String boardWriter = sc.next();

		sc.nextLine(); // 입력버퍼 비우기

		System.out.print("게시판 내용 >>");
		String boardContent = sc.nextLine();

		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boardService.registerBoard(bv);
		
		if(cnt > 0) {
			System.out.println(boardTitle + " 게시판 등록 성공 !");
		}else {
			System.out.println(boardTitle + "게시판 등록 실패 !!");
		}
	}

	/**
	 * 회원ID를 이용하여 회원이 존재하는지 알려주는 메서드
	 * 
	 * @param boardNo
	 * @return 회원이 존재하면 true, 없으면 false 리턴.
	 */	
	private boolean checkBoard(int boardNo) {
		
		boolean chk = boardService.checkBoard(boardNo);
		
		return chk;
	}

	public static void main(String[] args) {
		BoardMain bodObj = new BoardMain();
		bodObj.start();
	}
}
