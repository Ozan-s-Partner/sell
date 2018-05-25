package com.ozan.service;

import com.ozan.dataobject.ProductInfo;
import com.ozan.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sun.java2d.cmm.CMSManager;

import java.util.List;


/**
 * 商品
 *
 * @author Ozan
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);


    /**
     * 加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    //ProductInfo onSale(String productId);

    //下架
    //ProductInfo offSale(String productId);
}
