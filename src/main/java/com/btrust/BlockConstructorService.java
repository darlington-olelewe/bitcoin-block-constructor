package com.btrust;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BlockConstructorService {

    private final List<BitcoinTransaction> sortedBitcoinTransactionList;
    private final int TOTAL_BLOCK_HEIGHT;

    public BlockConstructorService(List<BitcoinTransaction> transactions, int TOTAL_BLOCK_HEIGHT){
        // this is sorted by the rules in the compareTo method of Bitcoin Transaction
        Collections.sort(transactions);
        this.sortedBitcoinTransactionList = transactions;
        this.TOTAL_BLOCK_HEIGHT = TOTAL_BLOCK_HEIGHT;
    }

    public void printAndSaveBlockCreatedBlocks(String filePath) throws IOException {
        List<BitcoinTransaction> result = new LinkedList<>();

        // get All transactions without parents
        List<BitcoinTransaction> withoutParents = sortedBitcoinTransactionList.stream()
                .filter(t-> t.parents.isEmpty())
                .collect(Collectors.toList());

        // add until the block height is reached
        int tempBlockHeight = 0;
        double totalFeesCollected = 0.0;

        for(BitcoinTransaction tx: withoutParents){
            if(tempBlockHeight + tx.weight <= TOTAL_BLOCK_HEIGHT){
                result.add(tx);
                tempBlockHeight += tx.weight;
                totalFeesCollected += tx.fee;
            }
        }

        System.out.println("the size of the array = " + result.size());
        System.out.println("Total weight of block = " + tempBlockHeight);
        System.out.println("Total fees on block   = " + totalFeesCollected);
        result.forEach((r)-> System.out.println(r.txId));

        ReaderAndWriter.writeBlockToFile(filePath,result);
    }

}
