import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; ++i) {
            String str = scan.nextLine();
            str = "0" + str + "0";
            String res = "";
            for (int j = 1; j < str.length() - 1; ++j) {
                int d = str.charAt(j) - '0';
                int prevD = str.charAt(j - 1) - '0';
                int nextD = str.charAt(j + 1) - '0';
                if (d > prevD) {
                    for (int k = 0; k < d - prevD; ++k) res += "(";
                }
                res += d;
                if (d > nextD) {
                    for (int k = 0; k < d - nextD; ++k) res += ")";
                }
            }
            answer.append("Case #" + (i + 1) + ": " + res + "\n");
        }
        System.out.println(answer);
    }
}