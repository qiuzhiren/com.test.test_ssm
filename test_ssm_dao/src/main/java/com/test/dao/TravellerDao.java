package com.test.dao;

import com.test.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
//另一种写法 select * from order_traveller ot, traveller t WHERE ot.travellerId=t.id AND ot.orderId=#{ordersId}

    @Select("select * from traveller WHERE id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
