package com.codegym.repository;

import com.codegym.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISmartphoneRepository extends PagingAndSortingRepository<Smartphone, Long> {
    List<Smartphone> findAllByProducerContaining(String producer);
}
