package by.psu.service;

import by.psu.model.Operator;

import java.util.List;

public interface OperatorService {

    void addOperator(Operator operator);

    Operator getOperatorById(int id);

    void updateOperator(Operator operator);

    void removeOperator(int id);

    List<Operator> getAllOperators();

    Operator getByName(String name);

}
