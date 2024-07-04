import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = makeString(scanner.next());
            System.out.println("Case #" + i + ": " + s);
        }
    }
    
    public static String makeString(String s) {
        String result = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(Character.toString(s.charAt(i)));
            result += addStrings(num, left);
            left = num;
            int remainingRepeats = repeats(Character.toString(s.charAt(i)), s.substring(i, s.length()));
            for (int j = 0; j < remainingRepeats; j++) {
                result += num;
            }
            i += remainingRepeats;
        }
        for (int i = 0; i < left; i++) {
            result += ")";
        }
        return result;
    }
    
    public static int repeats(String num, String s) {
        int i = 0;
        while (i < s.length() - 1 && Character.toString(s.charAt(i + 1)).equals(num)) {
            i++;
        }
        return i;
    }
    
    public static String addStrings(int num, int left) {
        String toAdd = "";
        int parens = 0; 
        String paren = "(";
        if (num > left) {
            parens = num - left;
        } else {
            parens = left - num;
            paren = ")";
        }
        for (int i = 0; i < parens; i++) {
            toAdd += paren;
        }
        toAdd += num;
        return toAdd;
    }
} 