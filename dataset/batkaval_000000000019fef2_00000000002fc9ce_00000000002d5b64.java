import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int s = in.nextInt();
            int r = in.nextInt();

            System.out.println("Case #" + i + ": " + ((r - 1) * (s - 1)));
            for (int b = s - 1; b >= 1; b--) {

                for (int j = 0; j < r -1; j++) {
                    int a = (b+1)*(r-1-j) + b*j;
                    System.out.println(a + " " + b);
                }
            }
        }
    }
}
