package com.university.dao;

import com.university.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorDao extends JpaRepository<Lector, Integer> {

    @Query("select l from Lector l  where l.firstName like  concat('%',:name,'%') or l.lastName like  concat('%',:name,'%') ")
    List<Lector> findAllSearch(@Param("name") String name);

}
