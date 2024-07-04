
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            String s = in.next();
            StringBuilder ans = new StringBuilder();
            int startPos = 0;
            for (int i = 1; i < s.length(); i++) {
                int curr=s.charAt(i)-'0', prev=s.charAt(i-1)-'0';
                if (curr<prev) {
                    ans.append(brace(s.substring(startPos, i)));
                    startPos=i;
                    System.out.println("ans"+ans);
                }
            }
            ans.append(brace(s.substring(startPos)));
            System.out.printf("Case #%d: %s\n", i11+1, ans.toString());
        }
    }

    private static String brace(String num) {
        int max = num.charAt(num.length()-1)-'0', lastDrawn=0;
        StringBuilder builder = new StringBuilder();
        boolean putAll = false;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c=='0') {
                builder.append(c);
                continue;
            }
            if(!putAll)builder.append(numOfBrackets(max, '('));
            putAll = true;

            builder.append(c);
            if (i!=num.length()-1 && num.charAt(i+1)==c)continue;
            int gap = c-'0'-lastDrawn;
            System.out.println(gap);
            builder.append(numOfBrackets(gap, ')'));
            lastDrawn = c-'0';
        }
        return builder.toString();
    }
    private static String numOfBrackets(int i, char c) {
        StringBuilder builder = new StringBuilder(i);
        for (int j = 0; j < i; j++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
