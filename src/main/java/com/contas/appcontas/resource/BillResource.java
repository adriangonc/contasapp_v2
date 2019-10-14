package com.contas.appcontas.resource;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.repository.IBills;
import com.contas.appcontas.service.BillService;
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

    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> all(){
        return bills.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
        public Bill create(@Valid @RequestBody Bill bill){
        return billService.save(bill);
    }

    @PutMapping
    public Bill edit(@Valid @RequestBody Bill bill) {
        return billService.edit(bill);
    }

    @DeleteMapping
    public Bill delete(@Valid @RequestBody Bill bill) {
        return billService.delete(bill);
    }

}
