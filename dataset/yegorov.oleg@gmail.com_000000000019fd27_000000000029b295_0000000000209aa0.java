import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k % n != 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i);
                continue;
            }

            System.out.printf("Case #%d: POSSIBLE%n", i);
            int diagVal = k / n;

            for (int r = 0; r < n; r++) {
                for (int c=0; c < n; c++) {
                    int val = diagVal - r + c;
                    val = (val + n) % n == 0 ? n : (val + n) % n;

                    System.out.print(val);
                    if (c != n-1)
                        System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }
}

