package com.orosales.repository;

import com.orosales.domain.TypeCamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TypeCampRepository extends JpaRepository<TypeCamp, Serializable> {

    public abstract TypeCamp findById(Integer id);
}
