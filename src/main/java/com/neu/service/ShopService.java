package com.neu.service;


import com.github.pagehelper.PageInfo;
import com.neu.vo.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getGoodsList(Shop shop);

    int addGoods(Shop shop);

    int delGoods(Shop shop);

    int updateGoods(Shop shop);
}