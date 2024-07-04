import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String result = NestingDepth(s);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String NestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        String pre = "";

        // parse each charactor
        int sLen = s.length();
        for(int i=0; i<sLen; i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            int digit2 = digit;
            // System.out.println(digit);

            int dLen = result.length()-1;
            int count = 0;
            String fbrackets = "";
            String bbrackets = "";

            while(digit2>0) {
                bbrackets += ")";

                int dLen2 = dLen-count;

                if(dLen2>=0) {
                    if(result.charAt(dLen2) == ')') {
                        result.deleteCharAt(dLen2);
                    }
                    else {
                        fbrackets += "(";
                    }
                }
                else {
                    fbrackets += "(";
                }

                count++;
                digit2--;
            }

            result.append(fbrackets);
            result.append(digit);
            result.append(bbrackets);
        }

        return result.toString();
    }
}
