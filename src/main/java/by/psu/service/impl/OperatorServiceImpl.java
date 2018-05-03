package by.psu.service.impl;

import by.psu.dao.OperatorDao;
import by.psu.model.Operator;
import by.psu.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    @Override
    @Transactional
    public void addOperator(Operator operator) {
        operatorDao.add(operator);
    }

    @Override
    @Transactional
    public Operator getOperatorById(int id) {
        return operatorDao.getById(id);
    }

    @Override
    @Transactional
    public void updateOperator(Operator operator) {
        operatorDao.update(operator);
    }

    @Override
    @Transactional
    public void removeOperator(int id) {
        operatorDao.remove(id);
    }

    @Override
    @Transactional
    public List<Operator> getAllOperators() {
        return operatorDao.getAllOperators();
    }

    @Override
    @Transactional
    public Operator getByName(String name) {
        return operatorDao.getByName(name);
    }

}
