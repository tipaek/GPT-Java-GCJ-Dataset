/*
 * Created by cravuri on 4/3/20
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String S = sc.next();
            StringBuilder sb = new StringBuilder();
            int curOpen = 0;
            for (int i = 0; i < S.length(); i++) {
                int num = S.charAt(i) - '0';
                if (num > curOpen) {
                    for (int j = 0; j < num - curOpen; j++) {
                        sb.append("(");
                    }
                } else if (num < curOpen) {
                    for (int j = 0; j < curOpen - num; j++) {
                        sb.append(")");
                    }
                }
                curOpen = num;
                sb.append(num);
            }
            for (int i = 0; i < curOpen; i++) {
                sb.append(")");
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

}
