package todolist.controller;

import todolist.model.TodoDao;
import todolist.model.TodoDto;

import java.util.ArrayList;

public class TodoController {
    private static TodoController todoController = new TodoController();
    private TodoController() {}
    public static TodoController getInstance() {
        return todoController;
    }
    public boolean ListWrite(String content,int date, boolean condition) {

        TodoDto todoDto = new TodoDto(content, date, condition);

        return TodoDao.getInstance().listWrite(todoDto);

    }// end

    public ArrayList<TodoDto> ListPrint() {

        ArrayList<TodoDto> result = TodoDao.getInstance().listPrint();

        return result;
    }


}
