import java.util.HashMap;

/**
 * @author _edd.ie_
 * @version 1.0.0
 * @see <a href="https://www.youtube.com/watch?v=oBt53YbR9Kk&list=WL&index=1">Dynamic Programming - Learn to Solve Algorithmic Problems & Coding Challenges</a>
 */
public class Memoization {

    /**
     * Slow Version of fibonacci sequence
     * @param n position in sequence
     * @return value
     */
    public int fibSlow(int n){
        if(n < 3) return 1;
        return fibSlow(n-1) + fibSlow(n-2);
    }

    /**
     * Fast Version of fibonacci sequence
     * @param n position in sequence
     * @param memo memoization hashmap
     * @return value
     */
    private long fibMemo(Long n, HashMap<Long, Long> memo){
        if(n < 3) return 1;
        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, fibMemo(n-1, memo) + fibMemo(n-2, memo));
        return memo.get(n);
    }

    /**
     * Fast Version of fibonacci sequence
     * @param n position in sequence
     * @return value
     */
    public long fibFast(int n){
        if(n < 3) return 1;
        HashMap<Long, Long> map = new HashMap<>();
        return fibMemo((long)n, map);
    }

    /**
     * Grid Traveler problem
     * can only move right and down
     * @param m rows
     * @param n columns
     * @return number of paths
     */
    public int gridTravel(int m, int n){
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;

        return gridTravel(m-1, n) + gridTravel(m, n-1);
    }

    /**
     * Faster Grid Traveler problem
     * @param m rows
     * @param n columns
     * @return number of paths
     */
    public Long gridTravelMemo(int m, int n){
        if(m == 0 || n == 0) return (long)0;
        if(m == 1 || n == 1) return (long)1;

        HashMap<String, Long> memo = new HashMap<>();
        return fastTravel(m, n, memo);
    }

    /**
     * Fast Traveler helper method
     * @param m rows
     * @param n columns
     * @param memo memoization hashmap
     * @return number of paths
     */
    private Long fastTravel(int m, int n, HashMap<String, Long> memo){
        // Base checks
        if(m == 0 || n == 0) return (long)0;
        if(m == 1 || n == 1) return (long)1;

        // (m, n) || (n, m) is in memo hashmap
        if(memo.containsKey(m+","+n)) return memo.get(m+","+n);
        if(memo.containsKey(n+","+m)) return memo.get(n+","+m);

        memo.put(m+","+n, fastTravel(m-1, n, memo) + fastTravel(m, n-1, memo));
        return memo.get(m+","+n);
    }

    public static void main(String[] args) {
        Memoization obj = new Memoization();
        int test1 = obj.fibSlow(5);
        long test2 = obj.fibFast(50);

        System.out.println("Slow test : " + test1);
        System.out.println("Fast test : " + test2);

        int travel1 = obj.gridTravel(2,3);
        long travel2 = obj.gridTravelMemo(10,10);

        System.out.println("Grid travel : " + travel1);
        System.out.println("Fast travel : " + travel2);
    }
}
