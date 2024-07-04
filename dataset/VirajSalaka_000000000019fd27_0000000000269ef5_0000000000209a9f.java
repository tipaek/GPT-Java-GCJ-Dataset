import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s  = in.nextLine();
            System.out.println("Case #" + i + ": " + getAnswer(s));

        }   
        
    }

    public static int[] getNumberArray(String s) {
        int[] arr = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            arr[i] = Integer.parseInt(s.substring(i,i+1));
        }
        return arr;
    }

    public static String nextPsString (int num, int next) {
        int diff = num - next;
        String result = String.valueOf(num);
        if (diff == 0) {
            return result;
        }
        if (diff > 0) {
            result =  result + new String(new char[diff]).replace("\0", ")");
        }
        if (diff < 0) {
            int temp = 0 - diff;
            result = result +  new String(new char[temp]).replace("\0", "(");
        }
        return result;
    }
    
    public static String startString( int num) {
        if (num == 0) {
            return "";
        } else {
            return new String(new char[num]).replace("\0", "(");
        }
    }

    public static String endString( int num) {
        if (num == 0) {
            return "";
        } else {
            return new String(new char[num]).replace("\0", ")");
        }
    }

    public static String getAnswer (String s) {
        String ans;
        int[] numbers = getNumberArray(s);
        ans = startString(numbers[0]);

        for ( int i = 0; i < numbers.length-1; i++) {
            ans += nextPsString(numbers[i], numbers[i+1]);
        }
        ans += String.valueOf(numbers[numbers.length-1]) + endString(numbers[numbers.length-1]);
        return ans;
    }
}
