package com.native_wallet.native_wallet.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.native_wallet.native_wallet.domain.dtos.SummeryDto;
import com.native_wallet.native_wallet.domain.dtos.TransactionsDto;
import com.native_wallet.native_wallet.domain.entities.Transactions;
import com.native_wallet.native_wallet.services.interfaces.TransactionsService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@AllArgsConstructor
@RestController
@RequestMapping(path = "api/transactions")
public class TransactionsController {

    private TransactionsService transactionsService;

    @PostMapping(path = "/add")
    public ResponseEntity<TransactionsDto> createTransaction(@RequestBody TransactionsDto transaction) {
        TransactionsDto transactionsDtoSaved = transactionsService.createTransaction(transaction);
        return new ResponseEntity<>(transactionsDtoSaved,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<Transactions>> getTransactionsById(@PathVariable("id") String id) {
        if(!transactionsService.isExistByUsr(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Transactions> foundTransactions = transactionsService.listTransactionsByUsr(id);
        return new ResponseEntity<>(foundTransactions,HttpStatus.FOUND);
    }

    
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteTransaction(@PathVariable("id") Long id){
        if(!transactionsService.isExistById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transactionsService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping(path = "/summery/{userid}")
    public ResponseEntity<SummeryDto> getSummery(@PathVariable("userid") String userid) {
        if(!transactionsService.isExistByUsr(userid)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Transactions> transactions = transactionsService.listTransactionsByUsr(userid);
        BigDecimal positive = BigDecimal.ZERO;
        BigDecimal negative = BigDecimal.ZERO;
        for(Transactions transaction : transactions){
            if(transaction.getAmount().compareTo(BigDecimal.ZERO) >= 0){
                positive = positive.add(transaction.getAmount());
            }else{
                negative = negative.add(transaction.getAmount());
            }
        }
        BigDecimal balance = BigDecimal.ZERO;
        balance = balance.add(positive);
        balance = balance.add(negative);
        SummeryDto summery = new SummeryDto();
        summery.setBalance(balance);
        summery.setExpences(negative);
        summery.setIncome(positive);
        return new ResponseEntity<>(summery,HttpStatus.OK);
    }
    
    
}
