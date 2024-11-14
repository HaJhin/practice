package Prac1114;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardServiceTest2 {
    static Scanner scan = new Scanner(System.in);
    // ArrayList타입 board 객체
    static ArrayList<NewBoard> boardList = new ArrayList<>();

    public static void main(String[] args) { // main 함수
        // 기능 구현 함수
        while (true) {
            // 기능 선택 함수
            System.out.println("1.게시물 작성 2.게시물 출력");
            int fuc = scan.nextInt();
            if (fuc == 1) {
                writeBoard(); // 게시물 작성 메서드 호출
            } else if (fuc == 2) {
                printBoard(); // 게시물 출력 메서드 호출
            } // if-else if ed
        } // while ed
    } // main ed

    // 게시물 작성 메서드
    static void writeBoard () {
        scan.nextLine(); // 의미없는 nextLine() 코드를 작성한다
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("작성자 : ");
        String writer = scan.next();
        System.out.print("비밀번호 : ");
        int pwd = scan.nextInt();
        // [2] 입력받은 데이터로 게시물 객체 생성
        NewBoard board = new NewBoard(content,writer,pwd);
        // [3] 컬렉션프레임워크인 리스트객체에 게시물을 저장
        boardList.add(board);
    } // writeBoard ed

    // 게시물 출력 메서드
    static void printBoard() {
        for (int i = 0; i < boardList.size(); i++) {
            System.out.printf("내용:%s 작성자:%s 비밀번호:%d\n",
                    boardList.get(i).getContent(), boardList.get(i).getWriter(), boardList.get(i).getPwd());
        } // for ed
    } // printBoard ed
} // class ed
