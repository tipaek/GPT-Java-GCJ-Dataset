import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int t = Integer.parseInt(in.readLine());
        for(int tt = 1; tt <= t; tt++) {
            int n = Integer.parseInt(in.readLine());
            int k = 0, r = 0, c = 0;
            int[][] matrix = new int[n][n];
            HashSet<Integer>[] rows = new HashSet[n];
            HashSet<Integer>[] cols = new HashSet[n];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                rows[i] = new HashSet<Integer>();
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if(i == j) k += matrix[i][j];
                    if(cols[j] == null) cols[j] = new HashSet<Integer>();
                    cols[j].add(matrix[i][j]);                    
                    rows[i].add(matrix[i][j]);                    
                }
            }
            for(int i = 0; i < n; i++) {
                if(cols[i].size() != n) c++;
                if(rows[i].size() != n) r++;
            }
            out.println("Case #" + tt + ": " + k + " " + r + " " + c);
        }
        out.close();
    }
}