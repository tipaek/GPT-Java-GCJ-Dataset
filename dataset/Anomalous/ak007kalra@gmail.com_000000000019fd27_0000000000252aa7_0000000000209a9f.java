import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= t; i++) {
                String s = reader.readLine();
                StringBuilder result = new StringBuilder();
                int openBrackets = 0;

                for (int j = 0; j < s.length(); j++) {
                    int digit = s.charAt(j) - '0';

                    while (openBrackets < digit) {
                        result.append('(');
                        openBrackets++;
                    }

                    while (openBrackets > digit) {
                        result.append(')');
                        openBrackets--;
                    }

                    result.append(digit);
                }

                while (openBrackets > 0) {
                    result.append(')');
                    openBrackets--;
                }

                System.out.println(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}