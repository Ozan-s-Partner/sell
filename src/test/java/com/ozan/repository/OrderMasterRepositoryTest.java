package com.ozan.repository;

import com.ozan.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Ozan
 * @Description:
 * @Date: Created in 14:02 2018/3/1.
 * @Modified By:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    OrderMasterRepository repository;

    private final String OPENID="110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("朱逸涛");
        orderMaster.setBuyerPhone("13376033431");
        orderMaster.setBuyerAddress("上海市建信大楼");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(3203.4));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request=new PageRequest(0,3);

        Page<OrderMaster> orderMasterPage=repository.findByBuyerOpenid(OPENID,request);
        System.out.println(orderMasterPage.getTotalElements());
    }

}