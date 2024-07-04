import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final long[] dp = {
        1, 1, 2, 3, 6, 10, 20, 35, 70, 126, 252, 462, 924, 1716, 3432, 6435, 
        12870, 24310, 48620, 92378, 184756, 352716, 705432, 1352078, 2704156, 
        5200300, 10400600, 20058300, 40116600, 77558760, 155117520, 300540195, 
        601080390, 1166803110
    };
    private static final int N = dp.length;

    public static void main(String[] args) {
        for (int i = 1; i < N; i++) {
            dp[i] += dp[i - 1];
        }
        
        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            out.println("Case #" + test + ":");
            
            long req = (long) (Math.log(n + 1) / Math.log(2));
            n -= (1 << req) - 1;
            
            for (int i = 1; i <= req; i++) {
                for (int j = 1; j <= i; j++) {
                    out.println(i + " " + j);
                }
            }
            
            for (long i = 0; i < n; i++) {
                out.println((++req) + " " + 1);
            }
        }
        
        out.flush();
        out.close();
    }
}