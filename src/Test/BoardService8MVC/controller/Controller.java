package Test.BoardService8MVC.controller;

import Test.BoardService8MVC.model.Dao;
import Test.BoardService8MVC.model.Dto;
import Test.BoardService8MVC.view.View;
import java.util.ArrayList;

public class Controller {
    //싱글톤
    private static Controller controller = new Controller();
    private Controller(){}
    public static Controller getInstance(){
        return controller;
    }

    //회원가입
    public boolean register(String id, int pwd){
        Dto dto = new Dto(id, pwd);
        return Dao.getInstance().register(dto);
    }

    //로그인
    public boolean logIn(String id,int pwd){
        boolean result = Dao.getInstance().login(id,pwd);
        return result;
    }

    //게시물 작성
    public boolean boardWrite(String content,String writer) {
    Dto dto = new Dto(content,writer);
    return Dao.getInstance().boardWrite(dto);
    } // boardWrite

    //게시물 출력
    public ArrayList<Dto> boardPrint() {
        ArrayList<Dto> result = Dao.getInstance().boardPrint();
        return result;
    }
}
