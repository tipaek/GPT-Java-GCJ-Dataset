import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int testCaseValue = scanner.nextInt();
            System.out.println("Case #" + (testIndex + 1) + ":");

            for (int lineIndex = 0; lineIndex < testCaseValue; lineIndex++) {
                System.out.println("1 " + (lineIndex + 1));
            }
        }

        scanner.close();
    }
}