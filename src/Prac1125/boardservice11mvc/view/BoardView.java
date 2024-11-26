package Prac1125.boardservice11mvc.view;

import Prac1125.boardservice11mvc.controller.BoardController;
import Prac1125.boardservice11mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    Scanner scan = new Scanner(System.in);
    // 싱글톤 //
    // 1. 지정한 클래스에 private static 객체 생성
    private static BoardView boardView = new BoardView();
    // 2. 지정한 클래스는 외부로부터 객체 생성을 차단한다.
    private BoardView() {
    }
    public static BoardView getInstance() {
        return boardView;
    }

    // 싱글톤 //

    public void mainPage(){ // View 시작 함수
        while(true) {
            System.out.print("1.게시물 등록 2.게시물 출력 3.게시물 삭제");
            int choose = scan.nextInt();
            if (choose == 1) {
                boardWrite();
            } else if (choose == 2) {
                boardPrint();
            } else if (choose == 3) {
                boardDelete();
            }
        } // while ed
    } // mainPage ed

    // view 가 해야하는 역할 : 입력과 출력만 해야 한다. (관례적인 약속)

    // 1. 게시물 등록 함수
    void boardWrite() {
        // 1. 입력
        scan.nextLine();
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("작성자 : ");
        String writer = scan.next();
        System.out.print("비밀번호 : ");
        int pwd = scan.nextInt();
        // 2. 입력받은 값을 컨트롤러에게 전달
        boolean result = BoardController.getInstance().boardWrite(content,writer,pwd);
        // 3. 컨트롤러에게 전달 후 결과를 받아 출력하기
        if(result) {
            System.out.println("게시물 등록 성공");
        } else {
            System.out.println("게시물 등록 실패");
        }
    }
    // 2. 게시물 출력 함수
    void boardPrint() {
        ArrayList<BoardDto> result = BoardController.getInstance().boardPrint(); // 게시물출력 함수 호출
        for(int i = 0; i < result.size(); i++) {
            System.out.print("게시물 번호 : "+result.get(i).getNum());
            System.out.print(" 게시물 내용 : "+result.get(i).getContent());
            System.out.println(" 작성자 : "+result.get(i).getWriter());
        } // for ed
    } // boardPrint ed

    void boardDelete() {
        System.out.println("제거할 게시물을 선택해주세요.");
        boardPrint();
        int D = scan.nextInt();
        boolean result = BoardController.getInstance().boardDelete(D);
        if (result) {
            System.out.println("게시물 삭제 성공.");
        } else {
            System.out.println("게시물 삭제 실패");
        } // if ed
    } // boardDelete ed

} // BoardView ed
