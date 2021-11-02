package com.test.service;

import com.test.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void deleteById(String permissionId) throws Exception;
}
