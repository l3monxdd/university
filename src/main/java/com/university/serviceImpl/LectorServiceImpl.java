package com.university.serviceImpl;

import com.university.dao.LectorDao;
import com.university.entities.Lector;
import com.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorServiceImpl implements LectorService {

    private LectorDao lectorDao;

    @Autowired
    public LectorServiceImpl(LectorDao lectorDao) {
        this.lectorDao = lectorDao;
    }

    @Override
    public void save(Lector lector) {
        lectorDao.save(lector);
    }

    @Override
    public void deleteById(int id) {
        lectorDao.deleteById(id);
    }

    @Override
    public void update(Lector lector) {
        lectorDao.save(lector);
    }

    @Override
    public List<Lector> findAll() {
        return lectorDao.findAll();
    }

    @Override
    public Lector findById(int id) {
        return lectorDao.findById(id).get();
    }


    @Override
    public List<Lector> findAllSearch(String name) {
        return lectorDao.findAllSearch(name);
    }
}
