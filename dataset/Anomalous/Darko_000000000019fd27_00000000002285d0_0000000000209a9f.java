import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestingDepth {

    private void process() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = "0" + scanner.next() + "0";
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(ch);
            }

            String output = result.toString();
            System.out.printf("Case #%d: %s\n", caseNumber, output.substring(1, output.length() - 1));
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new NestingDepth().process();
    }
}