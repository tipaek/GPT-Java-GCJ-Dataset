import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.exit;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        final int T = in.nextInt();
        final int B = in.nextInt();
        in.nextLine();

        if (B == 10) {
            
            for (int x = 1; x <= T; ++x) {
                
                final char[] b = new char[11];

                for (int q = 1; q <= 10; q++) {
                    System.out.println(q);
                    System.out.flush();

                    final String input = in.nextLine();
                    if (input.equals("N")) {
                        exit(1);
                    }
                    b[q] = (input.equals("0") ? '0' : '1');
                }

                System.out.println(String.valueOf(b).substring(1));
                System.out.flush();

                final String input = in.nextLine();
                if (!input.equals("Y")) {
                    exit(1);
                }
            }
            
        } else {
            exit(1);
        }
    }
}
