package com.contas.appcontas.resource;

import com.contas.appcontas.model.Bill;
import com.contas.appcontas.repository.IBills;
import com.contas.appcontas.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public Bill edit(@PathVariable Long id, @Valid @RequestBody Bill bill) {
        bill.setId(id);
        return billService.edit(bill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        billService.delete(id);
    }

}
