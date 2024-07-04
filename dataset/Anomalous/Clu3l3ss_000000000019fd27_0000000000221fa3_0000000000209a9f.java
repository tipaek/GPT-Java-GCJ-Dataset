import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            String inputString = reader.readLine();
            int length = inputString.length();
            int previousDepth = 0;

            for (int index = 0; index < length; index++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(index));
                int depthDifference = currentDigit - previousDepth;

                if (depthDifference > 0) {
                    System.out.print("(".repeat(depthDifference));
                } else if (depthDifference < 0) {
                    System.out.print(")".repeat(-depthDifference));
                }

                System.out.print(currentDigit);
                previousDepth = currentDigit;
            }

            System.out.print(")".repeat(previousDepth));
            System.out.println();
        }
    }
}