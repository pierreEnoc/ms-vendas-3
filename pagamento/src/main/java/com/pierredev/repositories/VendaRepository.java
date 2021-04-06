package com.pierredev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pierredev.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
