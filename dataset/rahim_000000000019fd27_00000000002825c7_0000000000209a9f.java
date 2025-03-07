import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            String processedString = processParenthesis(n);

            System.out.println("Case #"+i+": "+processedString);
        }
    }

    public static String processParenthesis(String value) {
        String processedString = "";
        char[] values = value.toCharArray();
        int previousValue = 0;
        for(int i = 0; i< values.length; i++) {
            int currentValue = Integer.parseInt(values[i]+"");
            if(currentValue > previousValue) {
                for(int j=0; j< currentValue-previousValue; j++) {
                    processedString += "(";
                }
                processedString += currentValue;
                for(int j=0; j< currentValue-previousValue; j++) {
                    processedString += ")";
                }
            } else {

                String pre = processedString.substring(0,processedString.length() - currentValue);
                String post = processedString.substring(processedString.length() - currentValue);

                processedString = pre + currentValue + post;
            }
            previousValue = currentValue;
        }
        return processedString;
    }
}