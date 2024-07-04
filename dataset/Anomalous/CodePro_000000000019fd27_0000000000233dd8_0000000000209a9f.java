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
                if (digit > currentDepth) {
                    for (int k = 0; k < digit - currentDepth; k++) {
                        y.append('(');
                    }
                } else if (digit < currentDepth) {
                    for (int k = 0; k < currentDepth - digit; k++) {
                        y.append(')');
                    }
                }
                y.append(digit);
                currentDepth = digit;
            }

            for (int k = 0; k < currentDepth; k++) {
                y.append(')');
            }

            System.out.println(y.toString());
        }
    }
}