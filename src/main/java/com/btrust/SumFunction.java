package com.btrust;
@FunctionalInterface
public interface SumFunction {
    int sum(BitcoinTransaction a, BitcoinTransaction b);
}
