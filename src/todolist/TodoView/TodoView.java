package todolist.TodoView;

import todolist.controller.TodoController;
import todolist.model.TodoDto;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoView {
    private static TodoView todoView = new TodoView();
    private TodoView() {}
    public static TodoView getInstance() {
        return todoView;
    } // 싱글톤

    Scanner scan = new Scanner(System.in);

    public void mainPage() {
        while (true) {
            System.out.println("1. 할 일 등록 2. 할 일 확인");
            int choose = scan.nextInt();
            if (choose == 1) {
                listWrite();
            } else if (choose == 2) {
                listPrint();
            } // if ed
        } // while ed
    } // mainPage ed

    void listWrite() {
        scan.nextLine();
        System.out.print("할 일 입력 : ");
        String content = scan.nextLine();
        System.out.print("마감 날짜 입력 : ");
        int date = scan.nextInt();
        scan.nextLine();
        System.out.print("확인 여부 입력 : ");
        boolean condition = scan.hasNextBoolean();
        scan.nextLine();
        boolean result = TodoController.getInstance().ListWrite(content,date,condition);
        if(result) {
            System.out.println("입력 성공");
        } else {
            System.out.println("입력 실패");
        }
    } // listWrite ed

    void listPrint() {

        ArrayList<TodoDto> result = TodoController.getInstance().ListPrint();
        for( int i = 0; i < result.size(); i++ ){
            System.out.println("할 일 내용 : "+result.get(i).getContent());
            System.out.println("마감 날짜 : "+result.get(i).getDate());
            System.out.println("확인 여부 : "+result.get(i).isCondition());
        }

    }
} // class ed
