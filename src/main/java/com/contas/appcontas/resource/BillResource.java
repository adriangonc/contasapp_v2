package com.contas.appcontas.resource;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.repository.IBills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillResource {

    @Autowired
    private IBills bills;

    @GetMapping
    public List<Bill> all(){
        return bills.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bill create(@Valid @RequestBody Bill bill){
        return bills.save(bill);
    }

}
