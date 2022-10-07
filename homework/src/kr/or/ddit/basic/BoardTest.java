package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.board.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {

		SqlSession sqlSession = null;
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
		
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(rd);
			
			sqlSession = sqlSessionFactory.openSession(true);
		
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("insert 작업 시작...");
		
		BoardVO bv = new BoardVO();
		bv.setBoardTitle("안녕하세요");
		bv.setBoardWriter("이승연");
		bv.setBoardContent("ㅎㅇㅎㅇㅎㅇㅎㅇ");
		
		int cnt = sqlSession.insert("boardTest.insertBoard", bv);
		if (cnt > 0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		System.out.println("update작업 시작..");
		
		BoardVO bv2 = new BoardVO();
		bv2.setBoardTitle("안녕하세요");
		bv2.setBoardWriter("이승연");
		bv2.setBoardContent("ㅂㅇㅂㅇㅂㅇㅂㅇ");
		
		int cnt2 = sqlSession.update("memberTest.updateMember", bv2);
		
		if (cnt2 > 0) {
			System.out.println("update 성공");
		}else {
			System.out.println("update 실패");
		}
		
		
		System.out.println("delete 작업 시작...");
		
		cnt = sqlSession.delete("memberTest.deleteMember", "1");
		
		if (cnt > 0) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
		
		
		/*
		//1) 응답결과가 여러개일 경우..
		System.out.println("select 연습 시작(결과가 여러개일 경우..)"); //list 로 리턴 받어야 해 !
		
		// 응답 결과가 여러개 일 경우에는 selectList()메서드를 사용한다.
		// 이 메서드는 여러개의 레코드를 VO에 담은 후 이 VO 데이터를 List에 추가해 주는 작업을 자동으로 수행한다.
		List<BoardVO> memList = sqlSession.selectList("memberTest.memberAllList");
		
		for(BoardVO mv : memList) {
			System.out.println("ID : " + mv.getMemId());
			System.out.println("이름 : " + mv.getMemName());
			System.out.println("전화 : " + mv.getMemTel());
			System.out.println("주소 : " + mv.getMemAddr());
			System.out.println("=======================================");
		}
		System.out.println("출력 끝...");
		*/
		
		//2) 응답결과가 1개일 경우.. //object 로 리턴 받음 그래서 캐스팅 해줘야 함.
		System.out.println("select 연습 시작(결과가 1개인 경우..)");
		
		// 응답결과가 1개가 확실할 경우에는 selectOne()메서드를 사용한다.
		BoardVO bv3 = 
				(BoardVO) sqlSession.selectOne("boardTest.getBoard", "1"); 
		System.out.println("번호 : " + bv3.getBoardNo());
		System.out.println("제목 : " + bv3.getBoardTitle());
		System.out.println("작성자 : " + bv3.getBoardWriter());
		System.out.println("내용 : " + bv3.getBoardContent());
		System.out.println("출력 끝...");
		
	}
}
