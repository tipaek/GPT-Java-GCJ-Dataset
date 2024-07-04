import java.util.Scanner;

public class Solution {

    static final Scanner SCANNER = new Scanner(System.in);

    static String solve(int B) {
        int[] arr = new int[B + 1];
        int matchIndex = -1;
        int diffIndex = -1;
        int queryCount = 0;
        int temp;

        for (int i = 1; i <= B / 2; ++i) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                if (matchIndex > -1) {
                    System.out.printf("%d\n", matchIndex);
                    temp = SCANNER.nextInt();
                    ++queryCount;
                    if (arr[matchIndex] != temp) {
                        for (int j = 0; j < i; ++j) {
                            arr[j] = ~arr[j];
                            arr[B - j + 1] = ~arr[B - j + 1];
                        }
                    }
                }

                if (diffIndex > -1) {
                    System.out.printf("%d\n", diffIndex);
                    temp = SCANNER.nextInt();
                    ++queryCount;
                    if (arr[diffIndex] != temp) {
                        for (int j = 0; j < i; ++j) {
                            temp = arr[j];
                            arr[j] = arr[B - j + 1];
                            arr[B - j + 1] = temp;
                        }
                    }
                }

                if (queryCount % 2 == 1) {
                    System.out.printf("%d\n", diffIndex);
                    temp = SCANNER.nextInt();
                }
            }

            System.out.printf("%d\n", i);
            arr[i] = SCANNER.nextInt();

            System.out.printf("%d\n", B - i + 1);
            arr[B - i + 1] = SCANNER.nextInt();

            if (matchIndex < 0 && arr[i] == arr[B - i + 1]) {
                matchIndex = i;
            } else if (diffIndex < 0 && arr[i] != arr[B - i + 1]) {
                diffIndex = i;
            }

            queryCount += 2;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= B; ++i) {
            result.append(arr[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int T = SCANNER.nextInt();
        int B = SCANNER.nextInt();

        for (int i = 1; i <= T; ++i) {
            String result = solve(B);
            System.out.printf("Case #%d: %s\n", i, result);
            String response = SCANNER.next();
            if (response.equals("N")) {
                System.exit(1);
            }
        }

        SCANNER.close();
    }
}