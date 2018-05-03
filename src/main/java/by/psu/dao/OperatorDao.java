package by.psu.dao;

import by.psu.model.Operator;

import java.util.List;

public interface OperatorDao extends CrudDao<Operator> {

    List<Operator> getAllOperators();

    Operator getByName(String name);

}
