import java.util.Scanner;

public class Solution {

    private static String getNestingDepthSol(String inputString) {
        
        String output = "";
        int openingBrackets = 0;
        int currDigit;
        int diff;
        for (int j = 0; j < inputString.length(); j++) {
            currDigit = Integer.parseInt(String.valueOf(inputString.charAt(j)));
            diff = currDigit - openingBrackets;
            if (diff > 0) {
                while (diff > 0) {
                    output = output + "(";
                    diff = diff - 1;
                    openingBrackets++;
                }
            } else {
                diff = openingBrackets - currDigit;
                while (diff > 0) {
                    output = output + ")";
                    diff = diff - 1;
                    openingBrackets--;
                }
            }
            output = output + (inputString.charAt(j));
        }
        while (openingBrackets > 0) {
            output = output + ")";
            openingBrackets--;
        }
        return output;
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCaseCount = scn.nextInt();

        String str;

        for (int i = 1; i <= testCaseCount; i++) {
            str = scn.next();
            System.out.println("Case #" + i + ": " + getNestingDepthSol(str));
        }
    }

}