package com.atguigu.springboot.query;

/**
 * @创建人 ym
 * @创建时间 2021/3/5 0005
 * @描述
 **/
public class UserQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

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
}
