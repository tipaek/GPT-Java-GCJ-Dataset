
import java.util.*;
import java.io.*;
public class Solution {
    static Stack<String> PATH = new Stack<>();
    static int[] mvR = {1, 0, -1, -1, 0, 1};
    static int[] mvK = {1, 1, 0, -1, -1, 0};
    static int[][] COMB = new int[101][101], check= new int [101][101];
    public static void main(String[] args) {
        for(int i = 1 ; i <= 100 ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(i == 1 || i == 2 || j == 1 || i == j){
                    COMB[i][j] = 1;
                }else{
                    COMB[i][j] = COMB[i-1][j] + COMB[i-1][j-1];
                }
            }
        }

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            check= new int [101][101];
            PATH.clear();
            find(n, 1, 1);
            Stack<String> ANSWER = new Stack<>();
            while(!PATH.isEmpty()){
                ANSWER.push(PATH.pop());
            }
            System.out.println("Case #" + i + ":");
            while(!ANSWER.isEmpty()){
                System.out.println(ANSWER.pop());
            }
        }
    }

    private static boolean find(int rest, int r, int k) {
        if(rest == 0){
            return true;
        }
        if(r == 1  && k == 1){
            PATH.add("1 1");
            check[1][1] =1;
            if(find(rest - 1, 2,1))
                return true;
            return find(rest - 1, 2,2);
        }

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for(int i = 0 ; i < 5 ; i++) {
            int nR = r + mvR[i];
            int nK = k + mvK[i];
            if(check[nR][nK] == 1) continue;
            int value = COMB[nR][nK];
            nodes.add(new Node(nR, nK, value));
        }
        //System.out.println(nodes);

        for(Node n : nodes){
            if(n.val > rest) continue;
            if(n.val == 0) continue;

            check[r][k] = 1;
            PATH.push(r + " " + k);
            if(find(rest - COMB[r][k], n.x, n.y)){
                return true;
            }
            check[r][k] = 0;
            PATH.pop();
        }
        return false;
    }
}

class Node implements Comparable{
    int x, y, val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Object o) {
        return ((Node) o).val - this.val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", val=" + val +
                '}';
    }
}