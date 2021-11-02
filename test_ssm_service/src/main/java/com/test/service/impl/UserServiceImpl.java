package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.domain.Role;
import com.test.domain.UserInfo;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
            List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        return  userDao.findAll();
    }

    //对密码加密
    @Override
    public String save(UserInfo userInfo) throws Exception {
        if (userInfo != null && userInfo.getEmail().length()!=0 && userInfo.getPassword().length()!=0 && userInfo.getPhoneNum().length()!=0) {
            String username = userInfo.getUsername();
            UserInfo userDaoByUsername = userDao.findByUsername(username);
            if (userDaoByUsername != null) {
                String data = "添加用户失败，用户已注册";
                return data;
            }
            userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
            userDao.save(userInfo);
            String data = "添加用户成功";
            return data;
        }
        String data = "添加用户失败，用户信息不能为空";
        return data;
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {

        return userDao.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public void deleteUserAndRole(String userId) {
        userDao.deleteUserAndRole(userId);
        userDao.deleteUser(userId);
    }

    @Override
        public String changePasswordByUser(String userName, String oldPassword,String newPassword) throws Exception {
        //获取当前登录对象
//        User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //获取当前登录对象密码
//        String password = principal.getPassword();
//        UserInfo userDaoById = userDao.findById(userId);
        UserInfo userDaoByUserName = userDao.findByUsername(userName);
        String userNameId = userDaoByUserName.getId();
        //获取当前登录对象密码
        String password = userDaoByUserName.getPassword();
//        if(userId==null||userId.equals("")){
//
//        }
        if((userNameId!=null && !(userNameId.equals(""))) &&(oldPassword!=null && !(oldPassword.equals("")))&&(newPassword!=null && !(newPassword.equals("")))){
            //对比原始密码
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            //判断加密后密码一致性
            boolean flag = bcryptPasswordEncoder.matches(oldPassword,password);
            if(flag){
                //密码加密后修改
                String hashPass = bcryptPasswordEncoder.encode(newPassword);
                //如果一致，获取对象后修改密码
                userDao.changPasswordByUser(userNameId,hashPass);
                String data = "修改密码成功";
                return  data;
            }
            String data = "输入密码错误，请重试";
            return data;
        } return "密码不能为空";
    }


    @Override
    public UserInfo findByUsername(String username) throws Exception {
        return userDao.findByUsername(username);
    }

    @Override
    public void updateUser(UserInfo userInfo) throws Exception {
        userDao.updateUser(userInfo);
    }


}
