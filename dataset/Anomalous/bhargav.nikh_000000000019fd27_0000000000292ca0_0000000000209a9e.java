import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().processTestCases();
    }

    public void processTestCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int numberOfCases = Integer.parseInt(input[0]);
        int numberOfBits = Integer.parseInt(input[1]);

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            if (!processCase(caseIndex, numberOfBits, reader)) {
                break;
            }
        }
    }

    public boolean processCase(int caseNumber, int numberOfBits, BufferedReader reader) throws Exception {
        boolean isSolutionFound = false;
        String[] bits = new String[numberOfBits + 1];

        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex + 5);
                System.out.flush();
                bits[bitIndex + 5] = reader.readLine();
                bitIndex++;
                queryIndex++;
            }

            System.out.println(bitIndex);
            System.out.flush();
            bits[bitIndex] = reader.readLine();
            bitIndex++;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int index = 1; index <= numberOfBits; index++) {
            resultBuilder.append(bits[index]);
        }

        System.out.println(resultBuilder.toString());
        System.out.flush();

        if ("Y".equals(reader.readLine())) {
            isSolutionFound = true;
        }

        return isSolutionFound;
    }
}