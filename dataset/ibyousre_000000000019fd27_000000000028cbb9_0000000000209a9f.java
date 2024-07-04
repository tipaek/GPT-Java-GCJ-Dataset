
import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int ti=0;ti<t;ti++){
            String s = in.nextLine();
            solve(ti+1, s);
        }
    }
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){this.val = val;}
    }
    private static void solve(int t, String s){
        Node node = buildTree(s,0,s.length()-1);
        StringBuilder sb = new StringBuilder();
        traverse(node, sb,0);
        System.out.printf("Case #%d: %s%n", t, sb);
    }
    private static void traverse(Node root, StringBuilder sb, int currentDepth){
        if(root==null) return;
        for(int i=currentDepth;i<root.val;i++){
            sb.append("(");
        }
        traverse(root.left, sb, root.val);
        sb.append(root.val);
        traverse(root.right, sb, root.val);
        for(int i=currentDepth;i<root.val;i++){
            sb.append(")");
        }
        return;
    }
    private static Node buildTree(String s, int left, int right) {
        if(left>right) return null;
        int min = left;
        for(int i=left+1;i<=right;i++){
            if(s.charAt(i)<s.charAt(min))
                min = i;
        }
        Node node = new Node(s.charAt(min)-'0');
        node.left = buildTree(s, left, min-1);
        node.right = buildTree(s, min+1, right);
        return node;
    }
}