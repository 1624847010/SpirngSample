package com.neu.service;

import com.neu.vo.UserVO;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param cUserName
     * @return
     * @throws Exception
     */
    public UserVO getUserByName(String cUserName)throws Exception;

    /**
     * 新增用户
     * @param userVO
     * @return
     * @throws Exception
     */
    public int addUser(UserVO userVO)throws Exception;

    /**
     * 判断新增用户是否重名
     * @param cUserName
     * @return
     * @throws Exception
     */
    public boolean isUserName(String cUserName)throws Exception;

    /**
     * 删除用户
     * @param cId
     * @return
     * @throws Exception
     */
    public int delUser(String cId)throws Exception;

    /**
     * 根据用户id获取用户信息
     * @param cId
     * @return
     * @throws Exception
     */
    public UserVO getUserById(String cId)throws Exception;

    /**
     * 更新用户信息
     * @param userVO
     * @return
     */
    int updateUser(UserVO userVO) throws Exception;

    /**
     * 获取用户列表
     * @param cUserName
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<UserVO> getUserList(String cUserName,String pageNum,String pageSize)throws Exception;
}
