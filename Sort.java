public class Sort<T> {
    public void selection(Comparable<T>[] obj){
        for(int x = 0; x<obj.length-1; x++){
            System.out.println(" <"+obj[x]+"> ");
            int min = x;

            for(int y = x+1; y<obj.length; y++){
                System.out.print(" "+obj[y]+" ");
                if(obj[y].compareTo((T)obj[min]) < 0){
                    min = y;
                    System.out.print(" "+obj[y]+" ");
                }
            }
            Comparable<T> temp = obj[x];
            obj[x] = obj[min];
            obj[min] = temp;
            System.out.println("\n.........");
        }
    }

    public void insertion(Comparable<T>[] obj){
        for(int x = 1; x < obj.length; x++){
            Comparable<T> temp = obj[x];
            boolean stop = false;

            System.out.println("<"+obj[x]+"> ");

            for (int y = x-1; y>-1 && !stop ;y--){
                System.out.print(obj[y]+"["+temp.compareTo((T)obj[y])+"] ");

                if(temp.compareTo((T)obj[y]) < 0){
                    obj[y+1] = obj[y];
                    obj[y] = temp;
                }
                else {
                    stop = true;
                }
            }
            System.out.println("\n.........");
        }
    }
}
