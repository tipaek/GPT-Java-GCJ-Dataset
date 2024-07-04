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
            if (!solveCase(caseIndex, numberOfBits, br)) {
                break;
            }
        }
    }

    public boolean solveCase(int caseNumber, int numberOfBits, BufferedReader br) throws Exception {
        String[] bits = new String[numberOfBits + 1];
        int bitIndex = 1;

        for (int queryIndex = 1; queryIndex <= 150 && bitIndex <= numberOfBits; queryIndex++) {
            if (queryIndex % 10 == 1) {
                System.out.println(bitIndex);
                br.readLine();  // Discard the result
                queryIndex++;
            }
            System.out.println(bitIndex);
            bits[bitIndex] = br.readLine();
            bitIndex++;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfBits; i++) {
            resultBuilder.append(bits[i]);
        }
        System.out.println(resultBuilder.toString());

        return br.readLine().equals("Y");
    }
}