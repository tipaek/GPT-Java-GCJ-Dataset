import java.util.Scanner;

public class Solution {

    private static String getNestingDepthSol(String inputString) {
        
        String returnString = "";
        int openingBrackets = 0;
        int currentDigit;
        int difference;
        for (int j = 0; j < inputString.length(); j++) {
            currentDigit = Integer.parseInt(String.valueOf(inputString.charAt(j)));
            difference = currentDigit - openingBrackets;
            if (difference > 0) {
                while (difference > 0) {
                    returnString = returnString + "(";
                    difference = difference - 1;
                    openingBrackets++;
                }
            } else {
                difference = openingBrackets - currentDigit;
                while (difference > 0) {
                    returnString = returnString + ")";
                    difference = difference - 1;
                    openingBrackets--;
                }
            }
            returnString = returnString + (inputString.charAt(j));
        }
        while (openingBrackets > 0) {
            returnString = returnString + ")";
            openingBrackets--;
        }
        return returnString;    
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