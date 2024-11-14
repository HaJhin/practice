package Prac1115.BoardServiceTest4.Controller;

import Prac1115.BoardServiceTest4.Model.BoardDao;
import Prac1115.BoardServiceTest4.Model.BoardDto;

public class BoardController {

    // 게시물 작성 메서드
    // View 에서 입력값을 받음
    public boolean boardWrite(String content,String writer,int pwd) {
        // View 에서 받은 입력값을 Dto 객체로 만듦
        BoardDto boardDto = new BoardDto(content,writer,pwd);
        // Dao 객체 생성, DB에 저장 시도하고 성공 여부 논리값를 View 에 반환
        BoardDao boardDao = new BoardDao();
        return boardDao.boardWrite(boardDto);
    }

    // 게시물 출력 메서드
    // Dao 객체 생성 및 DB 출력 호출
    public void boardPrint() {
        BoardDao boardDao = new BoardDao();
        boardDao.boardPrint();
    } // boardPrint ed
} // class ed
