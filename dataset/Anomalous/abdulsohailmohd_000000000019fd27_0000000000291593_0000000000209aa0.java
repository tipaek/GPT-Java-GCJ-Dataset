import java.io.*;
import java.util.*;

public class Solution {
    
    public static boolean isPossible(int n, int k) {
        for (int m = 1; m <= n; m++) {
            if (k == m * n) {
                return true;
            }
        }
        return false;
    }
    
    public static int getNext(int num, int n) {
        return (num - 1 > 0) ? num - 1 : n;
    }
    
    public static String getIndicium(int n, int k) {
        if (isPossible(n, k)) {
            StringBuilder res = new StringBuilder("POSSIBLE");
            int next = k / n;
            
            for (int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder(String.valueOf(next));
                for (int j = 1; j < n; j++) {
                    next = getNext(next, n);
                    row.append(" ").append(next);
                }
                res.append("\n").append(row);
            }
            
            return res.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            String res = getIndicium(n, k);

            System.out.println("Case #" + i + ": " + res);
        }
    }
}