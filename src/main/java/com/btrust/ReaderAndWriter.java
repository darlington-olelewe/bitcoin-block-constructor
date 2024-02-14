package com.btrust;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReaderAndWriter {
    private final String filePath;
    public ReaderAndWriter(String filePath){
        this.filePath = filePath;
    }
    public List<BitcoinTransaction> extractMemPoolData(){

        List<BitcoinTransaction> txList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String txid = parts[0].substring(1);
                double fee = Double.parseDouble(parts[1]);
                int weight = Integer.parseInt(parts[2]);
                String parentTxids = parts[3];
                boolean flag = false;
                List<String> parents = null;
                String parentString = parts[3].substring(0,parentTxids.length()-1).trim();
                if(parentString.isEmpty()){
                    flag =true;
                }
                if(!flag){
                    parents = Arrays.asList(parentString.split(";"));
                }
                BitcoinTransaction tx = new BitcoinTransaction(txid,fee,weight,parents);
                txList.add(tx);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return txList;
    }

    public static void writeBlockToFile(String filePath, List<BitcoinTransaction> blockTxids) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (BitcoinTransaction tx : blockTxids) {
            writer.write(tx.txId+ "\n");
        }
        writer.close();
    }


}
