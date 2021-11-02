package com.test.controller;

import com.test.domain.Books;
import com.test.domain.Role;
import com.test.domain.UserInfo;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RolesAllowed("ADMIN")
    @RequestMapping("findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView) throws Exception {
        List<UserInfo> userInfos = userService.findAll();
        modelAndView.addObject("userList",userInfos);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    //保存用户信息/user/save.do
    @RequestMapping("save.do")
    @ResponseBody
    public Map<String,Object> save(UserInfo userInfo) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        String data = userService.save(userInfo);
        map.put("msg",data);
        return map;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(ModelAndView modelAndView,String id) throws Exception {
        UserInfo userInfo =  userService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(ModelAndView modelAndView , @RequestParam(name = "id")String userId) throws Exception{
        UserInfo userInfo = userService.findById(userId);
        List<Role> userServiceOtherRoles = userService.findOtherRoles(userId);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",userServiceOtherRoles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") String userId,@RequestParam(name = "ids") String[]roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("deleteUserAndRole.do")
    public String deleteUserAndRole(@RequestParam(name = "userId") String userId){
        userService.deleteUserAndRole(userId);
        return "redirect:findAll.do";
    }


    @RequestMapping("changePasswordByUser.do")
    @ResponseBody
    public Map<String, Object> changePasswordByUser(@RequestParam(name = "userName",required = false)  String userName, @RequestParam(name = "oldPassword",required = false) String oldPassword, @RequestParam(name = "newPassword",required = false) String newPassword) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        String data = userService.changePasswordByUser(userName, oldPassword, newPassword);
        map.put("msg",data);
        return map;
    }

    @RequestMapping("changePasswordByUserView.do")
    public ModelAndView changePasswordByUserView(ModelAndView modelAndView,@RequestParam(name = "id") String userId) throws Exception{
        UserInfo userInfo =  userService.findById(userId);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-password-update");
        return modelAndView;
    }

    @RequestMapping("changePasswordByUserSelfView.do")
    public ModelAndView changePasswordByUserSelfView(ModelAndView modelAndView,@RequestParam(name = "username") String username) throws Exception{
        UserInfo userInfo =  userService.findByUsername(username);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-password-update");
        return modelAndView;
    }


    @RequestMapping("/updateById.do")
    public ModelAndView updateById(@RequestParam(name = "userId",required = true)String userId, ModelAndView modelAndView) throws Exception{
        UserInfo userInfo =  userService.findById(userId);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-update");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public String updateUser(UserInfo userInfo) throws Exception{
        userService.updateUser(userInfo);
        return "redirect:findAll.do";
    }

}
