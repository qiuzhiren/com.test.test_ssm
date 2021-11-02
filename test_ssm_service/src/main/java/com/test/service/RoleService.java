package com.test.service;

import com.test.domain.Permission;
import com.test.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    void deleteRole(String roleId) throws Exception;

    void addPermissionToRole(String roleId,String[] permissionIds) throws Exception;


    List<Permission> findOtherPermissions(String roleId) throws Exception;
}
