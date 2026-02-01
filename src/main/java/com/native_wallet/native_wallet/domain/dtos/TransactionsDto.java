package com.native_wallet.native_wallet.domain.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionsDto {
    
    private String userid;

    private String title;

    private BigDecimal amount;

    private String category;
}
