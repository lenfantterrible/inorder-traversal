package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list  = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        
        while(true){
            
            int num = scanner.nextInt();
            if(num == -1)
                break;
            list.add(num);
        }   

        BinaryTree tree = new BinaryTree(list);

        tree.build_tree();
        System.out.println(tree.print_tree(tree.root));

    }
}