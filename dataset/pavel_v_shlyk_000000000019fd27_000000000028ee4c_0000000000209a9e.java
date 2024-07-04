// package codejam.q_2020;

import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {

        int T;
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(s);

        T = scan.nextInt();
        label:
        for (int t=1; t<=T; ++t) {
            int B=scan.nextInt();
            if (B==10) {
                StringBuffer answer = new StringBuffer();
                for (int i=1; i<=10; ++i) {
                    System.out.println(i);
                    System.out.flush();
                    answer.append(scan.nextInt());
                }

                System.out.println(answer);
                System.out.flush();
            }
        }
    }
}
