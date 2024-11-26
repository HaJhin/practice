package Prac1126.productservice.controller;

import Prac1126.productservice.model.Dto;
import Test.BoardService8MVC.model.Dao;

import java.util.ArrayList;

public class Controller {
    // 싱글턴
    private static Controller controller = new Controller();
    private Controller() {}
    public static Controller getInstance() {
        return controller;
    } // 싱글턴 ed

    public boolean boardWrite(String name,int price) {
        Dto dto = new Dto(name,price);
        boolean result = Dao.getInstance()
    } // boardWrite ed

    public ArrayList<Dto> boardPrint() {

    } // boardPrint ed

    public boolean boardDelete() {

    } // boardDelete ed

    public boolean boardUpdate() {

    } // boardUpdate ed

} // Controller ed
