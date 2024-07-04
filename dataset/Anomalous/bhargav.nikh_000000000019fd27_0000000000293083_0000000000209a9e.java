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

    public boolean solve(int caseNo, int nBits, BufferedReader br) throws Exception {
        String[] result = new String[nBits + 1];
        int bIdx = 1;

        for (int qIdx = 1; qIdx <= 150 && bIdx <= nBits; qIdx++) {
            if (qIdx % 10 == 1) {
                System.out.println(bIdx);
                System.out.flush();
                result[bIdx] = br.readLine();
                bIdx++;
                qIdx++;
            }
            if (bIdx <= nBits) {
                System.out.println(bIdx);
                System.out.flush();
                result[bIdx] = br.readLine();
                bIdx++;
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