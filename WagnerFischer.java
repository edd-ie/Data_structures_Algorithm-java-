import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WagnerFischer{
    BinaryTree dictionary;
    public WagnerFischer(){
        try {
            File file = new File("words.txt");
            Scanner words = new Scanner(file);
            dictionary = new BinaryTree();

            while (words.hasNextLine()){
                String word = words.nextLine();
                dictionary.insert(word);
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Error : " + e.getMessage());
        }
    }

    public String[][] run(String input){
        return dictionary.spellCheck(input);
    }


    private static class BinaryTree{
        private Node root;
        public BinaryTree(){
            root = null;
        }

        private static class Node{
            public String data;
            public Node left;
            public Node right;
            public Node(String data){
                this.data = data;
                left = null;
                right = null;
            }
        }

        public void insert(String data){
            Node addNode = new Node(data.toLowerCase());
            if(root == null){
                root = addNode;
            }
            else {
                addToTree(root, addNode);
            }
        }

        private void addToTree(Node current, Node addNode){
            int checks = current.data.compareTo(addNode.data);
            if(checks < 0){
                if(current.left != null) addToTree(current.left, addNode);
                current.left = addNode;
            }
            else if(checks > 0) {
                if(current.right != null) addToTree(current.right, addNode);
                current.right = addNode;
            }
        }

        public String[][] spellCheck(String word){
            String[][] output = new String[5][2];
            word = word.toLowerCase();
            Node current = root;
            boolean base =  false;

            while(!base){
                if(current.data.compareTo(word) < -5){
                    current = current.right;
                }
                else if(current.data.compareTo(word) > 5){
                    current = current.left;
                }
                else{
                    base = true;
                }
            }

            output = inOrderTransverse(output, current, word, 5);

            return output;
        }

        private String[][] inOrderTransverse(String[][] output, Node current, String word, int tracker){
            if(tracker != 0 && current != null){
                int value = word.compareTo(current.data);
                output[5-tracker] = new String[]{current.data, Integer.toString(value)};
                if(value < 0 && value > -5) output = inOrderTransverse(output, current.right, word, tracker - 1);
                if(value > 0 && value < 5) output = inOrderTransverse(output, current.left, word, tracker - 1);
            }

            return output;
        }

    }

}
