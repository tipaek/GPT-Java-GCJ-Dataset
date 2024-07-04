import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution {

    private static String getOpenParentheses(int n) {
        return String.join("", Collections.nCopies(n, "("));
    }

    private static String getCloseParentheses(int n) {
        return String.join("", Collections.nCopies(n, ")"));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int brackets=0;
            StringBuilder finalString = new StringBuilder();

            for(int idx=0;idx<n;idx++) {

                int numberValue = s.charAt(idx)-48;

                if(numberValue==brackets) {

                    finalString.append(s.charAt(idx));
                }
                else if(numberValue>brackets) {

                    int diff = numberValue-brackets;
                    finalString.append(getOpenParentheses(diff)).append(s.charAt(idx));
                    brackets = brackets+diff;
                }
                else {

                    int diff = brackets-numberValue;
                    finalString.append(getCloseParentheses(diff)).append(s.charAt(idx));
                    brackets=brackets-diff;

                }
            }

            if(brackets>0) {
                finalString.append(getCloseParentheses(brackets));
            }

            System.out.println(finalString.toString());

        }
    }
}