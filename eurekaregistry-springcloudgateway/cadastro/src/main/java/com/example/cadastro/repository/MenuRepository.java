package com.example.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Override
//    @Cacheable("menu")
    Optional<Menu> findById(Long aLong);
}
