import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numOfStrings = in.nextInt();
            String[] arrayOfStr = new String[numOfStrings];
            for (int k = 0; k < numOfStrings; k++) { 
                String inputtedWithAst = in.next();
                String inputted = inputtedWithAst.substring(1);
                int length = inputted.length();
                int j = k - 1; 
            while (j >= 0 && arrayOfStr[j].length() > length) { 
                    arrayOfStr[j+1] = arrayOfStr[j];
                    j = j - 1; 
                } 
                arrayOfStr[j+1] = inputted;
            }
            boolean isSubstring = true;
            for (int j = 0; j < numOfStrings - 1; j++) {
                if(arrayOfStr[j + 1].indexOf(arrayOfStr[j]) != arrayOfStr[j+1].length() - arrayOfStr[j].length()) {
                    isSubstring = false;
                    break;
                }
            }
            String result = "*";
            if(isSubstring) {
                result = arrayOfStr[numOfStrings - 1];
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}