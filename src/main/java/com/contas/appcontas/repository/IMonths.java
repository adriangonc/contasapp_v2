package com.contas.appcontas.repository;

import com.contas.appcontas.model.MonthPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMonths extends JpaRepository<MonthPayment, Long>{

}
