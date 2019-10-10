package com.contas.appcontas.repository;

import com.contas.appcontas.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBills extends JpaRepository<Bill, Long> {

    Optional<Bill> findByNameAndIdMonth(String name, int idMonth);

}
