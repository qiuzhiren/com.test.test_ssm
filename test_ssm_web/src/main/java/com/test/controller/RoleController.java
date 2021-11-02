package com.test.controller;


import com.test.domain.Permission;
import com.test.domain.Role;
import com.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView) throws Exception{
        List<Role> list = roleService.findAll();
        modelAndView.addObject("roleList",list);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(ModelAndView modelAndView,@RequestParam(name = "id") String roleId) throws Exception{
        Role role = roleService.findById(roleId);
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    @RequestMapping("/deleteRole.do")
    public  String deleteRole(String roleId) throws Exception{
        roleService.deleteRole(roleId);
        return "redirect:findAll.do";
    }

    //给角色添加权限
    @RequestMapping("/addPermissonToRole.do")
    public String addPermissonToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids") String[] permissionIds) throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(ModelAndView modelAndView,@RequestParam(name = "id") String roleId) throws Exception {
        Role role = roleService.findById(roleId);
        List<Permission> ps =roleService.findOtherPermissions(roleId);
        modelAndView.addObject("permissionList",ps);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }
}
