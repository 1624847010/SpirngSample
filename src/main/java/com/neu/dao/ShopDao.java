package com.neu.dao;


import com.neu.vo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopDao {
    List<Shop> getGoodsList(Shop shop);

    int addGoods(Shop shop);

    int delGoods(Shop shop);

    int updateGoods(Shop shop);
}
