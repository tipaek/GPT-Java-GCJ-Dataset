package CodeJam2020.Qualification;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsNum = sc.nextInt();
        int caseNum = 1;

        while (testsNum > 0) {
            String curr = sc.next();
            StringBuilder out = new StringBuilder();
            int i = 0;

            while (i < curr.length()) {
                if (curr.charAt(i) == '0') {
                    out.append('0');
                    i++;
                } else {
                    out.append('(');
                    while (i < curr.length() && curr.charAt(i) == '1') {
                        out.append('1');
                        i++;
                    }
                    out.append(')');
                }
            }

            System.out.println("Case #" + caseNum + ": " + out);
            testsNum--;
            caseNum++;
        }
    }
}