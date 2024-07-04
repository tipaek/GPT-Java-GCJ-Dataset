import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(String line){

        StringBuilder sb = new StringBuilder();


        int closeMe = 0;
        int lastNumericValue = 0;

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            int numericValue = Character.getNumericValue(currentChar);
            if (numericValue == 0) {
                for (int j = 0; j < closeMe; j++) {
                    sb.append(")");
                }
                closeMe = 0;
            } else {

                if (numericValue > lastNumericValue) {
                    for (int j = 0; j < numericValue - lastNumericValue; j++) {
                        sb.append("(");
                    }
                    closeMe += numericValue - lastNumericValue;
                } else if(numericValue < lastNumericValue){
                    for (int j = 0; j < lastNumericValue - numericValue; j++) {
                        sb.append(")");
                    }
                    closeMe -= lastNumericValue - numericValue;
                }


            }

            sb.append(numericValue);
            lastNumericValue = numericValue;

        }

        for (int j = 0; j < closeMe; j++) {
            sb.append(")");
        }
        closeMe = 0;

        return sb.toString();
    }



    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/qualification/nestingDepth/input.txt") : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            in.nextLine();
            for (int i = 1; i <= t; ++i) {

                String result = solve(in.nextLine());
                System.out.println("Case #" + i + ": " + result);
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
}