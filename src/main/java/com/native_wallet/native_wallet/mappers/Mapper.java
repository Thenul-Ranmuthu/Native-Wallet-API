package com.native_wallet.native_wallet.mappers;

public interface Mapper<A,B> {
    B mapTo(A a);
    A mapFrom(B b);
}
