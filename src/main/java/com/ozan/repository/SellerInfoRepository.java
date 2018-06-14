package com.ozan.repository;


import com.ozan.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Ozan
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
