package com.btrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is Bitcoin Transaction model
 * txId = this is the transaction Id
 * fee = this is the fee associated with the transaction
 * weight = this is the transaction weight
 *
 */
public class BitcoinTransaction implements Comparable<BitcoinTransaction>{
    String txId;
    double fee;
    int weight;
    List<String> parents;
    public BitcoinTransaction(String txId, double fee, int weight, List<String> parents){
        this.txId = txId;
        this.fee = fee;
        this.weight = weight;
        this.parents = Objects.requireNonNullElseGet(parents, ArrayList::new);
    }

    @Override
    public String toString(){
        return "{ txId = " + this.txId + " " +
                "fee = " + this.fee + " " +
                "weight = " + this.weight + " " +
                "parents = " + this.parents + " }";
    }
    @Override
    public int compareTo(BitcoinTransaction next) {
        double nextD = next.fee / next.weight;
        double thisD = this.fee / this.weight;
        return Double.compare(nextD, thisD);
    }
}
