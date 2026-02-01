package com.native_wallet.native_wallet.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.native_wallet.native_wallet.domain.dtos.TransactionsDto;
import com.native_wallet.native_wallet.domain.entities.Transactions;
import com.native_wallet.native_wallet.mappers.Mapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionMapperImpl implements Mapper<Transactions,TransactionsDto> {
    private ModelMapper modelMapper;

    @Override
    public TransactionsDto mapTo(Transactions transactions) {
        return modelMapper.map(transactions,TransactionsDto.class);      
    }

    @Override
    public Transactions mapFrom(TransactionsDto transactionsDto) {
        return modelMapper.map(transactionsDto, Transactions.class);
    }

}
