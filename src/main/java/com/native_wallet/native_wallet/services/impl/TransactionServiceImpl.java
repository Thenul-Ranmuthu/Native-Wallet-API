package com.native_wallet.native_wallet.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.native_wallet.native_wallet.domain.dtos.TransactionsDto;
import com.native_wallet.native_wallet.domain.entities.Transactions;
import com.native_wallet.native_wallet.mappers.Mapper;
import com.native_wallet.native_wallet.repositories.TransactionsRepository;
import com.native_wallet.native_wallet.services.interfaces.TransactionsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionsService {
    private TransactionsRepository transactionsRepository;
    private Mapper<Transactions,TransactionsDto> transactionsMapper;

    @Override
    public TransactionsDto createTransaction(TransactionsDto transactionDto) {
        Transactions transaction = transactionsMapper.mapFrom(transactionDto);
        Transactions transactionS = transactionsRepository.save(transaction);
        return transactionsMapper.mapTo(transactionS);
    }

    @Override
    public boolean isExistByUsr(String id) {
        return transactionsRepository.existsByUserid(id);
    }

    @Override
    public List<Transactions> listTransactionsByUsr(String id) {
        return transactionsRepository.findByUserid(id)
            .stream()
            .collect(Collectors.toList());
    }

    @Override
    public boolean isExistById(Long id) {
        return transactionsRepository.existsById(id);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionsRepository.deleteById(id);
    }



}
