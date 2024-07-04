import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();

        tc:
        for (int case_ = 1; case_ <= t; ++case_) {
            int x = -5, y = -5;

            while (true) {
                System.out.println(x + " " + y);

                String s = in.nextLine();
                if ("CENTER".equals(s)) continue tc;
                else {
                    boolean isHit = s.equals("HIT");

                    y++;
                    if (y == 6) {
                        x++;
                        y = -5;
                    }
                }
            }
        }
    }

}
