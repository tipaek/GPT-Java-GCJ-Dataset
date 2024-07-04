import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean [] [] columns = new boolean [N][N];
            int t = 0, r = 0, c = 0;
            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                boolean [] rows = new boolean [N];
                for(int k = 0; k < N; k++) {
                    int n = Integer.parseInt(st.nextToken());
                    if (j == k) {
                        t += n;
                    }
                    if (rows[n - 1]) {
                        r++;
                    }
                    rows[n-1] = true;
                    
                    if (columns[n-1][n-1]) {
                        c++;
                    }
                    columns[n-1][n-1] = true;
                }
            }
            bw.write("Case #" + i + ": " + t + " " + r + " " + c);
            bw.newLine();
        }
        
        bw.flush();
    }
}