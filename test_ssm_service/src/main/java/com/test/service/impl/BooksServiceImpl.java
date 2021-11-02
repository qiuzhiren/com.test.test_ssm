package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.dao.BooksDao;
import com.test.domain.Books;
import com.test.domain.BooksSetting;
import com.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksDao booksDao;

    @Override
    public List<Books> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return booksDao.findAll();
    }

    @Override
    public Books findById(Integer booksId) throws Exception {
        return booksDao.findById(booksId);
    }

    @Override
    public void addBooks(Books books) throws Exception {
       booksDao.addBooks(books);
    }

    @Override
    public void addBooksSetting(List<BooksSetting> list) throws Exception {
        if(list != null && list.size() > 0) {
            for (BooksSetting booksSetting : list) {
                    booksDao.addBooksSetting(booksSetting);
            }
        }
    }

    @Override
    public void updateBooks(Books books) throws Exception {
        booksDao.updateBooks(books);
    }

    @Override
    public void deleteBooks(Integer booksId) throws Exception {
        booksDao.deleteBooks(booksId);
    }


}
