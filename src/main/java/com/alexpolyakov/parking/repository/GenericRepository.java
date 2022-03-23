package com.alexpolyakov.parking.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<E, ID> extends Repository<E, ID> {

    Optional<E> findById(ID id);

    List<E> findAll();

    void deleteById(ID id);

    E save(E entity);

    ID count();
}
