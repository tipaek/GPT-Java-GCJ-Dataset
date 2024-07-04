import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (t > 0) {
            t--;
            String input = br.readLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int currentDigit = currentChar - '0';
                int previousDigit = i > 0 ? input.charAt(i - 1) - '0' : 0;

                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append("(");
                        openBrackets++;
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(")");
                        openBrackets--;
                    }
                }
                result.append(currentChar);
            }

            for (int j = 0; j < openBrackets; j++) {
                result.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}