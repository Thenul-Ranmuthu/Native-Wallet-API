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
public class SummeryDto {
    private BigDecimal balance;

    private BigDecimal income;

    private BigDecimal expences;
}
