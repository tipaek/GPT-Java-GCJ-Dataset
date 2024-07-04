import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private final static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Long x = in.nextLong();
            Long y = in.nextLong();
            String result = "S";
            if ((x % 2 != 0 && y % 2 != 0) || (x % 2 == 0 && y % 2 == 0)) {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}