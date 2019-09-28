package com.contas.appcontas.resource;

import com.contas.appcontas.repository.IMonths;
import com.contas.appcontas.model.MonthPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthResource {
    @Autowired
    private IMonths months;

    @GetMapping
    public List<MonthPayment> all(){
        return months.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MonthPayment create(@Valid @RequestBody MonthPayment month){
        return months.save(month);
    }
}
