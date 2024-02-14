package com.btrust;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class RunApp {
    public static void main(String[] args) throws IOException {
        ReaderAndWriter memPoolReadWriter = new ReaderAndWriter("src/main/resources/mempool.csv");
        List<BitcoinTransaction> transactionList = memPoolReadWriter.extractMemPoolData();
        BlockConstructorService constructorService = new BlockConstructorService(transactionList,4_000_000);
        constructorService.printAndSaveBlockCreatedBlocks("src/main/resources/block.txt");
    }
}
