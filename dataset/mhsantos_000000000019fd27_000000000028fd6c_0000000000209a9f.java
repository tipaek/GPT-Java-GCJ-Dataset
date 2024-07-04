import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            String s = in.nextLine();
            int n = s.length();
            int openBrackets = 0;
            for (int d = 0; d < n; d++) {
                int digit = Character.getNumericValue(s.charAt(d));
                while (openBrackets < digit) {
                    sb.append("(");
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    sb.append(")");
                    openBrackets--;
                }
                sb.append(digit);
            }
            while (openBrackets > 0) {
                sb.append(")");
                openBrackets--;
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

}