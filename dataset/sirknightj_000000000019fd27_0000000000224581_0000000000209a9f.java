import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cases; i++) {
            String input = scanner.nextLine();
            String originalInput = input;

            while(!done(input)) {
                String turnIn = "";
                String nonZeroes = "";
                for(int j = 0; j < input.length(); j++) {
                    if(input.charAt(j) == '0') {
                        turnIn += sp(nonZeroes);
                        nonZeroes = "";
                        turnIn += "0";
                    } else {
                        nonZeroes += input.charAt(j);
                    }
                }
                if(nonZeroes.length() > 0) {
                    turnIn += sp(nonZeroes);
                }
                input = turnIn;
                input = decrement(input);
            }
            System.out.println("Case #" + (i + 1) + ": " + putBackOriginalNumbers(input, originalInput));
        }
    }

    /**
     * Places parenthesis around the string s, if it contains numbers.
     * @param s the string to place parenthesis around.
     * @return the string with parenthesis around it (or the same string, if no parenthesis needed to be added).
     */
    public static String sp(String s) {
        if(s.length() == 0) {
            return "";
        } else if(containsOnlyP(s)) {
            return s;
        } else {
            return "(" + s + ")";
        }
    }

    /**
     * Checks if the string s contains any numbers (1-9).
     * @param s the string to be checked
     * @return true iff the string contains no numbers from 1-9.
     */
    public static boolean done(String s) {
        for(char c : s.toCharArray()) {
            if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Decrements all of the numerical values by 1, leaving 0's as they are.
     * @param s the string to decrement the values of.
     */
    public static String decrement(String s) {
        String output = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '(' && s.charAt(i) != ')' && s.charAt(i) != '0') {
                output += (Integer.parseInt(String.valueOf(s.charAt(i))) - 1);
            } else {
                output += s.charAt(i);
            }
        }
        return output;
    }

    /**
     * @param s the string to be looked at.
     * @return true iff the string s only contains parenthesis.
     */
    public static boolean containsOnlyP(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ')' && s.charAt(i) != '(') {
                return false;
            }
        }
        return true;
    }

    /**
     * Substitutes each number 0 inside of put with the original. Assumes there are original.length 0's in put.
     * @param put the string to be substituted values for.
     * @param original the original values to substitute.
     * @return the new string with substituted values.
     */
    public static String putBackOriginalNumbers(String put, String original) {
        int count = 0;
        String output = "";
        for(int i = 0; i < put.length(); i++) {
            if(put.charAt(i) == '0') {
                output += original.charAt(count);
                count++;
            } else {
                output += put.charAt(i);
            }
        }
        return output;
    }
}
  