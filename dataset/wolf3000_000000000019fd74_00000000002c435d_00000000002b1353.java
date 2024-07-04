import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int size = 500;
        long[][] c = new long[size][size];
        c[0][0] = 1;

        for(int i=1;i<c.length;++i){
            long sum = 0;
            for(int j=0;j<=6;++j){
                if(j==0 || i==j){
                    c[i][j] = 1;
                }else{
                    c[i][j] = c[i-1][j-1] + c[i-1][j];
                }
            }
            //System.out.println(c[i][0]+" "+c[i][1] + " "+c[i][2]);
           // System.out.println(i+" "+sum);
        }

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.print("Case #" + i + ": " + solve(c, n));
        }

    }

    static Random r = new Random();

    private static String solve(long[][] c, int n) {
        int size = c.length;

      for(int i=498;i>=0;--i){
          for(int j=5;j>=0;--j) {
              //int row = r.nextInt(c.length);
              //int col = r.nextInt(row + 1);
              //System.out.println(row + " " + col + " " + c[row][col]);
              Queue<Integer> result = dfs(c, n, i, j);
              if (result.size() > 0) {
                  StringBuilder sb = new StringBuilder();
                  sb.append(System.lineSeparator());
                  while (result.size() > 0) {
                      sb.append(result.poll() + " " + result.poll());
                      sb.append(System.lineSeparator());
                  }
                  return sb.toString();
              }
          }
        }
        return "";
    }

    private static Queue<Integer> dfs(long[][] c, long sum, int sRow, int sCol) {
        if(c[sRow][sCol] > sum){
            return new ArrayDeque<>();
        }
        boolean[][] visited = new boolean[c.length][c.length];
        Queue<Integer> path = new ArrayDeque<Integer>();
        if (findPath(c, sum, visited, sRow, sCol, path)){
            return path;
        }
        return new LinkedList<>();
    }

    static int[][] delta = new int[][]{{-1,0},{-1,-1}};

    private static boolean findPath(long[][] c, long sum, boolean[][] visited, int row, int col, Queue<Integer> path) {
//        System.out.println(sum);
        if(sum == 1 && row == 0 && col == 0){
            path.add(1);
            path.add(1);
            return true;
        }
        if(col < 0|| row < 0 || col >=c.length || row>=c.length){
            return false;
        }
        if(visited[row][col] || c[row][col] ==0){
            return false;
        }

        if(c[row][col]==0 || sum - c[row][col] < 0){
            return false;
        }

        visited[row][col] = true;
        path.add(row + 1);
        path.add(col + 1);
        for(int[] d:delta){
            int nr = row + d[0];
            int nc = col + d[1];
            if(findPath(c, sum - c[row][col], visited , nr, nc, path)){
                return true;
            }
        }
        path.poll();
        path.poll();
        return false;
    }

}