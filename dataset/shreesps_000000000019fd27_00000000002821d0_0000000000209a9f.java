import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static String outputString = "Case #%d: %s";

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<String> inputs = new ArrayList<>();
        for(int i=0;i<testCases;i++) {
            String input = in.nextLine();
            inputs.add(input);
        }

        int tests = 1;
       for(String s : inputs) {
           StringBuilder stringBuilder = new StringBuilder();
           int openParenthesis = 0;
           int previous = -1;
           for (int i = 0; i < s.length(); i++) {
               String value = String.valueOf(s.charAt(i));
               int digit = Integer.parseInt(value);
               if (digit != previous) {
                   if (previous == -1 || digit > openParenthesis) {
                       int diff = digit - openParenthesis;
                       for (int count = 0; count < diff; count++) {
                           stringBuilder.append("(");
                           openParenthesis++;
                       }
                       stringBuilder.append(digit);
                   } else {
                       for (int count = 0; count <= openParenthesis - digit; count++) {
                           stringBuilder.append(")");
                           openParenthesis--;
                       }
                       stringBuilder.append(digit);
                   }
               } else {
                   stringBuilder.append(digit);
               }
               previous = digit;
           }
           for (int count = 0; count < openParenthesis; count++) {
               stringBuilder.append(")");
           }
           System.out.println(String.format(outputString, tests, stringBuilder.toString()));
           tests++;
       }
    }
}