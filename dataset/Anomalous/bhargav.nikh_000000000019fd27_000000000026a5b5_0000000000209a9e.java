import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().processCases();
    }

    public void processCases() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int numberOfCases = Integer.parseInt(input[0]);
        int numberOfBits = Integer.parseInt(input[1]);

        for (int i = 1; i <= numberOfCases; i++) {
            if (!processCase(i, numberOfBits, reader)) {
                break;
            }
        }
    }

    public boolean processCase(int caseNumber, int numberOfBits, BufferedReader reader) throws IOException {
        int[] bits = new int[numberOfBits + 1];
        boolean foundResult = false;

        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex);
                reader.readLine();
                queryIndex++;
            }
            System.out.println(bitIndex);
            bits[bitIndex++] = Integer.parseInt(reader.readLine());
        }

        StringBuilder resultBuilder = new StringBuilder(numberOfBits);
        for (int i = 1; i <= numberOfBits; i++) {
            resultBuilder.append(bits[i]);
        }
        System.out.println(resultBuilder.toString());

        if ("Y".equals(reader.readLine())) {
            foundResult = true;
        }

        return foundResult;
    }
}