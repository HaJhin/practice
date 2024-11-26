package Prac1126.productservice.view;

import Prac1126.productservice.controller.Controller;

import java.util.Scanner;

public class View {
    Scanner scan = new Scanner(System.in);
    // 싱글턴
    private static View view = new View();
    private View() {}
    public static View getInstance() {
        return view;
    } // 싱글턴 ed

    public void mainPage() {
        while (true) {
            System.out.println("1.제품추가 2.전체제품출력 3.제품삭제 4.제품수정");
            int choose = scan.nextInt();
            if (choose == 1) {
                boardWrite();
            } else if (choose == 2) {
                boardPrint();
            } else if (choose == 3) {
                boardDelete();
            } else if (choose == 4) {
                boardUpdate();
            }
        } // while ed
    } // mainPage ed

    void boardWrite() {
        System.out.print("제품명 입력 : ");
        String name = scan.nextLine();
        scan.nextLine();
        System.out.print("제품가격 입력 : ");
        int price = scan.nextInt();
        boolean result = Controller.getInstance().boardWrite(name,price);
    } // boardWrite ed

    void boardPrint() {

    } // boardPrint ed

    void boardDelete() {

    } // boardDelete ed

    void boardUpdate() {

    } // boardUpdate ed

} // View ed


