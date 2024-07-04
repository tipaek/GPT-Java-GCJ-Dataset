import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int targetSum = scanner.nextInt();
            scanner.nextLine();

            boolean isPossible = false;
            int value = 0;

            for (int i = 1; i <= size; i++) {
                if (targetSum == i * size) {
                    isPossible = true;
                    value = i;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    int currentValue = value - i;
                    if (currentValue <= 0) {
                        currentValue += size;
                    }
                    for (int j = 0; j < size; j++) {
                        if (currentValue > size) {
                            currentValue -= size;
                        }
                        System.out.print(currentValue++ + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}