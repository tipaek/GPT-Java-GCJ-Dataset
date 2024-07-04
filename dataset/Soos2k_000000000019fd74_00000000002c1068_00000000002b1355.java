import java.util.*;
public class Solution {
    static class Node {
        public int x;
        public int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row][col];
            for (int i1 = 0; i1 < row; i1++){
                for (int j1 = 0; j1 < col; j1++){
                    arr[i1][j1] = sc.nextInt();
                }
            }
            results[i] = "Case #" + (i+1) + ": " + interestLevel(arr);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static long interestLevel(int[][] arr){
        long sum = 0;
        boolean happen = true;
        while (happen){
            List<Node> mark = new ArrayList<>();
            happen = false;
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[0].length; j++){
                    if (arr[i][j] > 0){
                        sum += arr[i][j];
                        int count = 0;
                        int total = 0;
                        int rowLeft = j-1;
                        int rowRight = j+1;
                        int colUp = i-1;
                        int colDown = i+1;
                        while (rowLeft >= 0){
                            if (arr[i][rowLeft] > 0) {
                                total += arr[i][rowLeft];
                                count++;
                                break;
                            }
                            rowLeft--;
                        }
                        while (rowRight < arr[0].length){
                            if (arr[i][rowRight] > 0) {
                                total += arr[i][rowRight];
                                count++;
                                break;
                            }
                            rowRight++;
                        }
                        while (colUp >= 0){
                            if (arr[colUp][j] > 0) {
                                total += arr[colUp][j];
                                count++;
                                break;
                            }
                            colUp--;
                        }
                        while (colDown < arr.length){
                            if (arr[colDown][j] > 0) {
                                total += arr[colDown][j];
                                count++;
                                break;
                            }
                            colDown++;
                        }
                        if (total > 0){
                            int avg = (total % count == 0) ? total/count : total/count + 1;
                            if (arr[i][j] < avg){
                                happen = true;
                                mark.add(new Node(i,j));
                            }
                        }
                    }
                }
            }
            for (Node node : mark){
                arr[node.x][node.y] = 0;
            }
        }
        return sum;

    }
}