import java.util.ArrayList;

public class Graph {

    private static class Node{
        public String data;
        public ArrayList<Node> childNodes;
        public ArrayList<Integer> childEdges;
        public boolean visited;

        public Node(String data){
            this.data = data;
            this.childEdges = new ArrayList<>();
            this.childNodes = new ArrayList<>();
            visited = false;
        }

        public void resetVisitAll() {
            visited = false;

            if(!childNodes.isEmpty()){
                for(Node child: childNodes) {
                    if(child.visited)
                        child.resetVisitAll();
                }
            }
        }

        public void addChild(Node child, Integer edge){
            childNodes.add(child);
            childEdges.add(edge);
        }

        public void addChild(String childData, Integer edge){
            childNodes.add(new Node(childData));
            childEdges.add(edge);
        }

        public Integer getChildEdge(String childData) throws Exception{
            int pos = 0;

            for(;pos < childNodes.size(); pos++){
                if(childNodes.get(pos).data.equals(childData)) break;
                if(pos == childNodes.size()-1) throw new Exception("Child Node not found!");
            }

            return childEdges.get(pos);
        }
    }
}
