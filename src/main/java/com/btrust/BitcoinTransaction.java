package com.btrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BitcoinTransaction implements Comparable<BitcoinTransaction>{
    String txId;
    double fee;
    int weight;
    List<String> parents = new ArrayList<>();

    public BitcoinTransaction(String txId, double fee, int weight, List<String> parents){
        this.txId = txId;
        this.fee = fee;
        this.weight = weight;

        this.parents = Objects.requireNonNullElseGet(parents, ArrayList::new);

    }

    public String toString(){
        String sb = "{ txId = " + this.txId + " " +
                "fee = " + this.fee + " " +
                "weight = " + this.weight + " " +
                "parents = " + this.parents + " }";

        return sb;
    }

    @Override
    public int compareTo(BitcoinTransaction next) {

        double nextD = next.fee / next.weight;
        double thisD = this.fee / this.weight;
        return Double.compare(nextD, thisD);

    }
}
