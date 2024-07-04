import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; //Use with String.format - 1.: number of the test case, 2.:the string concatenation of the solution
    private static final String L_P = "("; //left parenthesis
    private static final String R_P = ")"; //right parenthesis
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); //number of test cases
        in.nextLine();
        for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            String inputDigitsStr = in.nextLine().trim();
            final int[] inputDigits = new int[inputDigitsStr.length()];
            for(int i=0; i<inputDigitsStr.length(); i++) {
                inputDigits[i] = Integer.parseInt(inputDigitsStr.substring(i, i+1));
            }
            //start of solution
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<inputDigits.length; i++) {
                int v = inputDigits[i]; //the current value
                if(v == 0) {
                    sb.append(v);
                }
                else {
                    //it needs to be surrounded exactly with v piece of matching parenthesis
                    if(i == 0) {
                        //if it is the first digit, we just do it
                        String str = surroundDigitWithParenthesis(v,v);
                        sb.append(str);
                    }
                    else {
                        int previousValue = inputDigits[i-1];
                        if(previousValue == v) {
                            //it can be moved between the parenthesis of the previous value, because they are same
                            //System.out.println(sb + " | length:" + sb.length() + ", prevVal:" + previousValue);
                            int prevValuePos = sb.lastIndexOf(""+previousValue);
                            sb.insert(prevValuePos+1, v);
                        }
                        else if(previousValue < v) {
                            int diff = v - previousValue;
                            int prevValuePos = sb.lastIndexOf(""+previousValue);
                            String str = surroundDigitWithParenthesis(diff,v);
                            sb.insert(prevValuePos+1, str);
                        }
                        else {
                            //v < previousValue 
                            int diff = previousValue - v;
                            sb.insert(sb.length()-diff, v);
                        }
                    }
                }
            }
            //end of solution
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, sb.toString()));
        } //end of test cases
    }
    
    /**
     * Helper function to create as many multiplication of the given string like left or right parenthesis as needed.
     * 
     * @param count
     * @param str
     * @return 
     */
    private static String multiplyStr(int count, String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    /**
     * Helper method to surround the digit with the needed matching parenthesis from both side
     * 
     * @param count
     * @param digit
     * @return 
     */
    private static String surroundDigitWithParenthesis(int count, int digit) {
        StringBuilder sb = new StringBuilder();
        String LEFT_PARENTHESIS = multiplyStr(count, L_P);
        String RIGHT_PARENTHESIS = multiplyStr(count, R_P);
        sb.append(LEFT_PARENTHESIS);
        sb.append(digit);
        sb.append(RIGHT_PARENTHESIS);
        return sb.toString();
    }
}