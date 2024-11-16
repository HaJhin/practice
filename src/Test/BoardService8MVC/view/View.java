package Test.BoardService8MVC.view;

import Test.BoardService8MVC.controller.Controller;
import Test.BoardService8MVC.model.Dto;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    // 싱글톤
    private static View view = new View();
    private View () {}
    public static View getInstance() {
        return view;
    } // 싱글톤 ed

    Scanner scanner = new Scanner(System.in);
    boolean log = false;

    public void mainPage() { // 메인 페이지 실행
        while (true) {
                // 로그아웃 상태일 시
                    while (true) {
                    System.out.print("1.회원가입 2.로그인 : ");
                    int choose = scanner.nextInt();

                    if (choose == 1) {
                        register();
                    } else if (choose == 2) {
                        logIn();
                    } else if (log == true) {
                        break;
                    } // if-else if ed
                } // while ed
                if (log == true) { // 로그인 상태일 시
                while (true) {
                    System.out.print("1.게시물 작성 2.게시물 출력 : ");
                    int choose = scanner.nextInt();

                    if (choose == 1) { // 게시물 작성
                        boardWrite();
                    } else if (choose == 2) { // 게시물 출력
                        boardPrint();
                    } // if else if ed
                } // while ed
            } // if ed

        } // while ed
    } // mainPage ed

    // 회원가입 메서드
    void register() {
        System.out.print("아이디를 입력하세요 : ");
        String id = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        int pwd = scanner.nextInt();

        boolean result = Controller.getInstance().register(id, pwd);
        if (result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        } // if ed
    } // register ed


    // 로그인 메서드
    void logIn() {
        System.out.print("아이디를 입력하세요 : ");
        String id = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        int pwd = scanner.nextInt();
        boolean result = Controller.getInstance().logIn(id,pwd);

        if (result) {
            System.out.println("로그인 성공");
            log = true;
        } else {
            System.out.println("로그인 실패");
        } // if
    } // login ed

    void boardWrite () {
        scanner.nextLine();
        System.out.print("내용 : ");
        String content = scanner.nextLine();
        System.out.print("작성자 : ");
        String writer = scanner.next();
        System.out.print("비밀번호 : ");
        int pwd = scanner.nextInt();
        // 2. 입력받은 값을 컨트롤러에게 전달
        boolean result = Controller.getInstance().boardWrite(content, writer);
        // 3. 컨트롤러에게 전달 후 결과를 받아 출력하기
        if (result) {
            System.out.println("게시물 등록 성공");
        } else {
            System.out.println("게시물 등록 실패");
        } //if ed
    } // boardWrite ed

    void boardPrint () {
        ArrayList<Dto> result = Controller.getInstance().boardPrint();

        for (int i = 0; 0 < result.size(); i++) {
            System.out.printf("게시물 내용 : %s 게시물 작성자 : %s\n",result.get(i).getContent(),result.get(i).getWriter());
        } // for ed

    } // boardPrint ed
} // class ed
