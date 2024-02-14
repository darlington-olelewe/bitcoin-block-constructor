package com.btrust;

import java.util.List;

public class RunApp {
    public static void main(String[] args) {
        ReaderAndWriter memPoolReadWriter = new ReaderAndWriter("src/main/resources/mempool.csv");
        List<BitcoinTransaction> transactionList = memPoolReadWriter.extractMemPoolData();
        transactionList.forEach(System.out::println);



    }
}
