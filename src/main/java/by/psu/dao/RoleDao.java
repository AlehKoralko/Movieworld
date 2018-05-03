package by.psu.dao;

import by.psu.model.Role;

import java.util.List;

public interface RoleDao extends CrudDao<Role> {

    List<Role> getAllRoles();

}
