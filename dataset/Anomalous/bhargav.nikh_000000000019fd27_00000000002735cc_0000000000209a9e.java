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

    public boolean solve(int caseNo, int nBits, BufferedReader br) throws Exception {
        String[] result = new String[nBits + 1];
        boolean resultFound = false;

        for (int queryIndex = 1, bitIndex = 1; queryIndex <= 150 && bitIndex <= nBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex);
                System.out.flush();
                result[bitIndex] = br.readLine();
                bitIndex++;
                queryIndex++;
            }
            System.out.println(bitIndex);
            System.out.flush();
            result[bitIndex] = br.readLine();
            bitIndex++;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= nBits; i++) {
            resultBuilder.append(result[i]);
        }

        System.out.println(resultBuilder.toString());
        System.out.flush();

        if (br.readLine().equals("Y")) {
            resultFound = true;
        }

        return resultFound;
    }
}