package by.psu.service.impl;

import by.psu.dao.CinemaHallDao;
import by.psu.model.CinemaHall;
import by.psu.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    @Autowired
    private CinemaHallDao cinemaHallDao;

    @Override
    @Transactional
    public CinemaHall getCinemaHallById(int id) {
        return cinemaHallDao.getById(id);
    }
}
