import java.util.*;
import java.io.*;
import java. util. Collection;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc
    for (int p = 1; p <= t; p++) {
        String input = in.next();
        String string = "";
        int max = 0;
        int count = 0;
        int number;
        for (int j = 0; j < input.length(); j++) {
            number = Character.getNumericValue(input.charAt(j));
            if (number > count) {
                for (int k = 0; k < number - count; k++) {
                    string += "(";
                }
            } else if (number < count) {
                for (int k = 0; k < count - number; k++) {
                    string += ")";
                }
            }
            string += input.charAt(j);
            count = number;
        }
        for (int k = 0; k < count; k++) {
            string += ")";
        }
        
        System.out.println("Case #" + p + ": " + string);
    }
 }
}