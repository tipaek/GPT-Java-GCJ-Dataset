import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();

            int openParenthesis = 0;
            StringBuilder result = new StringBuilder(s.length() * 9);
            for(int j = 0; j < s.length(); ++j) {
                char c = s.charAt(j);
                int digit = Character.getNumericValue(c);

                if(openParenthesis < digit) {
                    for(; openParenthesis < digit; ++openParenthesis) {
                        result.append('(');
                    }
                } else if(openParenthesis > digit) {
                    for(; openParenthesis > digit; --openParenthesis) {
                        result.append(')');
                    }
                }

                result.append(c);
            }

            for(; openParenthesis > 0; --openParenthesis) {
                result.append(')');
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}
