import java.util.*;
import java.io.*;
public class Solution {
  private static void soln(String s, int caseNumber) {
        // StringBuilder answer = new StringBuilder();
        // int startIndex, d = 0, n = s.length();
        // while (d < s.length()) {
        //     startIndex = d;
        //     while (d < s.length() && s.charAt(startIndex) == s.charAt(d)) ++d;
        //     String toBeNested = s.substring(startIndex, d);
        //     int digit = s.charAt(startIndex) - 48;
        //     for(int i = 0; i < digit; i++) answer.append('(');
        //     answer.append(toBeNested);
        //     for(int i = 0; i < digit; i++) answer.append(')');
        // }
        // System.out.println(String.format("Case #%d: %s", caseNumber+1, answer.toString()));
        StringBuilder answer = new StringBuilder();
        int startIndex, d = 0, n = s.length(), lastNestingDepth = 0;
        while (d < s.length()) {
            startIndex = d;
            while (d < s.length() && s.charAt(startIndex) == s.charAt(d)) ++d;
            String toBeNested = s.substring(startIndex, d);
            int digit = s.charAt(startIndex) - 48;
            if(digit > lastNestingDepth) {
                for(int i = 0; i < digit; i++) answer.append('(');
                answer.append(toBeNested);
                for(int i = 0; i < digit; i++) answer.append(')');
                lastNestingDepth = digit;
            }
            else if (digit == 0) {
                lastNestingDepth = 0;
                answer.append(digit);
            }
            else {
                int pointer = answer.length() - 1, currNestingDepth = 0;
                for(; pointer > -1 && currNestingDepth < digit; --pointer) {
                    if(answer.charAt(pointer) == ')') ++currNestingDepth;
                    else break;
                }
                ++pointer;
                int brackets = digit - currNestingDepth;
                while (brackets > 0) {
                    answer.insert(pointer++, '(');
                    --brackets;
                }
                answer.insert(pointer, toBeNested);
                pointer += toBeNested.length();
                while (brackets < digit - currNestingDepth) {
                    answer.insert(pointer++, ')');
                    ++brackets;
                }
            }
        }
        System.out.println(String.format("Case #%d: %s", caseNumber+1, answer.toString()));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();in.nextLine();
        for(int i = 0; i < t; i++) {
            String c = in.nextLine();
            soln(c, i);
        }
    }
}