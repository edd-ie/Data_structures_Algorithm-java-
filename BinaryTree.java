public class BinaryTree{
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

    public Node getRoot(){
        return root;
    }

}
