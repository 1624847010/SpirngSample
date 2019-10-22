package com.neu.vo;

public class UserVO {
    //用户主键
    private String cId;
    //用户名
    private String cUserName;
    //用户密码
    private String cPwd;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcUserName() {
        return cUserName;
    }

    public void setcUserName(String cUserName) {
        this.cUserName = cUserName;
    }

    public String getcPwd() {
        return cPwd;
    }

    public void setcPwd(String cPwd) {
        this.cPwd = cPwd;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "cId='" + cId + '\'' +
                ", cUserName='" + cUserName + '\'' +
                ", cPwd='" + cPwd + '\'' +
                '}';
    }
}
