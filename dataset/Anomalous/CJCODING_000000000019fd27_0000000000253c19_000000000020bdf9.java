import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

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
            
            Arrays.sort(m, new Comparator<int[]>() {
                public int compare(final int[] entry1, final int[] entry2) {
                    return Integer.compare(entry1[0], entry2[0]);
                }
            });
            
            boolean flag = true;
            int c = m[0][1];
            int j = 0;
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
                out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                Arrays.sort(m, new Comparator<int[]>() {
                    public int compare(final int[] entry1, final int[] entry2) {
                        return Integer.compare(entry1[2], entry2[2]);
                    }
                });
                
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    s.append(m[i][3] == 1 ? 'C' : 'J');
                }
                out.println("Case #" + tc + ": " + s);
            }
        }
        
        out.flush();
        out.close();
    }
}