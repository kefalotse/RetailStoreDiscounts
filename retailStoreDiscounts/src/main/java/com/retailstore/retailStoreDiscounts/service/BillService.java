package com.retailstore.retailStoreDiscounts.service;

import com.retailstore.retailStoreDiscounts.exception.RecordNotFoundException;

import com.retailstore.retailStoreDiscounts.model.Bill;
import com.retailstore.retailStoreDiscounts.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    //create record
    public Bill createUpdateBill(Bill bill) throws RecordNotFoundException
    {
        Optional<Bill> isbill = billRepository.findById(bill.getBillId());
        if(isbill.isPresent())
        {
            Bill newbill = isbill.get();
            newbill.setTotalAmount(bill.getTotalAmount());
            newbill.setDiscountPercentage(bill.getDiscountPercentage());
            newbill.setBillCost(bill.getBillCost());



            newbill = billRepository.save(newbill);
            return newbill;
        } else {
            bill = billRepository.save(bill);
            return bill;
        }
    }//end create record
    //list all records
    public List<Bill> getAllBills()
    {
        List<Bill> billList = billRepository.findAll();

        if(billList.size() > 0) {
            return billList;
        } else {
            return new ArrayList<Bill>();
        }
    }//end list all records



}
