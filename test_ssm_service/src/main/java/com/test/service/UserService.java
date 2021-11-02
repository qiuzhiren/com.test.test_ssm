package com.test.service;

import com.test.domain.Role;
import com.test.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    String save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);

    void deleteUserAndRole(String userId);

    String changePasswordByUser(String userName,String oldPassword,String newPassword) throws Exception;

    UserInfo findByUsername(String username) throws Exception;

    void updateUser(UserInfo userInfo)throws Exception;
}
