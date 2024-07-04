import java.io.BufferedReader;
import java.io.InputStreamReader;

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
            if (!solve(caseIndex, numberOfBits, br)) {
                break;
            }
        }
    }
    
    public boolean solve(int caseNumber, int numberOfBits, BufferedReader br) throws Exception {
        int[] bits = new int[numberOfBits + 1];
        
        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex);
                System.out.flush();
                br.readLine();
                queryIndex++;
            }
            System.out.println(bitIndex);
            System.out.flush();
            bits[bitIndex++] = Integer.parseInt(br.readLine());
        }
        
        StringBuilder resultBuilder = new StringBuilder(numberOfBits);
        for (int i = 1; i <= numberOfBits; i++) {
            resultBuilder.append(bits[i]);
        }
        System.out.print(resultBuilder.toString());
        System.out.flush();
        
        return br.readLine().equals("Y");
    }
}