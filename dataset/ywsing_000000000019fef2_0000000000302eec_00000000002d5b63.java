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

        int ten9 = 1000000000;

        if (a >= ten9 - 5) {
            tc0:
            for (int case_ = 1; case_ <= t; ++case_) {
                int x = -5, y = -5;

                while (true) {
                    System.out.println(x + " " + y);

                    String s = in.nextLine();
                    if ("CENTER".equals(s)) continue tc0;
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
        } else if (a >= ten9 - 50) {
            String s;

            tc1:
            for (int case_ = 1; case_ <= t; ++case_) {
                int px0 = -50, pxx = +50;
                int py0 = -50, pyx = +50;
                int midx, midy;

                while (true) {
                    midx = (px0 + pxx) / 2;
                    midy = (py0 + pyx) / 2;
                    System.out.println(midx + " " + (midy - a));

                    if ("CENTER".equals(s = in.nextLine())) continue tc1;

                    if (s.equals("HIT")) {
                        pyx = midy;
                    } else {
                        py0 = midy + 1;
                    }

                    midx = (px0 + pxx) / 2;
                    midy = (py0 + pyx) / 2;
                    System.out.println((midx - a) + " " + midy);

                    if ("CENTER".equals(s = in.nextLine())) continue tc1;

                    if (s.equals("HIT")) {
                        pxx = midx;
                    } else {
                        px0 = midx + 1;
                    }

                    if (px0 == pxx && py0 == pyx) {
                        System.out.println(px0 + " " + py0);
                        if ("CENTER".equals(s = in.nextLine())) continue tc1;
                    }
                }
            }
        } else {
        }
    }

}
