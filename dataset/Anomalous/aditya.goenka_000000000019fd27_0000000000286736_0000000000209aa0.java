import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();
            scanner.nextLine();

            boolean isPossible = false;
            int value = 0;

            for (int i = 1; i <= size; i++) {
                if (sum == i * size) {
                    isPossible = true;
                    value = i;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    int startValue = value + i;
                    if (startValue > size) {
                        startValue -= size;
                    }
                    for (int j = 0; j < size; j++) {
                        if (startValue <= 0) {
                            startValue += size;
                        }
                        System.out.print(startValue-- + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}