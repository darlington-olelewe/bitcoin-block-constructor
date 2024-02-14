package com.btrust;

import java.util.ArrayList;
import java.util.List;

public class BitcoinTransaction implements Comparable<BitcoinTransaction>{
    String txId;
    double fee;
    int weight;
    List<String> parents = new ArrayList<>();

    public BitcoinTransaction(String txId, double fee, int weight, List<String> parents){
        this.txId = txId;
        this.fee = fee;
        this.weight = weight;
        this.parents = parents;
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
//        0: Indicates that the objects are equal in terms of their natural ordering.
//        -1: Indicates that the object calling compareTo is less than the object being compared to.
//        1: Indicates that the object calling compareTo is greater than the object being compared to.


        return Double.compare(next.fee, this.fee);

    }
}
