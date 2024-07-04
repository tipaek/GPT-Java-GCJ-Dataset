import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String x = in.next();
            StringBuilder y = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < x.length(); j++) {
                int digit = Character.getNumericValue(x.charAt(j));
                while (currentDepth < digit) {
                    y.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    y.append(")");
                    currentDepth--;
                }
                y.append(digit);
            }

            while (currentDepth > 0) {
                y.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + y.toString());
        }
    }
}