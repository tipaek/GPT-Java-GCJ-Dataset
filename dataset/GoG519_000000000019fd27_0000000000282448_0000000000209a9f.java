import java.util.*;
import java.io.*;
public class Solution {
  private static void soln(String s, int caseNumber) {
        StringBuilder answer = new StringBuilder();
        int startIndex, d = 0, n = s.length();
        while (d < s.length()) {
            startIndex = d;
            while (d < s.length() && s.charAt(startIndex) == s.charAt(d)) ++d;
            String toBeNested = s.substring(startIndex, d);
            int digit = s.charAt(startIndex) - 48;
            for(int i = 0; i < digit; i++) answer.append('(');
            answer.append(toBeNested);
            for(int i = 0; i < digit; i++) answer.append(')');
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