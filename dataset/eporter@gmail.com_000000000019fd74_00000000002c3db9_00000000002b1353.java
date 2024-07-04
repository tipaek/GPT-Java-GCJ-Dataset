import java.io.IOException;
import java.util.Scanner;

public class Solution {
    final Scanner in;
    static long [][] triangle = new long[502][502];
    static {
        triangle[1][1] = 1;
        for (int i = 2; i < 502; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
    }

    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
        scanner.close();
    }
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
    
    public Solution(Scanner in) {
        this.in = in;
    }
    
    private void runCase(int cs) {
        long n = in.nextInt();
        println(String.format("Case #%s:", cs));
        if (n <= 1000) {
            println("1 1");
            n--;
            int i = 2;
            for (; i-1 <= n; i++) {
                println(i + " " + 2);
                n -= i - 1;
            }
            i--;
            for (; n > 0; i++) {
                println(i + " " + 1);
                n -= 1;
            }
        } else {
            int i = 1;
            for (; i <= 7; i++) {
                println(i + " " + i);
                n -= triangle[i][i];
            }
            int col = 7;
            while (n > 0) {
                println(i + " " + col);
                n -= triangle[i][col];
                
                long lowerSum = 0;
                for (int c = 1; c <= col; c++) {
                    lowerSum += triangle[i+1][c];
                }
                if (lowerSum <= n) {
                    i++;
                    continue;
                }
                
                long curSum = 0;
                for (int c = 1; c <= col; c++) {
                    curSum += triangle[i][c];
                }
                if (curSum <= n && col > 1) {
                    col--;
                    continue;
                }
                
                i--;
                col--;
            }
        }
    }
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}