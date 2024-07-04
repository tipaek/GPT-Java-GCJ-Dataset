import java.util.*;
import java.io.*;

public class SolutionCJ {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            String input = reader.readLine();
            List<Character> output = new ArrayList<>();
            long currentLevel = 0L;
            int length = input.length();

            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';

                if (currentLevel == digit) {
                    output.add((char) (digit + '0'));
                } else if (currentLevel > digit) {
                    while (currentLevel > digit) {
                        output.add(')');
                        currentLevel--;
                    }
                    output.add((char) (digit + '0'));
                } else {
                    while (currentLevel < digit) {
                        output.add('(');
                        currentLevel++;
                    }
                    output.add((char) (digit + '0'));
                }
            }

            while (currentLevel > 0) {
                output.add(')');
                currentLevel--;
            }

            result.append("Case #").append(caseNumber).append(": ");
            for (char ch : output) {
                result.append(ch);
            }
            result.append("\n");
            caseNumber++;
        }

        System.out.print(result);
    }
}