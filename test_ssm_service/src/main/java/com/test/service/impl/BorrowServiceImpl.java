package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.dao.BooksDao;
import com.test.dao.BorrowDao;
import com.test.domain.Books;
import com.test.domain.Borrow;
import com.test.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private BooksDao booksDao;

    @Override
    public List<Borrow> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return borrowDao.findAll();
    }

    @Override
    public List<Borrow> findAllByUser(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String usersName = auth.getName();
        return borrowDao.findAllByUser(usersName);
    }

    @Override
    public String addBorrow(Integer booksId, String usersName) throws Exception {
        Borrow borrowRecord = borrowDao.findByUserAndBookId(usersName, booksId);
        if(borrowRecord==null){
            Date curDate = new Date();
            Calendar aft = Calendar.getInstance();
            aft.add(Calendar.DATE, 30);
            Date aftTime = aft.getTime();
            Borrow borrow = new Borrow(booksId, usersName, curDate, aftTime, 0);
            Books books = booksDao.findById(booksId);
            Integer reserveNum = books.getReserve_num();

            if(reserveNum!=0) {
                reserveNum = reserveNum - 1;
                borrowDao.addBorrow(borrow);
                booksDao.borrowBooks(booksId, reserveNum);
                return "借阅成功";
            }
            return "该书库存数量为0，请重试";
        }
       return "您已借阅，请勿重复借阅";
    }

    @Override
    public String addReturn(Integer booksId, String usersName) throws Exception {
        Borrow borrowRecord = borrowDao.findByUserAndBookId(usersName, booksId);
        if(borrowRecord!=null){
            Date retDate = new Date();
            int status = 1 ;
            borrowDao.addReturn(booksId,usersName,status);
            Books books = booksDao.findById(booksId);
            Integer reserveNum = books.getReserve_num();
            reserveNum = reserveNum + 1;
            booksDao.borrowBooks(booksId,reserveNum);
            return "归还成功";
        }
        return "输入信息有误，您未借阅此书";
    }
}
