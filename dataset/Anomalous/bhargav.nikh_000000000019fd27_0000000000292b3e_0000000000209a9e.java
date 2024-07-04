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
        
        for (int i = 1; i <= nCases; i++) {
            if (!solve(i, nBits, br)) {
                break;
            }
        }
    }

    public boolean solve(int caseNumber, int nBits, BufferedReader br) throws Exception {
        String[] bits = new String[nBits + 1];
        
        for (int qIdx = 1, bitIdx = 1; qIdx <= 150 && bitIdx <= nBits; qIdx++) {
            if (qIdx % 10 == 1) {
                System.out.println(bitIdx);
                System.out.flush();
                bits[bitIdx] = br.readLine();
                bitIdx++;
                qIdx++;
            }
            if (bitIdx <= nBits) {
                System.out.println(bitIdx);
                System.out.flush();
                bits[bitIdx] = br.readLine();
                bitIdx++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= nBits; i++) {
            result.append(bits[i]);
        }
        System.out.println(result.toString());
        System.out.flush();

        return "Y".equals(br.readLine());
    }
}