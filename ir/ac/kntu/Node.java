package ir.ac.kntu;

public class Node {
    
    int value;
    Node left;
    Node right;

    Node(Integer value){
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        
        String out = Character.toString(value);
        out += left == null ? " : NULL " : " : " + left.value;
        out += right == null ? " , NULL " : " , " + right.value;

        return out;
    }
}
