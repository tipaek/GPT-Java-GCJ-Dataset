import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();
            scanner.nextLine();

            boolean isPossible = false;
            int value = 0;
            for (int i = 1; i <= size; i++) {
                if (sum == i * size) {
                    isPossible = true;
                    value = i;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    int currentValue = value - i;
                    if (currentValue <= 0) {
                        currentValue += size;
                    }
                    for (int j = 0; j < size; j++) {
                        if (currentValue > size) {
                            currentValue -= size;
                        }
                        System.out.print(currentValue++);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}