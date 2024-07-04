import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = sc.nextLine().trim().split("\\s+");
        int t = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int[][] bits = new int[4][b + 1];

        while (t-- > 0) {
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                System.out.flush();
                int bit = sc.nextLine().trim().charAt(0) - '0';
                bits[0][i] = bit;
                bits[1][b + 1 - i] = bit;
                bits[2][i] = 1 - bit;
                bits[3][b + 1 - i] = 1 - bit;
            }

            int queried = b;
            while (queried++ % 10 != 2) {
                System.out.println(1);
                System.out.flush();
                sc.nextLine();
            }

            int possible = 15;
            int remainingPossibilities = 4;
            int attempts = 3;

            while (attempts-- > 0 && remainingPossibilities > 1) {
                for (int i = 1; i <= b; i++) {
                    int sum = 0;
                    for (int j = 0; j < 4; j++) {
                        if ((possible & (1 << j)) != 0) {
                            sum += bits[j][i];
                        }
                    }
                    if (sum == 0 || sum == remainingPossibilities) continue;

                    System.out.println(i);
                    System.out.flush();
                    int bit = sc.nextLine().trim().charAt(0) - '0';
                    for (int j = 0; j < 4; j++) {
                        if ((possible & (1 << j)) != 0 && bits[j][i] != bit) {
                            possible &= ~(1 << j);
                            remainingPossibilities--;
                        }
                    }
                    if (remainingPossibilities == 1) break;
                }
            }

            for (int i = 0; i < 4; i++) {
                if ((possible & (1 << i)) == 0) continue;

                StringBuilder result = new StringBuilder();
                for (int j = 1; j <= b; j++) {
                    result.append(bits[i][j]);
                }
                System.out.println(result.toString());
                System.out.flush();
                char response = sc.nextLine().charAt(0);
                if (response == 'N') {
                    sc.close();
                    System.exit(0);
                }
                break;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}