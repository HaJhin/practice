package Prac1114;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardServiceTest1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 입력 객체
        // 컬렉션 프레임워크 중 ArrayList 클래스를 이용한 배열 대체
        // 배열(고정길이) 컬렉션프레임워크(가변길이)
        ArrayList<NewBoard> boardList = new ArrayList<>();
        // ArrayList<> 제네릭타입 : 리스트 객체에 저장할 여러개 데이터들의 타입

        while (true) {
            System.out.println("1.글 쓰기 2.글 출력");
            int choose = scan.nextInt();
            if (choose == 1) {
                scan.nextLine(); // 의미없는 nextLine() 코드를 작성한다
                System.out.print("내용 : ");
                String content = scan.nextLine();
                // .next() 문자열(공백x)입력 , .nextline() 문자열(공백/띄어쓰기 가능)입력
                // .nextLine() 사용시 주의할 점 : .nextLine() 앞에 또다른 .nextXX가 존재하면
                // 의미없는 .nextLine()을 하나 추가한다.
                System.out.print("작성자 : ");
                String writer = scan.next();
                System.out.print("비밀번호 : ");
                int pwd = scan.nextInt();

                // [2] 입력받은 데이터로 게시물 객체 생성
                NewBoard board = new NewBoard();
                board.setContent(content);
                board.setWriter(writer);
                board.setPwd(pwd);

                // [3] 컬렉션프레임워크인 리스트객체에 게시물을 저장
                boardList.add(board);

            } else if (choose == 2) {
                // 배열 내 존재하는 게시물을 모두 출력하기
                for (int i = 0; i < boardList.size(); i++) {
                    if (boardList != null) {
                        System.out.printf("내용:%s 작성자:%s 비밀번호:%d\n",
                                boardList.get(i).getContent(), boardList.get(i).getWriter(), boardList.get(i).getPwd());
                    } // if ed
                } // for ed
            } // if ed
        } // while ed
    } // main ed
} // class ed
