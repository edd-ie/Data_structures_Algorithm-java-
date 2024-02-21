public class Driver {
    public static void main(String[] args) {
//        Integer[] data = {3, 9, 6, 1, 2};
//        String[] data2 = { "elderberry","grape", "coconut", "cherry", "date", "fig", "banana", "apple"};
//
//        Sort<Integer> shift = new Sort<>();
//        Sort<String> shift2 = new Sort<>();
//        Search<String> look = new Search<>();
//        Search<Integer> look2 = new Search<>();
//
//
//        shift.selection(data);
//        for (Integer x : data){
//            System.out.print(x + " ");
//        }
//        System.out.println("\n.........");
//
//        shift2.insertion(data2);
//        for (String x : data2){
//            System.out.print(x + " ");
//        }
//        System.out.println("\n.........");
//
//        int test = look.Binary(data2, "apple");
//        System.out.println("\nIndex: "+test+"\nWord: "+data2[test]+"\n.........");
//
//        int test2 = look2.Binary(data, 11);
//        System.out.println("\nIndex: "+test2+"\nNumber: "+data[test2]+"\n.........\n");

        Stack<String> stack = new Stack<>();

        stack.push("Xcode");
        System.out.println(stack.toString()+"\n"+stack.search("Xcode"));
    }
}
