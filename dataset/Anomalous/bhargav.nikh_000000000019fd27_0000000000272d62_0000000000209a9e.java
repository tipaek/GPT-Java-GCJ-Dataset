import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int numberOfCases = Integer.parseInt(input[0]);
        int numberOfBits = Integer.parseInt(input[1]);
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            if (!solve(caseIndex, numberOfBits, br)) {
                break;
            }
        }
    }

    public boolean solve(int caseNumber, int numberOfBits, BufferedReader br) throws Exception {
        String[] bits = new String[numberOfBits + 1];
        
        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            System.out.println(bitIndex);
            System.out.flush();
            bits[bitIndex] = br.readLine();
            bitIndex++;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfBits; i++) {
            resultBuilder.append(bits[i]);
        }
        
        System.out.println(resultBuilder.toString());
        System.out.flush();
        
        return br.readLine().equals("Y");
    }
}