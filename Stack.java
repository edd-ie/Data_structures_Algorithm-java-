import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Stack data structure
 * @author _edd.ie_
 */
public class Stack <T>{
    private final ArrayList<T> dataset;
    int levels;

    public Stack(){
        dataset = new ArrayList<>();
        levels = 0;
    }

    public void push(T obj){
        dataset.add(obj);
    }

    public T pop(){
        if(dataset.isEmpty()){
            throw new EmptyStackException();
        }
        T element = dataset.get(dataset.size()-1);
        dataset.remove(dataset.size()-1);
        return element;
    }

    public T peak(){
        if(dataset.isEmpty()) throw new EmptyStackException();
        return dataset.get(dataset.size()-1);
    }

    public boolean empty(){
        return dataset.isEmpty();
    }

    public int size(){
        return dataset.size();
    }

    public String toString(){
        return dataset.toString();
    }

    public int search(T obj){

        int level = -1;
        for(int i  = dataset.size()-1; i > -1 && level == -1; i--){
            if(dataset.get(i).equals(obj)){
                level = i+1;
            }
        }

        return level;
    }
}
