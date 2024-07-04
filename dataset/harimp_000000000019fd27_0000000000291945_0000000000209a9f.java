import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int x = 1; x <= t; x++) {
            String digits = in.nextLine();
            int depth = 0;
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                int digit = Integer.valueOf(digits.substring(i, i+1)).intValue();
                if (depth < digit) {
                    for (int j = 0; j < (digit - depth); j++) {
                        answer.append("(");
                    }
                } else if (depth > digit) {
                    for (int j = 0; j < (depth - digit); j++) {
                        answer.append(")");
                    }
                }
                depth = digit;
                answer.append(digit);
            }
            
            while (depth > 0) {
                answer.append(")");
                depth--;
            }
            
            System.out.println(
                String.format("Case #%d: %s", x, answer.toString()));
        }
    }
}
  