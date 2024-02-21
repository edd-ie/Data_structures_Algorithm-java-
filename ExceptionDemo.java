public class ExceptionDemo {
    public static void methodA(int x, int y, int[] dataset){
        int[]num = new int[2];

        try {
            num[0]=dataset[x];
            num[1]=dataset[y];
            methodB(num);
            System.out.println("Coyote");
        }catch (ArithmeticException e){
            System.out.println("Hare");
        }finally {
            System.out.println("Osprey");
        }
        System.out.println("Bear");
    }

    public static void methodB(int[] nums){
        try {
            int res = nums[0]/nums[1];
            System.out.println(res);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Squirrel");
        }
        System.out.println("Crow");
    }

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 4;
        int[] val = {8,6,2,4,0};

        try {
            methodA(num1,num2,val);
        }catch (ArrayIndexOutOfBoundsException t){
            System.out.println("Mouse");
        }
        System.out.println("Fox");
    }
}
