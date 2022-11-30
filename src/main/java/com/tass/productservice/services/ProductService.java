package com.tass.productservice.services;

import com.tass.productservice.Reponsitory.ProductReponsitory;
import com.tass.productservice.model.BaseResponse;
import com.tass.productservice.model.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductReponsitory pro;

    public BaseResponse createdProduct(ProductRequest request){
        BaseResponse response = new BaseResponse();
        String mess ="";
        Optional<ProductRequest> find = pro.findByBarcode(request.getBarcode());
        if(find.isEmpty()){
            response.setCode(1000);
            mess="barcode đã tồn tại";
        }
        if (request.getName() == null) {
            response.setCode(100);
            mess="Tên sản phẩm không được null";
        } if (request.getImage() == null) {
            response.setCode(101);
            mess=mess+" Ảnh sản phẩm không được null";
        }

        if (request.getContent() == null) {
            response.setCode(101);
            mess=mess+" content sản phẩm không được null";
        } if (request.getDescription() == null||request.getDescription().isEmpty()) {
            response.setCode(101);
            mess=mess+" description sản phẩm không được null";
        }
        if(response.getCode()!=1){
            response.setMessage(mess);
        }else {
            pro.save(request);
        }

        return response;
    }

  

}
