import java.io.*;

class ABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 0;

        while (testCases > 0) {
            testCases--;
            caseNumber++;
            String input = br.readLine();
            int openParentheses = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int currentDigit = Character.getNumericValue(currentChar);

                if (i == 0) {
                    for (int j = 0; j < currentDigit; j++) {
                        result.append("(");
                        openParentheses++;
                    }
                } else {
                    char previousChar = input.charAt(i - 1);
                    int previousDigit = Character.getNumericValue(previousChar);

                    if (currentDigit > previousDigit) {
                        for (int j = 0; j < currentDigit - previousDigit; j++) {
                            result.append("(");
                            openParentheses++;
                        }
                    } else if (currentDigit < previousDigit) {
                        for (int j = 0; j < previousDigit - currentDigit; j++) {
                            result.append(")");
                            openParentheses--;
                        }
                    }
                }

                result.append(currentChar);
            }

            for (int j = 0; j < openParentheses; j++) {
                result.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}