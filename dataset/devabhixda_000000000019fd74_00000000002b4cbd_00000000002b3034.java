import java.util.*;
import java.io.*;
public class Solution {
    public static String getLongestString(String[] array) {
        int maxLength = 0;
        String longestString = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }
    public static String getSmallestString(String[] array) {
        int maxLength = 101;
        String smallestString = null;
        for (String s : array) {
            if (s.length() < maxLength) {
                maxLength = s.length();
                smallestString = s;
            }
        }
        return smallestString;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] str = new String[n];
            for(int j=0;j<n;j++)
                str[j] = in.next();
            String longestString = getLongestString(str).substring(1);
            int len = str.length;
            for(String s : str) {
                if(longestString.indexOf(s.substring(1))<0 || s.charAt(s.length()-1)!=longestString.charAt(longestString.length()-1))
                    break;
                len--;
            }
            if(len>0)
                System.out.println("Case #" + i + ": " + "*");
            else
                System.out.println("Case #" + i + ": " + longestString);
        }
    }
}
  