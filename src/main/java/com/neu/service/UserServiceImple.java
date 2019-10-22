package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.neu.dao.UserDAO;
import com.neu.util.BaseResponse;
import com.neu.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImple implements UserService {
    @Autowired
    private UserDAO userDAO;

    private final Log log = LogFactory.getLog(getClass());
    @Override
    public UserVO getUserByName(String cUserName) throws Exception {
        try {
            return userDAO.getUserByName(cUserName);
        }catch (Exception e){
            log.debug("UserServiceImpl-->>getUserByName",e);
        }
        return null;
    }

    @Override
    public int addUser(UserVO userVO) throws Exception {
        try {
            return userDAO.addUser(userVO);
        }catch (Exception e){
            log.debug("UserServiceImpl-->>addUser",e);
        }
        return 0;
    }

    @Override
    public boolean isUserName(String cUserName) throws Exception {
        try {
            UserVO userVO = userDAO.getUserByName(cUserName);
            if (userVO != null) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            log.debug("UserServiceImpl-->>isUserName",e);
            return true;
        }
    }

    @Override
    public int delUser(String cId) throws Exception {
        try {
            return userDAO.delUser(cId);
        }catch (Exception e){
            log.debug("UserServiceImpl-->>delUser",e);
        }
        return 0;
    }

    @Override
    public UserVO getUserById(String cId) throws Exception {
        try {
            return userDAO.getUserById(cId);
        }catch (Exception e){
            log.debug("UserServiceImpl-->>getUserById",e);
        }
        return null;
    }

    @Override
    public int updateUser(UserVO userVO) throws Exception {
        int flag =0;
        try {
            UserVO userByName = userDAO.getUserByName(userVO.getcUserName());
            if (userByName != null && userByName.getcId().equals(userVO.getcId())) {
                return flag;
            }
            flag = userDAO.updateUser(userVO);
        }catch (Exception e){
            log.debug("UserServiceImpl-->>updateUser",e);
        }
        return flag;
    }

    @Override
    public List<UserVO> getUserList(String cUserName, String pageNum, String pageSize) throws Exception {
        try {
            int pageIndex = (Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize);
            int pageSizeInt = Integer.parseInt(pageSize);
            PageHelper.startPage(pageIndex,pageSizeInt);
            return userDAO.getUserList(cUserName);
        }catch (Exception e){
            log.debug("UserController-->>getUserList",e);
        }
        return null;
    }
}
