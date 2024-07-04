import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }
    
    public void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        
        int totalCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);
        
        for (int caseIndex = 1; caseIndex <= totalCases; caseIndex++) {
            if (!processCase(caseIndex, bitLength, reader)) {
                break;
            }
        }
    }
    
    public boolean processCase(int caseNumber, int bitLength, BufferedReader reader) throws Exception {
        int[] bits = new int[bitLength + 1];
        
        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= bitLength; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex);
                reader.readLine();
                queryIndex++;
            }
            System.out.println(bitIndex);
            bits[bitIndex++] = Integer.parseInt(reader.readLine());
        }
        
        StringBuilder resultBuilder = new StringBuilder(bitLength);
        for (int i = 1; i <= bitLength; i++) {
            resultBuilder.append(bits[i]);
        }
        
        System.out.println(resultBuilder.toString());
        return reader.readLine().equals("Y");
    }
}