import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().trim().split("\\s+");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);
        int[][] bitArrays = new int[4][bitLength + 1];

        // 0 - no change
        // 1 - reverse
        // 2 - complement
        // 3 - reverse and complement
        while (testCases-- > 0) {
            for (int i = 1; i <= bitLength; i++) {
                System.out.println(i);
                System.out.flush();
                int bit = scanner.nextLine().trim().charAt(0) - '0';
                bitArrays[0][i] = bit;
                bitArrays[1][bitLength + 1 - i] = bit;
                bitArrays[2][i] = 1 - bit;
                bitArrays[3][bitLength + 1 - i] = 1 - bit;
            }

            int queried = bitLength;
            while (queried++ % 10 != 1) {
                System.out.println(1);
                System.out.flush();
                scanner.nextLine();
            }

            int possibleCombinations = 15;
            int possibleCount = 4;
            for (int i = 1; i <= bitLength; i++) {
                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    if ((possibleCombinations & (1 << j)) != 0) {
                        sum += bitArrays[j][i];
                    }
                }
                if (sum == 0 || sum == possibleCount) continue;

                System.out.println(i);
                System.out.flush();
                int bit = scanner.nextLine().trim().charAt(0) - '0';
                for (int j = 0; j < 4; j++) {
                    if ((possibleCombinations & (1 << j)) == 0) continue;
                    if (bitArrays[j][i] != bit) {
                        possibleCombinations &= ~(1 << j);
                        possibleCount--;
                    }
                }
                if (possibleCount == 1) break;
            }

            for (int i = 0; i < 4; i++) {
                if ((possibleCombinations & (1 << i)) == 0) continue;

                StringBuilder result = new StringBuilder();
                for (int j = 1; j <= bitLength; j++) {
                    result.append(bitArrays[i][j]);
                }
                System.out.println(result.toString());
                System.out.flush();
                char response = scanner.nextLine().charAt(0);
                if (response == 'N') {
                    scanner.close();
                    System.exit(0);
                }
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}