package com.ozan.service;



import com.ozan.dataobject.ProductCategory;

import java.util.List;


/**
 * @author Ozan
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
