import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

class Solution {

    private static String repeatCharacter(char ch, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int n = s.length();
            int openBrackets = 0;
            StringJoiner result = new StringJoiner("");

            for (int idx = 0; idx < n; idx++) {
                int currentDigit = s.charAt(idx) - '0';

                if (currentDigit == openBrackets) {
                    result.add(Character.toString(s.charAt(idx)));
                } else if (currentDigit > openBrackets) {
                    int diff = currentDigit - openBrackets;
                    result.add(repeatCharacter('(', diff)).add(Character.toString(s.charAt(idx)));
                    openBrackets += diff;
                } else {
                    int diff = openBrackets - currentDigit;
                    result.add(repeatCharacter(')', diff)).add(Character.toString(s.charAt(idx)));
                    openBrackets -= diff;
                }
            }

            if (openBrackets > 0) {
                result.add(repeatCharacter(')', openBrackets));
            }

            System.out.println(result.toString());
        }
    }
}