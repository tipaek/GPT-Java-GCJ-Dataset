import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }
    
    public void solveCases() throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().split(" ");
        
        int nCases = Integer.parseInt(input[0]);
        int nBits = Integer.parseInt(input[1]);
        
        for (int caseIndex = 1; caseIndex <= nCases; caseIndex++) {
            boolean isSolved = solve(caseIndex, nBits, scanner);
            if (!isSolved) {
                break;
            }
        }
    }
    
    public boolean solve(int caseNumber, int nBits, Scanner scanner) throws Exception {
        String[] result = new String[nBits + 1];
        int queryIndex = 1, bitIndex = 1;
        
        while (queryIndex <= 150 && bitIndex <= nBits) {
            System.out.println(bitIndex);
            System.out.flush();
            result[bitIndex] = scanner.nextLine();
            bitIndex++;
            queryIndex++;
        }
        
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= nBits; i++) {
            resultBuilder.append(result[i]);
        }
        
        System.out.println(resultBuilder.toString());
        System.out.flush();
        
        if (scanner.nextLine().equals("Y")) {
            return true;
        }
        
        return false;
    }
}