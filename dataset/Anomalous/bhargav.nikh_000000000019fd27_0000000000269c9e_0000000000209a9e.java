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

        for (int caseIndex = 1; caseIndex <= nCases; caseIndex++) {
            if (!solve(caseIndex, nBits, br)) {
                break;
            }
        }
    }

    public boolean solve(int caseNumber, int nBits, BufferedReader br) throws Exception {
        int[] result = new int[nBits + 1];
        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= nBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                br.readLine();
                queryIndex++;
            }
            result[bitIndex++] = Integer.parseInt(br.readLine());
        }

        StringBuilder resultBuilder = new StringBuilder(nBits);
        for (int i = 1; i <= nBits; i++) {
            resultBuilder.append(result[i]);
        }
        System.out.println(resultBuilder.toString());

        return br.readLine().equals("Y");
    }
}