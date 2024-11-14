package Prac1115.BoardServiceTest4.Model;

import java.util.ArrayList;

public class BoardDao {
    // Dto 타입 배열객체 DB 호출
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // DB 에 저장 시도하고 성공 여부를 BC에 송신
    public boolean boardWrite(BoardDto boardDto) {
        boardDB.add(boardDto);
        return true;
    } // boardWrite ed

    // DB 출력 메서드
    public void boardPrint() {
        for (int i = 0; i < boardDB.size(); i++) {
            System.out.printf
                    ("내용:%s 작성자:%s 비밀번호:%d\n",
                    boardDB.get(i).getContent(),
                    boardDB.get(i).getWriter(),
                    boardDB.get(i).getPwd());
        } // for ed
    } // boardPrint ed
} // class ed
