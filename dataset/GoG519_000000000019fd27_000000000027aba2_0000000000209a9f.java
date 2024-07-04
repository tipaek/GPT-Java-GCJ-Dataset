import java.util.*;
import java.io.*;
public class Solution {
  private static void soln(String s) {
        StringBuilder answer = new StringBuilder();
        int startIndex;
        for(int d = 0; d < s.length(); d++) {
            char character = s.charAt(d);
            int digit = s.charAt(d) - 48;
            startIndex = d++;
            while (d < s.length() && s.charAt(d) == character) ++d;
            StringBuilder nested = new StringBuilder();
            String temp = s.substring(startIndex, d);
            for(int i = 0; i < digit; i++) nested.append('(');
            nested.append(temp);
            for(int i = 0; i < digit; i++) nested.append(')');
            answer.append(nested.toString());
            d--;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();in.nextLine();
        for(int i = 0; i < t; i++) {
            String c = in.nextLine();
            soln(c);
        }
    }
}