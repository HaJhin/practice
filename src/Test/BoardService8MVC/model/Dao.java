package Test.BoardService8MVC.model;

import java.util.ArrayList;

public class Dao {
    //싱글톤
    private static Dao dao = new Dao();
    private Dao(){};
    public static Dao getInstance() {
        return dao;
    }

    ArrayList<Dto> db = new ArrayList<>();

    // 회원가입 함수
    public boolean register(Dto dto){
        db.add(dto);
        return true;
    }

    // 로그인 성공여부 함수
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

    } // class ed

