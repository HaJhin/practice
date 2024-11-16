package Test.BoardService8MVC.model;

public class Dto {
    private String id;
    private int pwd;

    private String content;
    private String writer;

    // 로그인 정보 생성자
    public Dto(String id, int pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    // 게시물 작성 생성자
    public Dto(String content,String writer) {
        this.content = content;
        this.writer = writer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
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

    @Override
    public String toString() {
        return "Dto{" +
                "id='" + id + '\'' +
                ", pwd=" + pwd +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
