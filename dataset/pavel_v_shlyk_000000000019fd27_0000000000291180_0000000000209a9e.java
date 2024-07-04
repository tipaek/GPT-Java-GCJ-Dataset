// package codejam.q_2020;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {

        String s = "1\n" +
                "10\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "Y";


        int T;
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(s);

        T = scan.nextInt();
        label:
        for (int t=1; t<=T; ++t) {
            int B=scan.nextInt();
            if (B==10) {
                StringBuffer answer = new StringBuffer();
                for (int i=1; i<=10; ++i) {
                    System.out.println(i);
                    System.out.flush();
                    answer.append(scan.next());
                }

                System.out.println(answer);
                System.out.flush();

                if (scan.next().equals("N")) System.exit(0);
            }
        }
    }
}
