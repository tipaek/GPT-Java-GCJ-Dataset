import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
    
    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;
    
    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }
    
    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int cases = Integer.parseInt(nextToken());
        for (int i = 1; i <= cases; i++) {
            int N = Integer.parseInt(nextToken());
            int[][] metric = new int[N][N];
            int trace = 0;
            int rows = N;
            int cols = N;
            for (int j = 0; j < N; j++) {
                String line = nextToken();
                String[] nums = line.split(" ");
                Set<Integer> rowSet = new HashSet<Integer>();
                for (int k = 0; k < nums.length; k++) {
                    metric[j][k] = Integer.parseInt(nums[k]);
                    wr.println(String.format("row is %d, col is %d, value is %d :", j, k, metric[j][k]));
                    rowSet.add(metric[j][k]);
                }
                if (rowSet.size() == N) {
                    rows --;
                }
                trace += metric[j][j];
            }
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<Integer>();
                for (int row = 0; row < N; row++) {
                    colSet.add(metric[row][col]);
                }
                if (colSet.size() == N) {
                    cols --;
                }
            }
            wr.println(String.format("Case #%d: %d %d %d", i, trace, rows, cols)); 
        }
        rd.close();
        wr.close();
    }
}