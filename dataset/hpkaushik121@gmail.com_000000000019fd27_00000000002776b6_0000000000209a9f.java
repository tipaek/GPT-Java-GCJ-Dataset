import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static String outputStr = "";
    private static String previousDigit = "0";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int cases = 1; cases <= testCases; cases++) {

            String input = scanner.nextLine();
            if (input.equals("")) {
                cases--;
                continue;
            }
            outputStr = "";
            for (int i = 0; i < input.length(); i++) {

                int digit = Integer.parseInt(input.charAt(i) + "");
                addRequiredOpenBrackets(digit);
                removeAddRequiredCloseBrackets(digit);
                previousDigit = input.charAt(i) + "";

            }
            while (outputStr.contains(")(")){
                outputStr=outputStr.replace(")(","");
            }
            System.out.println("Case #" + cases + ": " + outputStr);
        }
    }


    private static void addRequiredOpenBrackets(int digit) {
        StringBuilder builder = new StringBuilder(outputStr);
        for (int i = 0; i < digit; i++) {

            builder.append("(");


        }

        outputStr = builder.toString();
    }

    private static void removeAddRequiredCloseBrackets(int digit) {
        StringBuilder build = new StringBuilder(outputStr);
        build.append(digit);
        for (int i = 0; i < digit; i++) {
            build.append(")");
        }
        outputStr = build.toString();
    }

}
