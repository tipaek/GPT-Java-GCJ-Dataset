import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCase);
            } else {
                System.out.printf("Case #%d: POSSIBLE%n", testCase);
                int startValue = k / n;

                for (int i = 0; i < n; i++) {
                    int currentValue = startValue;
                    for (int j = 0; j < n; j++) {
                        if (currentValue == 0) {
                            currentValue = n;
                        }
                        System.out.print(currentValue + " ");
                        currentValue = (currentValue % n) + 1;
                    }
                    System.out.println();
                    startValue = (startValue == 0) ? n - 1 : startValue - 1;
                }
            }
        }
    }
}