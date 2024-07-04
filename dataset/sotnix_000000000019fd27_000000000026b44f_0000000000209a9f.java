import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int testCases = Integer.parseInt(s);
        int caseNr = 1;
        while(testCases > 0)
        {
            s = br.readLine();
            char[] digits = s.toCharArray();
            braces(digits,caseNr);

            caseNr++;
            testCases--;
        }



    }

    private static void braces(char[] digits, int caseNr )
    {
        int braceStack = 0;
        StringBuilder finalString = new StringBuilder();

        for (char digit: digits) {
            while (Character.getNumericValue(digit) > braceStack) {
                braceStack++;
                finalString.append("(");
            }
            while ( Character.getNumericValue( digit) < braceStack) {
                braceStack--;
                finalString.append(")");
            }

            finalString.append(digit);
        }

        for(int i= 0; i < braceStack; i++)
        {
            finalString.append(")");
        }
        System.out.println("Case #"+ caseNr +": " + finalString.toString());
    }
}