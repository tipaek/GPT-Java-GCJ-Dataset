import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int numberOfCases = Integer.parseInt(input[0]);
        int numberOfBits = Integer.parseInt(input[1]);
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            if (!solveCase(caseIndex, numberOfBits, br)) {
                break;
            }
        }
    }

    public boolean solveCase(int caseNumber, int numberOfBits, BufferedReader br) throws Exception {
        boolean isSolved = false;
        String[] bitResults = new String[numberOfBits + 1];
        int bitIndex = 1;

        for (int queryIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            System.out.println(bitIndex);
            System.out.flush();
            bitResults[bitIndex] = br.readLine();
            bitIndex++;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfBits; i++) {
            resultBuilder.append(bitResults[i]);
        }

        System.out.println(resultBuilder.toString());
        System.out.flush();

        if (br.readLine().equals("Y")) {
            isSolved = true;
        }

        return isSolved;
    }
}