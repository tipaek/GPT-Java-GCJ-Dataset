import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static void debug(String message) {
        // Debugging is disabled, so this method does nothing
    }

    private static String process(Scanner scanner) {
        long L = scanner.nextLong();
        long R = scanner.nextLong();
        long difference = Math.abs(L - R);
        long n = (long) ((Math.sqrt(8 * difference + 1) - 1) / 2);
        
        if (L > R) {
            L -= n * (n + 1) / 2;
        } else {
            R -= n * (n + 1) / 2;
        }
        
        debug("A " + n + " " + L + " " + R);
        
        if (L > n || R > n) {
            long max = Math.max(L, R);
            long k = Math.max(0, (long) ((-(n + 1) + Math.sqrt((n + 1) * (n + 1) - 4 * (n - max))) / 2 - 10));
            debug("B " + k);
            
            if (k > 0) {
                if (L >= R) {
                    L -= (k + 1) * n + k * (k + 1);
                    R -= (k - 1) * n + k * (k - 1);
                } else {
                    R -= (k + 1) * n + k * (k + 1);
                    L -= (k - 1) * n + k * (k - 1);
                }
                n += 2 * k;
            }
        }
        
        while (L > n || R > n) {
            n++;
            if (L >= R) {
                L -= n;
            } else {
                R -= n;
            }
        }
        
        return n + " " + L + " " + R;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in.available() > 0 ? System.in : 
            new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.format("Case #%d: %s\n", i, process(scanner));
        }
    }
}