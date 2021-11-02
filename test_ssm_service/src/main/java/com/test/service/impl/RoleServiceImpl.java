package com.test.service.impl;

import com.test.dao.RoleDao;
import com.test.domain.Permission;
import com.test.domain.Role;
import com.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> findAll() throws Exception{
        return  roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception{
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRole(String roleId) throws Exception {
        //从user_role删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //role_permission删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //role表删除
        roleDao.deleteRoleById(roleId);
    }

    //给角色添加权限
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
         return roleDao.findOtherPermissions(roleId);
    }


}
