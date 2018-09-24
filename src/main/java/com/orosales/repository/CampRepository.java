package com.orosales.repository;

import com.orosales.domain.Camp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface CampRepository extends JpaRepository<Camp, Serializable> {

    public abstract Camp findById(Integer id);
}
