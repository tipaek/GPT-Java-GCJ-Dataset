import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String line = in.next();
            System.out.println("Case #" + i + ": " + solve(line));
        }
    }

    private static String solve(String line) {
        StringBuilder sb = new StringBuilder();
        int previous = 0;

        for (int i = 0; i < line.length(); i++) {
            int current = Integer.valueOf(line.charAt(i) + "");

            if (current > previous) {
                for (int j = 0; j < current - previous; j++) {
                    sb.append("(");
                }
            } else if (current < previous) {
                for (int j = 0; j < previous - current; j++) {
                    sb.append(")");
                }
            }
            sb.append(current);
            previous = current;
        }

        for (int j = 0; j < previous; j++) {
            sb.append(")");
        }
        return sb.toString();
    }
}