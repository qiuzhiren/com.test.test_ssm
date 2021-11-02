package com.test.domain;

import com.test.utils.DateUtils;
import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {
    private String id;
    private Integer booksId;
    private String usersName;
    private Date borrowTime;
    private String borrowTimeStr;
    private Date returnTime;
    private String returnTimeStr;
    private int status;
    private String statusStr;

    public Borrow() {
    }

    public Borrow(Integer booksId, String usersName, Date borrowTime,Date returnTime,Integer status) {
        this.booksId = booksId;
        this.usersName = usersName;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.status = status;
    }

    public Borrow(String id, Integer booksId, String usersName, Date borrowTime, String borrowTimeStr, Date returnTime, String returnTimeStr, int status, String statusStr) {
        this.id = id;
        this.booksId = booksId;
        this.usersName = usersName;
        this.borrowTime = borrowTime;
        this.borrowTimeStr = borrowTimeStr;
        this.returnTime = returnTime;
        this.returnTimeStr = returnTimeStr;
        this.status = status;
        this.statusStr = statusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getBorrowTimeStr() {
        if(borrowTime!=null){
            borrowTimeStr= DateUtils.date2String(borrowTime,"yyyy-MM-dd HH:mm");
        }
        return borrowTimeStr;
    }

    public void setBorrowTimeStr(String borrowTimeStr) {
        this.borrowTimeStr = borrowTimeStr;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnTimeStr() {
        if(returnTime!=null){
            returnTimeStr=DateUtils.date2String(returnTime,"yyyy-MM-dd HH:mm");
        }
        return returnTimeStr;
    }

    public void setReturnTimeStr(String returnTimeStr) {
        this.returnTimeStr = returnTimeStr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        if(status==0){
           statusStr="未归还";
        }else{
            statusStr="已归还";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
