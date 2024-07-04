import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        int[] powersOfTwo = new int[32];
        powersOfTwo[0] = 1;
        for (int i = 1; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = powersOfTwo[i - 1] << 1;
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int currentCase = 1; currentCase <= numberOfCases; currentCase++) {
            int n = scanner.nextInt() - 1;
            System.out.printf("Case #%d:\n1 1\n", currentCase);

            if (n < 1500) {
                int row = 2;
                while (n >= powersOfTwo[row - 1]) {
                    if ((row & 1) == 0) {
                        for (int i = 1; i <= row; i++) {
                            System.out.printf("%d %d\n", row, i);
                        }
                    } else {
                        for (int i = row; i > 0; i--) {
                            System.out.printf("%d %d\n", row, i);
                        }
                    }
                    n -= powersOfTwo[row - 1];
                    row++;
                }

                if (n > 0) {
                    if ((row & 1) == 0) {
                        while (n-- > 0) {
                            System.out.printf("%d %d\n", row++, 1);
                        }
                    } else {
                        while (n-- > 0) {
                            System.out.printf("%d %d\n", row, row++);
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}