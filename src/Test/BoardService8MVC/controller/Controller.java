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




}
