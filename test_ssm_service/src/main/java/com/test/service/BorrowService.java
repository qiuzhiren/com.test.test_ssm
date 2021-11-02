package com.test.service;

import com.test.domain.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> findAll(int page, int size) throws Exception;

    List<Borrow> findAllByUser(int page, int size) throws Exception;

    String  addBorrow(Integer booksId,String usersName) throws Exception;

    String addReturn(Integer booksId,String usersName) throws Exception;

}
