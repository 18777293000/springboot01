package com.atguigu.springboot.query;

/**
 * @创建人 ym
 * @创建时间 2021/3/5 0005
 * @描述
 **/
public class UserQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String userName;

    public Integer getPageNum(){
        return this.pageNum;
    }

    public Integer getPageSize(){
        return this.pageSize;
    }

    public void setPageNum(Integer pageNum){
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
}
