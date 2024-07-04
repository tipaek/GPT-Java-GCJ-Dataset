import java.util.*;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static String solve(int B) {
        int[] arr = new int[B];
        int matchIndex = -1;
        int diffIndex = -1;
        int queryCount = 0;

        for (int i = 0; i < B / 2; ++i) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                if (matchIndex > -1) {
                    System.out.printf("%d\n", matchIndex);
                    int temp = scanner.nextInt();
                    ++queryCount;
                    if (arr[matchIndex] != temp) {
                        for (int j = 0; j < i; ++j) {
                            arr[j] = ~arr[j];
                            arr[B - j - 1] = ~arr[B - j - 1];
                        }
                    }
                }

                if (diffIndex > -1) {
                    System.out.printf("%d\n", diffIndex);
                    int temp = scanner.nextInt();
                    ++queryCount;
                    if (arr[diffIndex] != temp) {
                        for (int j = 0; j < i; ++j) {
                            int tempVal = arr[j];
                            arr[j] = arr[B - j - 1];
                            arr[B - j - 1] = tempVal;
                        }
                    }
                }

                if (queryCount % 2 == 1) {
                    System.out.printf("%d\n", diffIndex);
                    scanner.nextInt();
                }
            }

            System.out.printf("%d\n", i);
            arr[i] = scanner.nextInt();

            System.out.printf("%d\n", B - i - 1);
            arr[B - i - 1] = scanner.nextInt();

            if (matchIndex < 0 && arr[i] == arr[B - i - 1]) {
                matchIndex = i;
            } else if (diffIndex < 0 && arr[i] != arr[B - i - 1]) {
                diffIndex = i;
            }

            queryCount += 2;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < B; ++i) {
            result.append(arr[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String result = solve(B);
            System.out.printf("Case #%d: %s\n", i, result);
            String response = scanner.next();
            if (response.equals("N")) {
                System.exit(1);
            }
        }

        scanner.close();
    }
}