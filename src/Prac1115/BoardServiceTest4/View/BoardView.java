package Prac1115.BoardServiceTest4.View;

import Prac1115.BoardServiceTest4.Controller.BoardController;

import java.util.Scanner;

public class BoardView {
    Scanner scan = new Scanner(System.in);

    public void mainPage() {
        while (true) {
            System.out.printf("1.게시판 작성 2.게시판 출력");
            int choose = scan.nextInt();
            if (choose == 1) {
                boardWrite();
            } else if (choose == 2) {
                boardPrint();
            } // if-else if ed
        } // while ed
    } // mainPage ed

    // 게시물 작성 메서드
    void boardWrite() {
        // 입력값 작성
        scan.nextLine();
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("작성자 : ");
        String writer = scan.next();
        System.out.print("비밀번호 : ");
        int pwd = scan.nextInt();

        // BC 객체 생성 및 입력값을 BC에 전달.
        BoardController boardController = new BoardController();
        boolean result = boardController.boardWrite(content,writer,pwd);
        // BC 에서 결과값을 반환 받아 출력
        if (result) {
            System.out.println("게시물 작성 성공");
        } else {
            System.out.println("게시물 작성 실패");
        } // if-else ed
    } // boardWrite ed

    // 게시물 출력 메서드
    void boardPrint() {
        // BC 객체 생성
        BoardController BC = new BoardController();
        // BC 에게 게시물 출력 시도 전달
        BC.boardPrint();
        // BC 에게서 전달받은 결과 출력
    }
} // BoardView ed
