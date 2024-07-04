import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] rowHas = new boolean[n][n];
            boolean[][] colHas = new boolean[n][n];
            boolean[] rowDup = new boolean[n];
            boolean[] colDup = new boolean[n];
            int rowCount = 0;
            int colCount = 0;
            int trace = 0;
            for (int r = 0; r < n; r ++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c ++) {
                    int e = Integer.parseInt(st.nextToken());
                    if (!rowDup[r]) {
                        if (!rowHas[r][e - 1]) {
                            rowHas[r][e - 1] = true;
                        } else {
                            rowDup[r] = true;
                            rowCount ++;
                        }
                    }
                    if (!colDup[c]) {
                        if (!colHas[c][e - 1]) {
                            colHas[c][e - 1] = true;
                        } else {
                            colDup[c] = true;
                            colCount ++;
                        }
                    }
                    if (r == c) {
                        trace += e;
                    }
                }
            }
            System.out.println("Case #" + Integer.toString(i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}