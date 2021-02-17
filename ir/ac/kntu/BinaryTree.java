package ir.ac.kntu;
import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTree {
    
    Node root;
    ArrayList<Integer> bfs; 

    public BinaryTree(ArrayList<Integer> bfs){


        // Make THE BFS STRING PERFECT with zeroes 
        for(int i=1; i <= bfs.size() ; i++){
            
            if(bfs.get(i - 1) == 0){

                if(2 * i - 1 < bfs.size() ){
                    bfs.add(2 * i - 1, 0);
                }

                if(2 * i < bfs.size()) {
                    bfs.add(2 * i, 0);
                }
            }
        }

        this.bfs = bfs;
    }


    void build_tree(){
        HashMap<Integer, Node> nodes_map = build_nodes(bfs);

        for(int i=1; i <= bfs.size(); i++){
            Node current = nodes_map.get(bfs.get(i-1));
        
            if(2 * i - 1 < bfs.size()) {
                current.left = bfs.get( 2 * i - 1 ) ==  0 ?  null : nodes_map.get(bfs.get( 2 * i - 1));
            }

            if(2 * i < bfs.size()) {
                current.right = bfs.get( 2 * i ) == 0 ?  null : nodes_map.get(bfs.get(2 * i));
            }
        }
        
    }

    public HashMap build_nodes(ArrayList<Integer> bfs){

        HashMap<Integer, Node> map = new HashMap<>();
        for(int i=0; i < bfs.size(); i++){
            Node node = new Node(bfs.get(i));
            map.put(bfs.get(i), node);
        }
        
        this.root = map.get(bfs.get(0));
        return map;
    }

    public String print_tree(Node root) { // should be IN-ORDER left root right
        
        if(root == null || root.value == 0){
            return "";
        }

        String out = root.left != null ? print_tree(root.left) + ", " : "";
        out += root.value;
        out += root.right != null ? ", " + print_tree(root.right) : "";
        

        return out;

    }

}
