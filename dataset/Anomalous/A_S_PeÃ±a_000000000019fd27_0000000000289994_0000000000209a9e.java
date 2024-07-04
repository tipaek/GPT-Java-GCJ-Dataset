import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static String processBits(int B) {
        int[] arr = new int[B];
        int match1 = -1, match2 = -1;
        int diff1 = -1, diff2 = -1;
        int queryCount = 0;

        for (int i = 0; i < B / 2; ++i) {
            ++queryCount;
            if (queryCount > 0 && queryCount % 10 == 1) {
                if (match1 > -1) {
                    System.out.printf("%d\n", match1 + 1);
                    int temp = scanner.nextInt();
                    ++queryCount;

                    if (arr[match1] != temp) {
                        for (int j = 0; j < i; ++j) {
                            arr[j] ^= 1;
                            arr[B - 1 - j] ^= 1;
                        }
                    }
                }

                if (diff1 > -1) {
                    System.out.printf("%d\n", diff1 + 1);
                    int temp = scanner.nextInt();
                    ++queryCount;

                    if (arr[diff1] != temp) {
                        for (int j = 0; j < i; ++j) {
                            int tmp = arr[j];
                            arr[j] = arr[B - 1 - j];
                            arr[B - 1 - j] = tmp;
                        }
                    }
                }

                if (queryCount % 2 == 1) {
                    System.out.printf("%d\n", diff1 + 1);
                    scanner.nextInt();
                }
            }

            System.out.printf("%d\n", i + 1);
            arr[i] = scanner.nextInt();

            System.out.printf("%d\n", B - i);
            arr[B - 1 - i] = scanner.nextInt();

            if (match1 < 0 && arr[i] == arr[B - 1 - i]) {
                match1 = i;
                match2 = B - 1 - i;
            } else if (diff1 < 0 && arr[i] != arr[B - 1 - i]) {
                diff1 = i;
                diff2 = B - 1 - i;
            }

            queryCount += 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B; ++i) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int i = 1; i <= T; ++i) {
            int B = scanner.nextInt();
            String result = processBits(B);
            System.out.printf("Case #%d: %s\n", i, result);
        }

        scanner.close();
    }
}