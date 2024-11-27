package Prac1126.productservice.model;

public class ProductDto {
    private int num; // 제품번호
    private String name; // 제품명
    private int price; // 제품가격

    public ProductDto(int num, String name, int price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    public ProductDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
} // Dto ed
