import java.util.HashMap;

public class Driver {

    private int recFib(HashMap<Integer, Integer> map, int val){
        if(val < 3) return 1;
        if(map.containsKey(val)) return map.get(val);

        map.put(val, recFib(map, val-1)+recFib(map, val-2));
        return map.get(val);
    }

    public int fibonacci(int val){
        if(val==0)return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        return recFib(map, val);
    }


    @SuppressWarnings("DuplicatedCode")
    public boolean canSumMemo(int val, int[] array, HashMap<Integer, Boolean> map){
        if(map.containsKey(val)) return true;
        if(val == 0) return true;
        if(val < 0) return false;


        for (int j : array) {
            if (j == 0) continue;

            if (canSumMemo(val - j, array, map)) {
                map.put(val, true);
                return true;
            }
        }

        map.put(val, false);
        return false;
    }

    public boolean canSum(int val, int[] array){
        return canSumMemo(val, array, new HashMap<Integer, Boolean>());
    }

    public static void main(String[] args) {
        Driver run = new Driver();

        int[] testSet = {0, 2, 4, 5, 10, 20};

        System.out.println("\n-----Starting testing-----");

        for(int data : testSet){
            System.out.println("(*) Fibonacci(" +data+") = "+run.fibonacci(data));
        }
        System.out.println("-----End of testing-----\n");


        System.out.println("\n-----Starting testing-----");
        int sum = 8;
        int[] testSet2 = {3,7,9};

        System.out.println("(*) canSum(" +sum+") = "+run.canSum(sum, testSet2));
        System.out.println("-----End of testing-----\n");
    }
}
