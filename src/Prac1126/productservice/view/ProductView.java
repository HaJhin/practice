package Prac1126.productservice.view;

import Prac1126.productservice.controller.ProductController;
import Prac1126.productservice.model.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    Scanner scan = new Scanner(System.in);
    // 싱글턴
    private static ProductView view = new ProductView();
    private ProductView() {}
    public static ProductView getInstance() {
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
        boolean result = ProductController.getInstance().boardWrite(name,price);
        if(result) {
            System.out.println("제품 등록 성공");
        } else {
            System.out.println("제품 등록 실패");
        }
    } // boardWrite ed

    void boardPrint() {
        ArrayList<ProductDto> result = ProductController.getInstance().boardPrint(); // 게시물출력 함수 호출
        for (int i = 0; i < result.size(); i++) {
            System.out.print("제품 번호 : " + result.get(i).getNum());
            System.out.print(" 제품 이름 : " + result.get(i).getName());
            System.out.println(" 제품 가격 : " + result.get(i).getPrice());
        } // boardPrint ed
    }

    // 게시물 제거 함수
    void boardDelete () {
        System.out.println("제거할 게시물을 선택해주세요.");
        boardPrint();
        int D = scan.nextInt();
        boolean result = ProductController.getInstance().boardDelete(D);
        if (result) {
            System.out.println("게시물 삭제 성공.");
        } else {
            System.out.println("게시물 삭제 실패");
        } // boardDelete ed
    }

    // 제품 수정 함수
    void boardUpdate () {
        System.out.println("수정할 제품을 선택해주세요.");
        boardPrint();
        int U = scan.nextInt();
        System.out.println("수정할 제품명 : ");
        String S = scan.nextLine();
        scan.nextLine();
        System.out.println("수정할 제품가격 : ");
        int P = scan.nextInt();
        ProductDto dto = new ProductDto(U,S,P);
        boolean result = ProductController.getInstance().boardUpdate(dto);

    } // boardUpdate ed

} // View ed


