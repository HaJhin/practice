package Prac1125.boardservice11mvc.controller;

import Prac1125.boardservice11mvc.model.BoardDao;
import Prac1125.boardservice11mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 싱글톤 //
    private static BoardController boardController = new BoardController();
    private BoardController(){}
    public static BoardController getInstance() {
        return boardController;
    }
    // 싱글톤 //

    // 1. 게시물 등록 제어 함수
    public boolean boardWrite(String content,String writer,int pwd) {
        BoardDto boardDto = new BoardDto(content,writer,pwd);
        return BoardDao.getInstance().boardWrite(boardDto);
    } // boardWrite ed

    // 2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> boardPrint() {
        ArrayList<BoardDto> result = BoardDao.getInstance().boardPrint();
        return result;
    } // boardPrint ed

    public boolean boardDelete(int D) {
        boolean result = BoardDao.getInstance().boardDelete(D);
        return result;
    }
}
