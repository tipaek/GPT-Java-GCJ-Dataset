// package codejam.q_2020;

import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {

        String s = "4\n" +
                "0000\n" +
                "101\n" +
                "111000\n" +
                "2223";

//        String s = "1\n" +
//                "97491";


        int T;
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(s);

        long time = System.currentTimeMillis();

        T = scan.nextInt();
        for (int t=1; t<=T; ++t) {
            StringBuffer S = new StringBuffer(scan.next());
            for (int n=9; n>=0; --n) {
                for (int i=0; i<S.length()-1; ++i) {
                    if (S.charAt(i) == (char)(n+48)) {
                        int n1 = S.charAt(i+1)-48;
                        for (int j=n1; j<n; ++j) S.insert(i+1, ')');
                    }
                }
            }
            for (int n=9; n>=0; --n) {
                for (int i=S.length()-1; i>0; --i) {
                    if (S.charAt(i) == (char)(n+48)) {
                        int n1 = S.charAt(i-1)-48;
                        if (n1>=0 && n1<=9) {
                            for (int j = n1; j < n; ++j) S.insert(i, '(');
                            i += (n-n1);
                        }
                    }
                }
            }

            int n = S.charAt(0)-48;
            for (int j = 0; j < n; ++j) S.insert(0, '(');

            n = S.charAt(S.length()-1)-48;
            for (int j = 0; j < n; ++j) S.append(')');

            System.out.println("Case #"+t+": " + S);
        }
    }
}
