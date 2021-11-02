package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.domain.Borrow;
import com.test.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/borrow")
@Controller
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size, ModelAndView modelAndView) throws Exception{
        List<Borrow> borrowList = borrowService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(borrowList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("borrow-list");
        return modelAndView;
    }

    @RequestMapping("/findAllByUser.do")
    public ModelAndView findAllByUser(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size, ModelAndView modelAndView) throws Exception{
        List<Borrow> borrowList = borrowService.findAllByUser(page, size);
        PageInfo pageInfo = new PageInfo(borrowList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("borrow-list");
        return modelAndView;
    }

    @RequestMapping("/addBorrow.do")
    @ResponseBody
    public Map<String, Object> addBorrow(@RequestParam(name = "booksId",required = true)Integer booksId, @RequestParam(name = "usersName",required = true)String usersName, ModelAndView modelAndView) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        String data = borrowService.addBorrow(booksId, usersName);
        map.put("msg",data);
        return map;
    }

    @RequestMapping("/addReturn.do")
    @ResponseBody
    public Map<String, Object> addReturn(@RequestParam(name = "booksId",required = true)Integer booksId,@RequestParam(name = "usersName",required = true)String usersName, ModelAndView modelAndView) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        String data = borrowService.addReturn(booksId, usersName);
        map.put("msg",data);
        return map;
    }

    @RequestMapping("/borrowView.do")
    public ModelAndView borrowView(ModelAndView modelAndView) throws Exception{
        modelAndView.setViewName("borrow-show");
        return modelAndView;
    }
}
