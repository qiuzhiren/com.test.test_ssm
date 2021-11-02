package com.test.dao;

import com.test.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    //查询role关联的权限
    @Select("select * from permission WHERE id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Delete("delete from role_permission where permissionId=#{permissionId}")
    void deleteFromRole_Permission(String permissionId);
    @Delete("delete from permission where id=#{permissionId}")
    void deleteById(String permissionId);

}
