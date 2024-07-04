import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = sc.nextLine().trim().split("\\s+");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);
        int[][] bitArrays = new int[4][bitLength + 1];

        while (testCases-- > 0) {
            for (int i = 1; i <= bitLength; i++) {
                System.out.println(i);
                System.out.flush();
                int bit = sc.nextLine().trim().charAt(0) - '0';
                bitArrays[0][i] = bit;
                bitArrays[1][bitLength + 1 - i] = bit;
                bitArrays[2][i] = 1 - bit;
                bitArrays[3][bitLength + 1 - i] = 1 - bit;
            }

            int queries = bitLength;
            while (queries++ % 10 != 2) {
                System.out.println(1);
                System.out.flush();
                sc.nextLine();
            }

            int possibleConfigurations = 15;
            int remainingConfigs = 4;
            int checkCount = 4;

            while (checkCount-- > 0 && remainingConfigs > 1) {
                for (int i = 1; i <= bitLength; i++) {
                    int sum = 0;
                    for (int j = 0; j < 4; j++) {
                        if ((possibleConfigurations & (1 << j)) != 0) {
                            sum += bitArrays[j][i];
                        }
                    }
                    if (sum == 0 || sum == remainingConfigs) continue;

                    System.out.println(i);
                    System.out.flush();
                    int bit = sc.nextLine().trim().charAt(0) - '0';

                    for (int j = 0; j < 4; j++) {
                        if ((possibleConfigurations & (1 << j)) == 0) continue;
                        if (bitArrays[j][i] != bit) {
                            possibleConfigurations &= ~(1 << j);
                            remainingConfigs--;
                        }
                    }
                    if (remainingConfigs == 1) break;
                }
            }

            for (int i = 0; i < 4; i++) {
                if ((possibleConfigurations & (1 << i)) == 0) continue;

                StringBuilder result = new StringBuilder();
                for (int j = 1; j <= bitLength; j++) {
                    result.append(bitArrays[i][j]);
                }
                System.out.println(result.toString());
                System.out.flush();
                char response = sc.nextLine().charAt(0);
                if (response == 'N') {
                    sc.close();
                    System.out.close();
                    System.exit(0);
                }
                break;
            }
        }
        sc.close();
        System.out.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}