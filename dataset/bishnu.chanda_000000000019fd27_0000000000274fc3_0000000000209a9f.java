import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String test = in.nextLine();
    int t = Integer.parseInt(test);  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ti = 1; ti <= t; ++ti) {
        String s = in.nextLine();
        String result = "";
        int lastDigit = Integer.parseInt("" + s.charAt(0));
        int numberOfBraces = lastDigit;
        for(int i = 0; i < numberOfBraces; i++) {
          result += "(";
        }
        result += "" + lastDigit;
        for(int i = 1; i < s.length(); i++) {
            int digit = Integer.parseInt("" + s.charAt(i));
            if(digit < lastDigit) {
                for(int j = 0; j < lastDigit-digit; j++) {
                    result += ")";
                }
            } else {
                for(int j = 0; j < digit - lastDigit; j++) {
                    result += "(";
                }
            }
            result += "" + digit;
            lastDigit = digit;
        }
        for(int j = 0; j < lastDigit; j++) {
            result += ")";
        }
        System.out.println("Case #" + ti + ": " + result);
    }
  }
}