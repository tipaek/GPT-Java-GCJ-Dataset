import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int nCases = Integer.parseInt(input[0]);
        int nBits = Integer.parseInt(input[1]);
        
        for (int caseIdx = 1; caseIdx <= nCases; caseIdx++) {
            if (!solveCase(caseIdx, nBits, br)) {
                break;
            }
        }
    }

    public boolean solveCase(int caseNo, int nBits, BufferedReader br) throws Exception {
        String[] bits = new String[nBits + 1];
        int queryCount = 0;
        int bitIndex = 1;

        while (queryCount <= 150 && bitIndex <= nBits) {
            if (queryCount % 10 == 0 && queryCount != 0) {
                System.out.println(bitIndex);
                System.out.flush();
                bits[bitIndex] = br.readLine();
                bitIndex++;
                queryCount++;
            }
            System.out.println(bitIndex);
            System.out.flush();
            bits[bitIndex] = br.readLine();
            bitIndex++;
            queryCount++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= nBits; i++) {
            result.append(bits[i]);
        }
        System.out.println(result.toString());
        System.out.flush();

        return br.readLine().equals("Y");
    }
}