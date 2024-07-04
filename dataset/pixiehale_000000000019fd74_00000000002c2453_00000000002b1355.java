import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static  class Node{
        int s;
        Node left;
        Node right;
        Node up;
        Node down;
        int sum;
        int c;
        boolean elim;
        public Node(int s) {
            this.s = s;
            elim = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append("Case #").append(i+1).append(": ");
            String str[] = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            Node a[][] = new Node[r][c];
            for (int j = 0; j < r; j++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < c; k++) {
                    a[j][k] = new Node(Integer.parseInt(str[k]));
                }
            }

            List<Node> elim = new ArrayList<>();
            long score = 0;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    Node node = a[j][k];
                    node.left = k>0?a[j][k-1]:null;
                    node.right = k<c-1?a[j][k+1]:null;
                    node.up = j>0?a[j-1][k]:null;
                    node.down = j<r-1?a[j+1][k]:null;
                    getAvg(node);
                    score+= node.s;
                    if (node.c!=0&&node.s*1.0<(node.sum*1.0)/node.c){
                        elim.add(node);
                        node.elim = true;
                    }
                }
            }
            long curScore = score;
            while (!elim.isEmpty()){
                List<Node> nextElim = new ArrayList<>();
                for (Node node : elim) {
                    remove(node);
                    curScore -= node.s;
                }
                score+=curScore;
                for (Node node : elim) {
                    checkAndAdd(node.left, nextElim);
                    checkAndAdd(node.right, nextElim);
                    checkAndAdd(node.up, nextElim);
                    checkAndAdd(node.down, nextElim);
                }
                elim = nextElim;
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }

    private static void checkAndAdd(Node node, List<Node> nextElim) {
        if (null==node||node.elim)
            return;
        getAvg(node);
        if (node.c!=0&&node.s*1.0<(node.sum*1.0)/node.c){
            node.elim = true;
            nextElim.add(node);
        }
    }

    private static void remove(Node node) {
        if (null!=node.left)
            node.left.right = node.right;
        if (null!= node.right)
            node.right.left=node.left;
        if (null!=node.up)
            node.up.down = node.down;
        if (null!=node.down)
            node.down.up = node.up;
    }

    private static void getAvg(Node node) {
        node.sum = 0;
        node.c=0;
        if (null!=node.left){
            node.c++;
            node.sum+=node.left.s;
        }
        if (null!=node.right){
            node.c++;
            node.sum+=node.right.s;
        }
        if (null!=node.up){
            node.c++;
            node.sum+=node.up.s;
        }
        if (null!=node.down){
            node.c++;
            node.sum+=node.down.s;
        }
    }
}
