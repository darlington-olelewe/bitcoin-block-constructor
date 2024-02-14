# Block Constructor

### BitcoinTransaction Model
```java
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
```
The model is a typical pojo that 