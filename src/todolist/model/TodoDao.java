package todolist.model;

import java.io.*;
import java.util.ArrayList;

public class TodoDao {
    private static TodoDao todoDao = new TodoDao();
    private TodoDao() {
        File file = new File("./src/todolist/data.txt");
        if (file.exists()) {
            fileLoad();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static TodoDao getInstance() {
        return todoDao;
    } // 싱글톤

    // 변수를 저장할 배열 객체 생성
    ArrayList<TodoDto> listDB = new ArrayList<>();

    public boolean listWrite(TodoDto todoDto) {
        listDB.add(todoDto);
        fileSave();
        return true;
    } // listWrite ed

    public ArrayList<TodoDto> listPrint() {
        return listDB;
    } // listPrint ed

    public void fileSave() { // 입출력을 이용한
        String str = "";

        for(int i = 0; i < listDB.size(); i++) {
            TodoDto todoDto = listDB.get(i);

            str += todoDto.getContent()+","+todoDto.getDate()+","+todoDto.isCondition();

            str += "\n";

            try {
                FileOutputStream fileOutputStream = new FileOutputStream("./src/todolist/data.txt");
                fileOutputStream.write(str.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e)  {
                e.printStackTrace();
            } // try ed
        } // for ed
    } // fileSave ed

    public void fileLoad() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/todolist/data.txt");
            File file = new File("./src/todolist/data.txt");
            byte[] bytes = new byte[(int) file.length()];

            fileInputStream.read(bytes);

            String str = new String(bytes);

            String[] row = str.split("\n");

            for (int i = 0; i < row.length; i++) {
                String[] strs = row[i].split(",");
                String strs0 = strs[0];
                int strs1 = Integer.parseInt(strs[1]);
                boolean strs2 = Boolean.parseBoolean(strs[2]);

                TodoDto todoDto = new TodoDto(strs0, strs1, strs2);
                listDB.add(todoDto);
            } // for ed
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // try ed
    } // fileLoad

} // class ed
