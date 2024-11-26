package Prac1126.productservice.model;

import java.util.ArrayList;

public class Dao {
    // 싱글턴
    private static Dao dao= new Dao();
    private Dao() {}
    public static Dao getInstance() {
        return dao;
    } // 싱글턴 ed

    public boolean boardWrite() {

    }

    public ArrayList<Dto> boardPrint() {

    } // boardPrint ed

    public boolean boardDelete() {

    } // boardDelete ed

    public boolean boardUpdate() {

    } // boardUpdate ed

} // Dao ed
