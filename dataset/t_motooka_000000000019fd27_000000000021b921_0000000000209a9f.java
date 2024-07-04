import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            String s = in.next();
            testCase(s);
        }
    }
    private static void testCase(String s) {
        StringBuilder result = new StringBuilder();
        int len = s.length();
        int prev = 0;
        for(int i=0; i<len; i++) {
            int digit = Integer.parseInt(s.substring(i, i+1));
            if(digit > prev) {
                result.append(getRepeatedParenthesis(true, digit-prev));
            }
            else if(prev > digit) {
                result.append(getRepeatedParenthesis(false, prev-digit));
            }
            result.append(digit);
            prev = digit;
        }
        if(prev>0) {
            result.append(getRepeatedParenthesis(false, prev));
        }
        

        System.out.print(result.toString());
        System.out.println();
    }
    private static Map<Integer, String> open = new HashMap<>();
    private static Map<Integer, String> close = new HashMap<>();
    private static String getRepeatedParenthesis(boolean isOpen, int count) {
        Map<Integer, String> cache = isOpen ? open : close;
        if(cache.containsKey(count)) {
            return cache.get(count);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(isOpen ? '(' : ')');
        }
        cache.put(count, sb.toString());
        return sb.toString();
    }
}