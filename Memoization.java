import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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

    private boolean canRecSlow(Integer target, ArrayList<Integer> data){

        ArrayList<Integer> arr = new ArrayList<>();

        for (Integer datum : data) {
            if (Objects.equals(datum, target)) return true;
            if (datum < target) arr.add(datum);
        }

        return !arr.isEmpty() &&
                canRecSlow(target - arr.removeFirst(), arr);
    }

    public boolean canSumUnique(int target, int[] array){
        if(array.length == 0) return false;
        boolean found = false;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int x : array){
            if(x == target) return true;
            if(x < target) arr.add(x);
        }

        for(int i = 0; i < arr.size() && !found; i++){
            int y = arr.remove(i--);
            if(arr.isEmpty()) return false;
            found = canRecSlow(target-y, arr);
        }


        return found;
    }

    public boolean canSumReuse(int target, int[] data){
        if(target == 0) return true;
        if(target < 0) return false;

        for(int val : data){
            if(val!=0 && canSumReuse(target-val, data)) return true;
        }

        return false;
    }

    @SuppressWarnings("DuplicatedCode")
    private boolean canSumMemo(int target, int[] data, HashMap<Integer, Boolean>map){
        if(map.containsKey(target)) return true;
        if(target == 0) return true;
        if(target < 0) return false;

        for(int val : data){
            if(val == 0) continue;
            if(canSumMemo(target-val, data, map)) {
                map.put(target, true);
                return true;
            }
        }

        map.put(target, false);
        return false;
    }

    public boolean canSumFast(int target, int[] data){
        HashMap<Integer, Boolean> check = new HashMap<>();

        return canSumMemo(target, data, check);
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

        int target = 20;
        int[] data = {0,7,14};
        boolean sum1 = obj.canSumUnique(target, data);
        System.out.println("Sum RecUnique : " + sum1);

//        boolean sum2 = obj.canSumReuse(target, data);
//        System.out.println("Sum RecReuse : " + sum2); //so slow

        boolean sum3 = obj.canSumFast(target, data);
        System.out.println("Sum RecMemo : " + sum3);
    }
}
