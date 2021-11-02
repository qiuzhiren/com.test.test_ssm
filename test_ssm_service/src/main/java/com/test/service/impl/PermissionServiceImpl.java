package com.test.service.impl;

import com.test.dao.PermissionDao;
import com.test.domain.Permission;
import com.test.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl  implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    @Override
    public void deleteById(String permissionId) throws Exception {
        //删除role_permission表
        permissionDao.deleteFromRole_Permission(permissionId);
        //删除permission表
        permissionDao.deleteById(permissionId);
    }
}
