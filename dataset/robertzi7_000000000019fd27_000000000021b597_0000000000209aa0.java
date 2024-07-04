import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc
        in.nextLine();
        for (int cases = 1; cases <= t; ++cases) {
            int n = in.nextInt();
            int k = in.nextInt();

            if((n*(n-1))/2 == k || k%n == 0) {
                System.out.println("Case #" + cases + ": POSSIBLE");
                for(int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (k % n == 0) { // Draw a solution with digaonal all k/n
                            int base = k / n - 1; //needed due to 0 indexing for moding /w +1 later
                            System.out.print((((base - i + j) % n) + 1));
                            if (j < n - 1) System.out.print(" ");
                        } else { // Draw a solution with diagonal from n to 1
                            int base = n;
                            System.out.print((((base + i + j) % n) + 1));
                        }
                        if (j < n - 1) System.out.print(" ");
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("Case #" + cases + ": IMPOSSIBLE");
            }
        }
    }
}