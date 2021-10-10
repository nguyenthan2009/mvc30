package com.codegym.service;

import com.codegym.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
    List<Smartphone> finebyProduct(String product);
    Page<Smartphone> findAll(Pageable pageable);
}
