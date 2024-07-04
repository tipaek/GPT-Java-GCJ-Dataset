import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        int T = Integer.parseInt(line);
        
        for (int t = 1; t <= T; t++) {
            line = stdin.readLine();
            String[] strs = line.split(" ");
            int R = Integer.parseInt(strs[0]);
            int S = Integer.parseInt(strs[1]);
            
            int A = (R - 1) * (S - 1);
            
            System.out.printf("Case #%d: %d\n", t, A);
            
            int n = R * S - 1 - R;
            for (int i = R; i > 1; i--) {
                for (int j = 0; j < S - 1; j++) {
                    System.out.printf("%d %d\n", i, n);
                    n--;
                }
            }
        }
    }
}

