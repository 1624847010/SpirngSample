package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.dao.ShopDao;
import com.neu.vo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopMapper;
    /**
    　　* @description: 查询
    　　* @author ll
    　　* @date 2019/10/25 8:13
    　　*/
    @Override
    public List<Shop> getGoodsList(Shop shop) {
        PageHelper.startPage(shop.getPageNum(),shop.getPageSize());
        List<Shop> goodsList = shopMapper.getGoodsList(shop);
        return goodsList;
    }
    /**
    　　* @description: 新增
    　　* @author ll
    　　* @date 2019/10/25 8:14
    　　*/
    @Override
    public int addGoods(Shop shop) {
        int flag = 0;
        flag = shopMapper.addGoods(shop);
        return flag;
    }
    /**
    　　* @description: 删除
    　　* @author ll
    　　* @date 2019/10/25 8:14
    　　*/
    @Override
    public int delGoods(Shop shop) {
        int flag = 0;
        flag = shopMapper.delGoods(shop);
        return flag;
    }
    /**
    　　* @description: 修改
    　　* @author ll
    　　* @date 2019/10/25 8:14
    　　*/
    @Override
    public int updateGoods(Shop shop) {
        int flag = 0;
        flag = shopMapper.updateGoods(shop);
        return flag;
    }
}
