import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            String[] P = new String[N];
            String[] P1 = new String[N];
            String largestString = "";
            int maxLength = 0;
            String smallestString = "";
            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                P[i] = s;
                P1[i] = s.replace("*", "");
                if (maxLength < P1[i].length()) {
                    largestString = P1[i];
                    maxLength = P1[i].length();
                }
                if (minLength > P1[i].length()) {
                    minLength = P1[i].length();
                    smallestString = P1[i];
                }
            }
            Arrays.sort(P1);
            System.out.print("Case #" + t + ": ");
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (!largestString.endsWith(P1[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(largestString);
            } else {
                System.out.println("*");
            }
        }
    }
}