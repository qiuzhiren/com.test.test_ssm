package com.test.service;

import com.test.domain.Books;
import com.test.domain.BooksSetting;
import jdk.vm.ci.meta.Value;

import java.util.List;

public interface BooksService {
    List<Books>findAll(int page,int size) throws Exception;

    Books findById(Integer booksId) throws Exception;

    void addBooks(Books books) throws Exception;

    void addBooksSetting(List<BooksSetting> list) throws Exception;

    void updateBooks(Books books)throws Exception;

    void deleteBooks(Integer booksId)throws Exception;
}
