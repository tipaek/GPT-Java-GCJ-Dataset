import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            String inputString = reader.readLine();
            int openParentheses = 0;

            writer.write("Case #" + caseNumber + ": ");

            for (char ch : inputString.toCharArray()) {
                int currentDigit = ch - '0';
                int difference = currentDigit - openParentheses;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        writer.write("(");
                    }
                    openParentheses += difference;
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        writer.write(")");
                    }
                    openParentheses += difference;
                }

                writer.write(ch);
            }

            while (openParentheses-- > 0) {
                writer.write(")");
            }

            writer.write("\n");
            caseNumber++;
        }

        writer.flush();
    }
}