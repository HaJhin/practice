package Prac1126.productservice.model;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    private Connection connection;
    // 싱글턴
    private static ProductDao dao= new ProductDao();
    private ProductDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1125","root","6703");
            System.out.println("DB 연동 성공");
        } catch (ClassNotFoundException e) {
            e.getMessage();
            System.out.println("BoardDB Connection fail");
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("BoardDB Connection fail");
        } // try catch ed
    }
    public static ProductDao getInstance() {
        return dao;
    } // 싱글턴 ed

    // 제품 추가
    public boolean boardWrite(ProductDto productDto) {
        try {
            String sql = "insert into board(pname,price)values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,productDto.getName());
            ps.setInt(2,productDto.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("오류 발생");
        }
        return false;
    }

    // 제품 리스트 출력
    public ArrayList<ProductDto> boardPrint() {
        ArrayList<ProductDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("pname");
                int price = rs.getInt("price");
                ProductDto dto = new ProductDto(num,name,price);
                list.add(dto);
            } // while ed
        } catch (SQLException e) {
            e.getMessage();
        } // try ed
        return list;
    } // boardPrint ed

    // 제품 삭제
    public boolean boardDelete(int D) {
        try {
            String sql = "delete from board where num = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,D);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    } // boardDelete ed

    // 제품 수정
    public boolean boardUpdate(ProductDto dto) {
        try {
            String sql = "update board set pname = ? where num = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,dto.getName());
            ps.setInt(2,dto.getNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    } // boardUpdate ed

} // Dao ed
