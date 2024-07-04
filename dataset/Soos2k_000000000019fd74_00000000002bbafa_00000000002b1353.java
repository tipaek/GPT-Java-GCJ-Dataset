import java.util.*;
public class Solution {
    static int[][] pascal;
    static class Node {
        public int x,y;
        public int val;
        public Node prev;
        public boolean[][] mark;
        public Node(int x,int y, int val, Node prev){
            this.x = x;
            this.y = y;
            this.prev = prev;
            this.val = val;
            this.mark = new boolean[30][30];
            mark[x][y] = true;
        }
        public Node(int x,int y, int val, Node prev, boolean[][] mark){
            this.x = x;
            this.y = y;
            this.prev = prev;
            this.val = val;
            this.mark = mark;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        pascal = new int[30][30];
        for (int i = 1; i < 30; i++){
            pascal[i][1] = 1;
        }
        for (int i = 2; i < 30; i++){
            for (int j = 2; j <= i; j++){
                pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
            }
        }
        // for (int i = 0; i < 10; i++){
        //     for (int j = 0; j < 10; j++){
        //         System.out.print(pascal[i][j]);
        //     }
        //     System.out.println();
        // }
        // Node node = findN(30);
        //     String result = "";
        //     while (node != null){
        //         result = "\n" + node.x + " " + node.y + " " + node.val + result;
        //         node = node.prev;
        //     }
        //     System.out.println(result);
        for (int i = 0; i < cases; i++){
            int n = sc.nextInt();
            Node node = findN(n);
            String result = "";
            while (node != null){
                result = "\n" + node.x + " " + node.y + result;
                node = node.prev;
            }
            results[i] = "Case #" + (i+1) + ":" + result;
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static Node findN(int n){
        Queue<Node> mark = new LinkedList<Node>();
        Node start = new Node(1,1,pascal[1][1],null);
        mark.add(start);
        while (!mark.isEmpty()){
            Node node = mark.poll();
            if (node.val == n) return node;
            //(x-1,y-1), (x-1,y), (x,y-1), (x,y+1), (x+1,y), (x+1,y+1)
            int xNode = node.x;
            int yNode = node.y;
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    if (!((i == -1 && j == 1) || (i == 1 && j == -1))){
                        if (!node.mark[xNode + i][yNode + j] && pascal[xNode + i][yNode + j] > 0){
                            int addVal = node.val + pascal[xNode + i][yNode + j];
                            boolean[][] copy = new boolean[30][30];
                            for (int m = 0; m < 30; m++){
                                for (int t = 0; t < 30; t++){
                                    copy[m][t] = node.mark[m][t];
                                }
                            }
                            copy[xNode + i][yNode + j] = true;
                            Node added = new Node(xNode + i,yNode + j,addVal,node,copy);
                            mark.add(added);
                        }
                    }
                }
            }
        }
        return null;
    }
}