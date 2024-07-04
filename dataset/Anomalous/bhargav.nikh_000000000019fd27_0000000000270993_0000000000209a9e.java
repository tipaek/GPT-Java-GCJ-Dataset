import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    public void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        
        int numberOfCases = Integer.parseInt(input[0]);
        int numberOfBits = Integer.parseInt(input[1]);
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            if (!handleCase(caseIndex, numberOfBits, reader)) {
                break;
            }
        }
    }

    public boolean handleCase(int caseNumber, int numberOfBits, BufferedReader reader) throws Exception {
        boolean isSolutionFound = false;
        String[] bits = new String[numberOfBits + 1];
        
        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex);
                reader.readLine();
                queryIndex++;
            }
            System.out.println(bitIndex);
            bits[bitIndex] = reader.readLine();
            bitIndex++;
        }
        
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfBits; i++) {
            resultBuilder.append(bits[i]);
        }
        
        System.out.print(resultBuilder.toString());
        
        if (reader.readLine().equals("Y")) {
            isSolutionFound = true;
        }
        
        return isSolutionFound;
    }
}