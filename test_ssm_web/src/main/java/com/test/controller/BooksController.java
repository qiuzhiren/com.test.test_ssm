package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.domain.Books;
import com.test.domain.BooksSetting;
import com.test.service.BooksService;
import com.test.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/books")
@Controller
public class BooksController {
    @Autowired
    private BooksService booksService;

    //查询全部图书
    @Secured("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size, ModelAndView modelAndView)throws Exception{
        List<Books> booksList = booksService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(booksList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("books-page-list");
        return modelAndView;
    }


    //图书详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer booksId, ModelAndView modelAndView) throws Exception{
        Books books = booksService.findById(booksId);
        modelAndView.addObject("books",books);
        modelAndView.setViewName("books-show");
        return modelAndView;
    }

    @RequestMapping("/updateById.do")
    public ModelAndView updateById(@RequestParam(name = "id",required = true)Integer booksId, ModelAndView modelAndView) throws Exception{
        Books books = booksService.findById(booksId);
        modelAndView.addObject("books",books);
        modelAndView.setViewName("books-update");
        return modelAndView;
    }

    @RequestMapping("/add.do")
    public String addBooks(Books books) throws Exception{
        booksService.addBooks(books);
        return "redirect:findAll.do";
    }

    @RequestMapping("/update.do")
    public String updateBooks(Books books) throws Exception{
        booksService.updateBooks(books);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String deleteBooks(@RequestParam(name = "id",required = true)Integer booksId) throws Exception{
        booksService.deleteBooks(booksId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/upload.do")
    public String upload(@RequestParam("excelFile") MultipartFile excelFile) throws Exception {
        List<String[]> list = null;
        try {
            list = POIUtils.readExcel(excelFile);
            List<BooksSetting> data = new ArrayList<>();
            for (String[] strings : list) {
                String booksName = strings[0];
                String booksAuthor = strings[1];
                String booksPress = strings[2];
                String booksPress_time = strings[3];
                String booksCategory = strings[4];
                String booksReserve_num = strings[5];
                String booksPrice = strings[6];
                String booksISBN = strings[7];
                String booksDesc = strings[8];
                BooksSetting booksSetting = new BooksSetting(booksName, booksAuthor, booksPress, booksPress_time, booksCategory, Integer.parseInt(booksReserve_num), Double.parseDouble(booksPrice), booksISBN, booksDesc);
                data.add(booksSetting);
            }
            booksService.addBooksSetting(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

}
