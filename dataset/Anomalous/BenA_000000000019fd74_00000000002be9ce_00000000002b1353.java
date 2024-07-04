import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            System.out.println("Case #" + caseNumber + ":");
            processCase(Long.parseLong(scanner.nextLine()));
        }
    }

    public static void processCase(long n) {
        if (n <= 500) {
            for (long i = 1; i <= n; i++) {
                System.out.println(i + " 1");
            }
            return;
        }

        int steps = 4;
        long previousTotal = 10;
        long currentTotal = 10;

        while (currentTotal < n) {
            previousTotal = currentTotal;
            currentTotal = currentTotal + 1 + ((steps * (steps - 1)) / 2);
            steps++;
        }

        steps--;
        currentTotal = previousTotal;

        System.out.println("1 1");
        System.out.println("2 2");
        for (int i = 3; i <= steps; i++) {
            System.out.println(i + " 3");
        }
        System.out.println(steps + " 2");
        System.out.println(steps + " 1");

        while (currentTotal < n) {
            steps++;
            System.out.println(steps + " 1");
            currentTotal++;
        }
    }
}