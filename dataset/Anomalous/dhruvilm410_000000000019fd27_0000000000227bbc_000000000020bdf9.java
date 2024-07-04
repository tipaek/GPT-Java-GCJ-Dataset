package codejam;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] m = new int[n][4];
            
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                m[i][0] = Integer.parseInt(str.nextToken());
                m[i][1] = Integer.parseInt(str.nextToken());
                m[i][2] = i;
            }
            
            Arrays.sort(m, Comparator.comparingInt(entry -> entry[0]));
            
            int c = 0, j = 0;
            boolean flag = true;
            c = m[0][1];
            m[0][3] = 1;
            
            for (int i = 1; i < n; i++) {
                if (m[i][0] >= c) {
                    c = m[i][1];
                    m[i][3] = 1;
                } else if (m[i][0] >= j) {
                    j = m[i][1];
                    m[i][3] = 2;
                } else {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                Arrays.sort(m, Comparator.comparingInt(entry -> entry[2]));
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    s.append(m[i][3] == 1 ? 'C' : 'J');
                }
                System.out.println("Case #" + tc + ": " + s);
            }
        }
        
        out.flush();
        out.close();
    }
}