package com.contas.appcontas.repository;

import com.contas.appcontas.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBills extends JpaRepository<Bill, Long> {

}
