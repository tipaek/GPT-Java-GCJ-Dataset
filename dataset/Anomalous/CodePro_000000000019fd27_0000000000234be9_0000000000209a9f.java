import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String x = in.next();
            StringBuilder y = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < x.length(); j++) {
                int currentDigit = Character.getNumericValue(x.charAt(j));

                while (openBrackets < currentDigit) {
                    y.append("(");
                    openBrackets++;
                }
                while (openBrackets > currentDigit) {
                    y.append(")");
                    openBrackets--;
                }
                y.append(currentDigit);
            }
            
            while (openBrackets > 0) {
                y.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + y);
        }
    }
}