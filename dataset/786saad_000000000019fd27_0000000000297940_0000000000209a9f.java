import java.util.Scanner;

public class Solution {

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());

        String[] output = new String[numberOfCases];
        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();

            output[i] = "Case #" + (i + 1) + ": " + addParenthesis(input);
        }

        for (int i = 0; i < numberOfCases; i++) {
            System.out.println(output[i]);
        }
    }
    public static String addParenthesis(String input) {
        int currentlyOpenParas = 0;
        String outPutString = "";
        String paranthesis = "";
        for (int stringIndex = 0; stringIndex < input.length(); stringIndex++) {


            int currentNumber = Integer.parseInt("" + input.charAt(stringIndex));


            //count number of open para needed

            int openParaNeeded = 0;
            int closedParaNeeded = 0;
            if ( currentlyOpenParas < currentNumber ) {
                openParaNeeded = currentNumber - currentlyOpenParas;
            } else {
                //count number of closed para needed
                closedParaNeeded = currentlyOpenParas - currentNumber;;
            }

            if (openParaNeeded > 0) {
                for (int i = 0; i < openParaNeeded; i++) {
                    paranthesis += "(";
                    currentlyOpenParas++;
                }
                outPutString += paranthesis;
            }
            if (closedParaNeeded > 0) {
                for (int i = 0; i < closedParaNeeded; i++) {
                    paranthesis += ")";
                    currentlyOpenParas--;
                }
                outPutString += paranthesis;
            }
            outPutString += currentNumber;
            paranthesis = "";
        }
        for (int i = 0; i < currentlyOpenParas; i++) {
            paranthesis += ")";
        }
        currentlyOpenParas = 0; //after paranethesis are in return added
        return outPutString + paranthesis;
    }
}
