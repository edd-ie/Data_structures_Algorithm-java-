public class Search<T> {
    public int Binary (Comparable<T>[] list, T obj){
        int start = 0;
        int end = list.length-1;
        int mid = (end+start)/2;
        boolean found = false;


        while (!found && (start < end)){
            int check =  list[mid].compareTo(obj);
            System.out.println(list[start]+" "+list[mid]+" "+list[end]+" "+check);

            if(check < 0){
                start = (mid)+1;
            } else if(check > 0){
                end = (mid)-1;
            } else{
                found = true;
            }

            mid = (end+start)/2;
        }


        return mid;
    }
}
