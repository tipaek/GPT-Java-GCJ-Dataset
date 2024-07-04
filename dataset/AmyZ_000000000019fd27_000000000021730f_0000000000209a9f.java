import java.util.*;
import java.io.*;
//11:28
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            String n = in.nextLine();
            System.out.println("Case #" + i + ": " + getAnswer(n));
        }
    }

    public static String getAnswer(String n) {
       StringBuilder sb = new StringBuilder();
       char[] digits = n.toCharArray();
       int[] open = new int[digits.length];
       int[] close = new int[digits.length];
       int curr = 0;
       
       for(int i = 0; i < digits.length; i++) {
           int num = digits[i] - '0';
           if(num > curr) {
               open[i] += num - curr;
           } else if(num < curr) {
               close[i] += curr - num;
           }
           curr = num;
       }
       for(int i = 0; i < digits.length; i++) {
           int brac = open[i] != 0 ? open[i] : close[i];
           char bracT = open[i] != 0 ? '(' : ')';
           for(int b = 0; b < brac; b++) {
               sb.append(bracT);
           }
           sb.append(digits[i]);
       }
       for(int i = 0; i < curr; i++) {
           sb.append(')');
       }
       return sb.toString();
    }
}
