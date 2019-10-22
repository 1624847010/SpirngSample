package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.service.UserService;
import com.neu.util.BaseResponse;
import com.neu.util.IDUtil;
import com.neu.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
//@RestController控制层注解，返回json数据
@RequestMapping("/user")
//@RequestMapping("/user")访问路径
public class UserController {
    @Autowired
    private UserService userService;
    private final Log log = LogFactory.getLog(getClass());
    /**
    　　* @description: 用户登陆
    　　* @author ll
    　　* @date 2019/10/22 8:40
    　　*/
    @ApiOperation(value = "登陆",notes = "用户登陆")
    @PostMapping("/login")
    public ResponseEntity<BaseResponse<UserVO>> login(@RequestBody UserVO user) throws Exception{
        UserVO userForBase = userService.getUserByName(user.getcUserName());
        if (userForBase == null) {
            return BaseResponse.generateBadResponseEntity(500,"登陆失败，用户不存在","");
        }else {
            if (!userForBase.getcPwd().equals(user.getcPwd())) {
                return BaseResponse.generateBadResponseEntity(500,"登陆失败，密码错误","");
            }else {
                //token以后的代码修改为自动生成
                String token = "adminToken";
                HashMap obj = new HashMap();
                obj.put("token",token);
                obj.put("user",userForBase);
                return BaseResponse.generateOKResponseEntity(obj);
            }
        }
    }
    /**
    　　* @description: 添加用户
    　　* @author ll
    　　* @date 2019/10/22 8:40
    　　*/
    @ApiOperation(value = "添加用户",notes = "添加用户")
    @PostMapping(value = "/addUser")
    public ResponseEntity<BaseResponse<UserVO>> addUser(HttpServletRequest request,@RequestBody UserVO userinfoVO){
        try {
            //判断用户名是否重复
            if (userService.isUserName(userinfoVO.getcUserName())) {
                return BaseResponse.generateBadResponseEntity(500,"用户名不能重复","");
            }
            //生成主键
            userinfoVO.setcId(IDUtil.getID());
            int flag = userService.addUser(userinfoVO);//调service
            if (flag == 1) {
                return BaseResponse.generateOKResponseEntity("用户新增成功","");
            }else {
                return BaseResponse.generateBadResponseEntity("用户新增失败","");
            }
        }catch (Exception e){
            log.debug("UserController-->>addUser",e);
            return BaseResponse.generateBadResponseEntity(500,"服务器内部错误","");
        }
    }
    /**
    　　* @description: 删除用户
    　　* @author ll
    　　* @date 2019/10/22 8:40
    　　*/
    @ApiOperation(value = "删除用户",notes = "删除用户")
    @PostMapping(value = "/delUser")
    public ResponseEntity<BaseResponse<UserVO>> delUser(HttpServletRequest request,@RequestBody UserVO userVO){
        try {
            int flag = userService.delUser(userVO.getcId());
            if (flag == 1) {
                return BaseResponse.generateOKResponseEntity("用户删除成功","");
            }else {
                return BaseResponse.generateBadResponseEntity(500,"删除失败","");
            }
        }catch (Exception e){
            log.debug("UserController-->>delUser",e);
            return BaseResponse.generateBadResponseEntity(500,"服务器内部错误","");
        }
    }
/**
　　* @description: 查询用户信息
　　* @author ll
　　* @date 2019/10/22 8:41
　　*/
    @ApiOperation(value = "查询用户信息",notes = "查询用户信息")
    @GetMapping(value = "/getUserInfo")
    public ResponseEntity<BaseResponse<UserVO>> getUserInfo(HttpServletRequest request,@RequestParam("cId") String cId){
        try {
                return BaseResponse.generateOKResponseEntity(userService.getUserById(cId));
        }catch (Exception e){
            log.debug("UserController-->>delUser",e);
            return BaseResponse.generateBadResponseEntity(500,"服务器内部错误","");
        }
    }
    /**
    　　* @description: 修改用户
    　　* @author ll
    　　* @date 2019/10/22 8:41
    　　*/
    @ApiOperation(value = "修改用户",notes = "修改用户")
    @PostMapping(value = "/updateUser")
    public ResponseEntity<BaseResponse<UserVO>> updateUser(HttpServletRequest request,@RequestBody UserVO userVO){
        try {
            int flag = userService.updateUser(userVO);
            if (flag == 1) {
                return BaseResponse.generateOKResponseEntity("修改成功");
            }else {
                return BaseResponse.generateBadResponseEntity(500,"内部服务器错误","");
            }
        }catch (Exception e){
            log.debug("UserController-->>updateUser",e);
            return BaseResponse.generateBadResponseEntity(500,"服务器内部错误","");
        }
    }
    /**
    　　* @description: 分页查询用户
    　　* @author ll
    　　* @date 2019/10/22 8:41
    　　*/
    @ApiOperation(value = "分页查询用户",notes = "分页查询用户")
    @GetMapping(value = "/getUserList")
    public ResponseEntity<BaseResponse<UserVO>> getUserList(@RequestParam("cUserName") String cUserName,@RequestParam("pageNum") String pageNum,@RequestParam("pageSize") String pageSize){
        try {
            //获取用户列表
            List<UserVO> userVOList = userService.getUserList(cUserName,pageNum,pageSize);
            return BaseResponse.generateOKListResponseEntity(userVOList);
        }catch (Exception e){
            log.debug("UserController-->>getUserList",e);
            return BaseResponse.generateBadResponseEntity(500,"服务器内部错误","");
        }
    }
}
