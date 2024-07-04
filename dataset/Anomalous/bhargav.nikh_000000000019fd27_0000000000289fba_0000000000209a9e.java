import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int nCases = Integer.parseInt(input[0]);
        int nBits = Integer.parseInt(input[1]);
        
        for (int i = 1; i <= nCases; i++) {
            if (!solve(i, nBits, br)) {
                break;
            }
        }
    }

    public boolean solve(int caseNo, int nBits, BufferedReader br) throws Exception {
        String[] result = new String[nBits + 1];
        int queryCount = 1;
        int bitIndex = 1;

        while (queryCount <= 150 && bitIndex <= nBits) {
            if (caseNo >= 2 && queryCount % 10 == 1) {
                System.out.println(bitIndex);
                System.out.flush();
                result[bitIndex] = br.readLine();
                bitIndex++;
                queryCount++;
            }
            if (bitIndex <= nBits) {
                System.out.println(bitIndex);
                System.out.flush();
                result[bitIndex] = br.readLine();
                bitIndex++;
                queryCount++;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= nBits; i++) {
            resultBuilder.append(result[i]);
        }
        
        System.out.println(resultBuilder.toString());
        System.out.flush();
        
        return br.readLine().equals("Y");
    }
}