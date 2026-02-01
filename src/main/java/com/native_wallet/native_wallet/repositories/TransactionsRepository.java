package com.native_wallet.native_wallet.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.native_wallet.native_wallet.domain.entities.Transactions;


@Repository
public interface TransactionsRepository extends CrudRepository<Transactions,Long> {
    boolean existsByUserid(String userId);
    List<Transactions> findByUserid(String userId);
}
