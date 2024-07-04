import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            // Read size of the square
            String value = in.next();

            String result = "";

            int currentValue = 0;
            for (Character c: value.toCharArray()) {

                int newValue = (int) (c - '0');


                if(newValue == currentValue) {
                    result += c;
                } else {
                    if (newValue > currentValue) {
                        result = addChar(result, newValue - currentValue, '(') + c;
                    } else {
                        result = addChar(result, currentValue - newValue, ')') + c;
                    }
                }

                currentValue = newValue;
            }

            result = addChar(result, currentValue, ')');

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String addChar(String s, int n, char c) {
        for(int i = 0; i < n; i++) {
            s += c;
        }

        return s;
    }
}
  