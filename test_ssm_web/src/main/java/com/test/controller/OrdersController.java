package com.test.controller;


import com.github.pagehelper.PageInfo;
import com.test.domain.Orders;
import com.test.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    /**
//     * @param modelAndView
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/findAll.do")
//    public ModelAndView findALL(ModelAndView modelAndView) throws Exception {
//        List<Orders> ordersList = ordersService.findAll();
//        modelAndView.addObject("ordersList",ordersList);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//    }

    //分页查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size, ModelAndView modelAndView) throws Exception {
        List<Orders> ordersList = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    //订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId, ModelAndView modelAndView) throws Exception {
        Orders orders = ordersService.findById(ordersId);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
