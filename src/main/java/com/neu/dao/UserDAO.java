package com.neu.dao;

import com.neu.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO操作接口
 */
@Repository
public interface UserDAO {
    /**
     * 根据用户名获取用户信息
     * @param cUserName
     * @return
     * @throws Exception
     */
    public UserVO getUserByName(@Param("cUserName")String cUserName);

    /**
     * 新增用户
     * @param userVO
     * @return
     */
    public int addUser(@Param("UserVo")UserVO userVO);

    /**
     * 删除用户
     * @param cId
     * @return
     */
    public int delUser(@Param("cId")String cId);

    /**
     * 根据用户id获取用户信息
     * @param cId
     * @return
     */
    public UserVO getUserById(@Param("cId")String cId);
    /**
     * 更新用户信息
     * @param userVO
     * @return
     */
    int updateUser(UserVO userVO);

    /**
     * 分页查询
     * @param cUserName
     * @return
     */
    List<UserVO> getUserList(@Param("cUserName") String cUserName);
}
