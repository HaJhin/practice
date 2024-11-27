package Test.BoardService8MVC.model;

import Prac1126.productservice.model.ProductDto;

import java.util.ArrayList;

public class Dao {
    //싱글톤
    private static Dao dao = new Dao();
    private Dao(){};
    public static Dao getInstance() {
        return dao;
    }
    // 회원가입 정보 객체
    ArrayList<Dto> db = new ArrayList<>();
    // 게시물 정보 객체
    ArrayList<Dto> db2 = new ArrayList<>();

    // 회원가입 메서드
    public boolean register(Dto dto){
        db.add(dto);
        return true;
    }

    // 로그인 성공여부 메서드
    public boolean login(String id,int pwd) {
        boolean re = false;
        for (int i = 0; i < db.size(); i++) {
            if (id.equals(db.get(i).getId()) && pwd == db.get(i).getPwd()) {
                re = true;
                break;
            }
        } // for ed
        return re;
    } // logIn ed

    // 게시물 작성 메서드
    public boolean boardWrite(ProductDto dto) {
        db2.add(dto);
        return true;
    }

    // 게시물 출력 메서드
    public ArrayList<Dto> boardPrint() {
            return db2;
    } // boardprint ed
} // class ed

