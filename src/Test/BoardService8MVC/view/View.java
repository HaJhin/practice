package Test.BoardService8MVC.view;

import Test.BoardService8MVC.controller.Controller;

import java.util.Scanner;

public class View {
    // 싱글톤
    private static View view = new View();
    private View () {}
    public static View getInstance() {
        return view;
    } // 싱글톤 ed

    Scanner scanner = new Scanner(System.in);

    public void mainPage() {
        while (true) {
            System.out.print("1.회원가입 2.로그인 : ");
            int choose = scanner.nextInt();

            if (choose == 1) {
                register();
            } else if (choose == 2) {
                logIn();
            } // if else if ed
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
        }
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
        } else {
            System.out.println("로그인 실패");
        }
    }
}
