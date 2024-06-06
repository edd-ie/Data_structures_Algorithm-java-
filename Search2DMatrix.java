/**
 * You are given an m x n integer matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */

public class Search2DMatrix {

        public static class Tree {
            private final Node root;

            public Tree(int[][] mat) {
                root = new Node(mat[0][0]);

                for(int row = 0; row < mat.length; row++){
                    int start = 0;
                    if(row == 0) start = 1;

                    for(;start < mat[row].length; start++){
                        addNode(root, mat[row][start]);
                    }
                }
            }

            public void addNode(Node current, int data){
                if(current.data > data){
                    if(current.left == null) current.left = new Node(data);
                    else addNode(current.left, data);
                }
                else{
                    if(current.right == null) current.right = new Node(data);
                    else addNode(current.right, data);
                }
            }

            public boolean search(Node current, int data){
                if(current == null) return false;
                if(current.data == data) return true;

                if(current.data > data) return search(current.left, data);
                else return search(current.right, data);
            }

            private static class Node {
                public int data;
                public Node left;
                public Node right;

                public Node(int data){
                    this.data = data;
                    left = null;
                    right = null;
                }
            }
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            Tree tree = new Tree(matrix);
            return tree.search(tree.root, target);
        }
}
