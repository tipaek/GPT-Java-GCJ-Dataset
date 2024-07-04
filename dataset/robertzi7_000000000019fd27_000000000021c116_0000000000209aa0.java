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
                        int num;
                        if (k % n == 0) { // Produce a diagonal of k/n after mod math
                            num = (k/n) - 1 - i + j + n;
                        } else { // Produce a diagonal from n to 1 after mod math
                            num = n + i + i + j;
                        }
                        System.out.print((num % n) + 1);
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