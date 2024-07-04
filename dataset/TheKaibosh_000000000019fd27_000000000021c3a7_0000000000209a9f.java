import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    static String s;
    static Node root;

    static int build(Node curr, int pos){
//        System.out.println(curr.num + ": " + pos);
        if (pos == s.length() || s.charAt(pos)<=curr.num) return pos;
        while (s.charAt(pos) -'0' >= curr.num+1) {
            Node child = new Node();
            child.num = curr.num+1;
            if (s.charAt(pos) -'0' == curr.num+1) {
                ++pos;
                child.print = true;
            }
            pos = build(child, pos);
            curr.children.add(child);
            if (pos == s.length()) return pos;
        }
        return pos;
    }

    static void recur(Node node) {
        if (node.print) System.out.print(node.num);
        if (node.children.size() > 0) {
            if (node.num>-1) System.out.print("(");
            for (Node child : node.children) recur(child);
            if (node.num>-1) System.out.print(")");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int ca = 1;ca<=t; ++ca){
            s = sc.nextLine();
            root = new Node();
            build(root, 0);
            System.out.print("Case #" + ca + ": ");
            recur(root);
            System.out.println();

        }

        sc.close();
    }

}

class Node {
    int num;
    boolean print;
    ArrayList<Node> children;
    Node(int num, boolean print) {this.num = num; this.print = print; children = new ArrayList<>();}
    Node() {num = -1; print = false; children = new ArrayList<>();}
}