import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 0; tt < t; tt++) {
            String s = in.next();

            String result = "";
            int parentheses = 0;
            for (int i = 0; i < s.length(); i++) {
                int target = Integer.parseInt(s.substring(i, i + 1));
                if (target > 0 && target >= parentheses) {
                    while (target > parentheses) {
                        result += "(";
                        parentheses++;
                    }
                    result += target;
                } else if (target < parentheses) {
                    while (target < parentheses) {
                        result += ")";
                        parentheses--;
                    }
                    result += target;
                } else {
                    result += target;
                }
            }

            while (parentheses > 0) {
                result += ")";
                parentheses --;
            }

            System.out.println("Case #" + (tt + 1) + ": " + result);
        }
    }
}
