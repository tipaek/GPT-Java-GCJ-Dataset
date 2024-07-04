import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int testCase;
        String[] result;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCase = Integer.parseInt(in.nextLine().trim());
        result = new String[testCase];
        for(int i=0; i<testCase; i++){
            String inputString = in.nextLine().trim();
            result[i] = getNewString(inputString);
        }
        for (int i = 0; i < testCase; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static String getNewString(String inputString) {
        StringBuilder newString = new StringBuilder(inputString.length() * 2);
        int openCount = 0;
        int prevCharAsInt = -1;
        char currentChar = inputString.charAt(0);

            for(int i=0; i<(currentChar - '0');i++) {
                newString.append('(');
                openCount = openCount + 1;
            }
            newString.append(currentChar);
            prevCharAsInt = currentChar - '0';

        for(int i=1; i<inputString.length(); i++) {
            currentChar = inputString.charAt(i);
            int value = ( currentChar - '0') - prevCharAsInt;
            if(value > 0) {
                for(int j=0; j < value; j++){
                    newString.append('(');
                    openCount = openCount + 1;
                }
                newString.append(currentChar);
            } else if(value < 0) {
                for(int j=0; j < (value * -1); j++){
                    newString.append(')');
                    openCount = openCount - 1;
                }
                newString.append(currentChar);
            } else
                newString.append(currentChar);
            prevCharAsInt = currentChar - '0';
        }
        for(int i=0; i<openCount; i++)
            newString.append(')');
        return newString.toString();
    }
}
