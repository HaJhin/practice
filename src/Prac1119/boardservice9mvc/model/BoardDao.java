package Prac1119.boardservice9mvc.model;

import java.io.*;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class BoardDao {
    // 싱글톤 패턴
    private static BoardDao boardDao = new BoardDao();
    private BoardDao(){}
    public static BoardDao getInstance() {
        return boardDao;
    }
    // 싱글톤 패턴

    ArrayList<BoardDto> boardDB = new ArrayList<>();


    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto) {
        boardDB.add(boardDto);
        // 만약 리스트에 게시물 객체를 추가했다면
        fileSave();
        return true;
    }

    // 2. 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint () {
        return boardDB;
    }

    // ====== 영구저장을 위한 게시물들을 파일에 저장하는 기능 ====== //
    public void fileSave() { // 게시물 등록을 성공했을때 지정한 함수 사용/호출
        // 여러개 게시물들을 [ArrayList<BoardDto> boardDB] 하나의 문자열[String/CSV]로 표현하는 방법
        String str = ""; // 1.임의의 문자열 변수 선언
        // 2. 반복문을 이용한 모든 게시물들을 순회/반복
        for(int i = 0; i < boardDB.size(); i++) { // 리스트 객체 내 0번 인덱스부터 마지막까지 반복
            BoardDto boardDto = boardDB.get(i); // 3. i번째의 게시물
            // 4. index 번째의 게시물 객체 내 필드값을 CSV 형식으로 변환
            str += boardDto.getContent()+","+boardDto.getWriter()+","+boardDto.getPwd();
            // += 복합대입연산자 : 오른쪽 값을 왼쪽변수 값과 더한 후에 결과를 왼쪽 변수에 대입
            // 5. [객체 구분]
            str += "\n";
        } // for ed
        System.out.println(str); // 확인용


        try { // try{}catch{} : 예상치 못한 예외가 발생했을 때 다른 catch 코드로 흐름을 이동하는 문법
            // [1] 파일 출력 객체 생성
            FileOutputStream outputStream = new FileOutputStream("./src/Prac1119/boardservice9mvc/data.txt");
            // [2] 파일 출력 객체를 이용한 바이트 쓰기/내보내기
            outputStream.write(str.getBytes()); // 위에서 객체들을 모두 CSV 형식으로 변환된 문자열을 바이트로 변환
            // [3] 안내 메시지 작성
            System.out.println("[파일 저장 성공]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // try catch ed
    }
    // ====== 영구저장된 파일의 게시물들을 가져오는 기능 ====== //
    public void fileLoad() {

        try {
            // [1] 파일 입력 객체 생성
            FileInputStream inputStream = new FileInputStream("./src/Prac1119/boardservice9mvc/data.txt");
            // [2] 파일 용량만큼 바이트 배열을 선언
            File file = new File("./src/Prac1119/boardservice9mvc/data.txt");
            byte[] bytes = new byte[(int) file.length()];
            // [3] 파일 입력 객체를 이용해 파일을 읽어서 바이트 배열 저장
            inputStream.read(bytes);
            // [4] 읽어온 바이트 배열을 문자열(String)으로 변환
            String str = new String(bytes);
            // 활용과제 : 파일로부터 읽어온 문자열의 게시물 정보들을 다시
            // ArrayList<BoardDto> boardDB 에 저장하시오.

            // 불러온 str값을 split 메서드로 쪼개 각각의 변수로 초기화
            String[] strs = str.split(",");
            String p1 = strs[0].trim();
            String p2 = strs[1].trim();
            String p3r = strs[2].trim();
            int p3 = Integer.parseInt(p3r);

            // boardDto 객체 생성 후 각 변수를 매개변수로 투입
            BoardDto boardDto = new BoardDto(p1, p2, p3);

            // boardDto 객체를 boardDB에 저장.
            boardDB.add(boardDto);
            System.out.println("파일 불러오기 성공");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
