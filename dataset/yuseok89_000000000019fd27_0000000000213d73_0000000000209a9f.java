import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int test = 1; test <= T; ++test) {

            String s = in.next();

            int cur = 0;

            System.out.print("Case #" + test + ": ");

            for (char c: s.toCharArray()) {
                while (cur < (c - '0')) {
                    System.out.print('(');
                    ++cur;
                }

                while (cur > (c - '0')) {
                    System.out.print(')');
                    --cur;
                }

                System.out.print(c);
            }

            while (cur > 0) {
                System.out.print(')');
                --cur;
            }

            System.out.println();
        }
    }
}
