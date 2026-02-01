package com.native_wallet.native_wallet.services.interfaces;

import java.util.List;

import com.native_wallet.native_wallet.domain.dtos.TransactionsDto;
import com.native_wallet.native_wallet.domain.entities.Transactions;

public interface TransactionsService {

    TransactionsDto createTransaction(TransactionsDto transaction);

    boolean isExistByUsr(String id);

    List<Transactions> listTransactionsByUsr(String id);

    boolean isExistById(Long id);

    void deleteTransaction(Long id);

}
