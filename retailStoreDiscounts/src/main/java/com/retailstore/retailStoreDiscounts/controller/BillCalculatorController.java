package com.retailstore.retailStoreDiscounts.controller;


import com.retailstore.retailStoreDiscounts.model.Bill;
import com.retailstore.retailStoreDiscounts.repository.BillRepository;
import com.retailstore.retailStoreDiscounts.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bill/")
@CrossOrigin("http://localhost:4200")

public class BillCalculatorController {


    @Autowired
    private BillService billService;
    @Autowired
    private BillRepository billRepository;

    @PostMapping("bill/save")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        try {
            Bill _bill= billRepository.save(new Bill(bill.getBillId(),bill.getTotalAmount(),
                    bill.getDiscountPercentage(),bill.getBillCost()
                    ));

            return  new ResponseEntity<>(_bill, HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping("/bill/list")
    public List<Bill> getAllBill(){
        return billService.getAllBills();
    }


}
