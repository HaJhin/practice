package Prac1125.boardservice11mvc.model;

public class BoardDto  {
    private String content; // 내용
    private String writer; // 작성자
    private int pwd; // 비밀번호
    private int num;

    public BoardDto(String content, String writer, int pwd, int num) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
        this.num = num;
    }

    public BoardDto(String content, String writer, int pwd) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                ", num=" + num +
                '}';
    }
}
