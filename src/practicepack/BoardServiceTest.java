package practicepack;

import java.util.Scanner;

// 메인 클래스
public class BoardServiceTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 게시물 클래스를 배열 객체로 호출
        Post[] post = new Post[100];

        // 기능을 구현할 반복문 작성
        while (true) {
            System.out.println("1.게시물 작성 2.게시물 출력");
            int f1 = scan.nextInt();
            // 게시물 작성 기능 함수
            if (f1 == 1) {
                // 게시물 작성 입력문
                System.out.print("게시물 내용 : ");
                String content1 = scan.next();
                System.out.print("게시물 작성자 : ");
                String writer1 = scan.next();
                System.out.print("게시물 비밀번호 : ");
                int password1 = scan.nextInt();

                boolean save = false; // 저장 확인
                // 게시물 등록 절차 함수
                for (int i = 0; i < post.length; i++) {
                    if (post[i] == null) {
                        post[i] = new Post();
                        post[i].content = content1;
                        post[i].writer = writer1;
                        post[i].password = password1;
                        save = true;
                        break;
                    } // if ed
                } // for ed
                if (!save) { // 게시물 등록 실패 시
                    System.out.println("게시물 등록 실패 : 저장 공간이 부족합니다.");
                } else { // 게시물 등록 성공 시
                    System.out.println("게시물 등록 성공");
                } // if ed
            } // f1=1 if ed

            // 게시물 출력기능 함수
            if (f1 == 2) {
                for (int i = 0; i < post.length; i++) {
                    if (post[i] != null) {
                        System.out.printf("내용 : %s , 작성자 : %s , 비밀번호 : %d\n",post[i].content,post[i].writer,post[i].password);
                    } // if ed
                } // for ed
            } // f1=2 if ed
        } // while ed

    } // main ed
} // class ed
