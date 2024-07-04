import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int testCase = 1; testCase <= T; testCase++) {
            String S = in.nextLine();
            String str = "";
            int prev = 0;
            for (int i = 0; i < S.length(); i++) {
                int current = S.charAt(i) - 48;
                if (current > prev) {
                    for (int j = 0; j < current - prev; j++) {
                        str += "(";
                    }
                }
                if (current < prev) {
                    for (int j = 0; j < prev - current; j++) {
                        str += ")";
                    }
                }
                str += current;
                prev = current;
            }
            for (int j = 0; j < prev; j++) {
                str += ")";
            }
            System.out.println("Case #" + testCase + ": " + str);
        }
    }
}
