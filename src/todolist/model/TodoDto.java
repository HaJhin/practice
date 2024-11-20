package todolist.model;

public class TodoDto {
    String content;
    int date;
    boolean condition;

    public TodoDto(String content, int date, boolean condition) {
        this.content = content;
        this.date = date;
        this.condition = condition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "content='" + content + '\'' +
                ", date=" + date +
                ", condition=" + condition +
                '}';
    }
}

