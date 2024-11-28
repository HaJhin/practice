package Prac1126.productservice.controller;

import Prac1126.productservice.model.ProductDao;
import Prac1126.productservice.model.ProductDto;


import java.util.ArrayList;

public class ProductController {
    // 싱글턴
    private static ProductController controller = new ProductController();
    private ProductController() {}
    public static ProductController getInstance() {
        return controller;
    } // 싱글턴 ed

    public boolean boardWrite(String name,int price) {
        ProductDto productDto = new ProductDto(name,price);
        boolean result = ProductDao.getInstance().boardWrite(productDto);
        return result;
    } // boardWrite ed

    public ArrayList<ProductDto> boardPrint() {
            ArrayList<ProductDto> result = ProductDao.getInstance().boardPrint();
            return result;
    } // boardPrint ed

    public boolean boardDelete(int D) {
        boolean result = ProductDao.getInstance().boardDelete(D);
        return result;
    } // boardDelete ed

    public boolean boardUpdate(ProductDto dto) {
        boolean result = ProductDao.getInstance().boardUpdate(dto);
        return result;
    } // boardUpdate ed

} // Controller ed
