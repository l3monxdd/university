package com.university.service;

import com.university.entities.Lector;

import java.util.List;

public interface LectorService {

    void save(Lector lector);

    void deleteById(int id);

    void update(Lector lector);

    List<Lector> findAll();

    Lector findById(int id);

    List<Lector> findAllSearch(String name);

}
