package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService bodService;

	private IBoardDAO bodDao;

	private BoardServiceImpl() {
		bodDao = BoardDAOImpl.getInstance();
	}

	public static IBoardService getInstatnce() {
		if (bodService == null) {
			bodService = new BoardServiceImpl();
		}

		return bodService;
	}

	@Override
	public int registerBoard(BoardVO mv) {

		int cnt = bodDao.insertBoard(mv);

		return cnt;
	}

	@Override
	public boolean checkBoard(int boardNo) {

		boolean chk = bodDao.checkBoard(boardNo);

		return chk;
	}

	@Override
	public int modifyBoard(BoardVO bv) {

		int cnt = bodDao.updateBoard(bv);

		return cnt;
	}

	@Override
	public int removeBoard(int boardNo) {

		int cnt = bodDao.deleteBoard(boardNo);

		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {

		List<BoardVO> bodList = bodDao.getAllBoardList();

		return bodList;
	}

	public void accuntTransfer() {
		try {
			// 트랜잭션 시작
			// 계좌DAO.update(); 사람1 계정 백만원 인출
			// 계좌DAO.update(); 사람2 계정 백만원 입금

			// 트랜잭션 종료(commit)
		} catch (Exception ex) {
			// 롤백 처리
		}
	}

	@Override
	public List<BoardVO> searchBoardList(BoardVO bv) {
		List<BoardVO> bodList = bodDao.searchBoardList(bv);
		return bodList;
	}

}
