import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nbCases = Integer.parseInt(bufferedReader.readLine());

        for(int iCase = 0; iCase < nbCases; iCase++) {
            String input = bufferedReader.readLine();
            String result = getParantheses(Integer.parseInt(String.valueOf(input.charAt(0))), '(');
            for(int iNumber = 0; iNumber < input.length()-1; iNumber++) {
                int next = iNumber+1;
                int n = Integer.parseInt("" + input.charAt(iNumber));
                int nPlusOne = Integer.parseInt("" + input.charAt(next));

                result += n;
                char paranthese = '(';

                if(n > nPlusOne) {
                    paranthese = ')';
                }

                result += getParantheses(Math.abs(n - nPlusOne), paranthese);
            }
            result += input.charAt(input.length()-1);
            result += getParantheses(Integer.parseInt("" + input.charAt(input.length()-1)),')');
            System.out.println("Case #" + (iCase + 1) + ": " + result);
        }
    }

    static String getParantheses(int number, char paranthese) {
        String parantheses = "";
        for(int iNumber = 0; iNumber < number; iNumber++) {
            parantheses += paranthese;
        }
        return parantheses;
    }
}
