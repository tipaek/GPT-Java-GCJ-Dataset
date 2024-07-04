import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            processTestCase(testIndex, n1, n2);
        }
    }

    private static void processTestCase(int testIndex, int n1, int n2) {
        StringBuilder result = new StringBuilder("Case #").append(testIndex).append(": ");
        StringBuilder directions = new StringBuilder();

        if ((Math.abs(n1) % 2 + Math.abs(n2) % 2) != 1) {
            result.append("IMPOSSIBLE");
            System.out.println(result);
            return;
        }

        int powerSum = 0;
        int powerIndex = 0;

        while (powerSum < Math.abs(n1) + Math.abs(n2)) {
            powerSum += (1 << powerIndex);
            powerIndex++;
        }

        powerIndex--;

        for (int i = powerIndex; i >= 0; i--) {
            int currentPower = 1 << i;

            if (Math.abs(n1) > Math.abs(n2)) {
                if (n1 > 0) {
                    n1 -= currentPower;
                    directions.insert(0, 'E');
                } else {
                    n1 += currentPower;
                    directions.insert(0, 'W');
                }
            } else {
                if (n2 > 0) {
                    n2 -= currentPower;
                    directions.insert(0, 'N');
                } else {
                    n2 += currentPower;
                    directions.insert(0, 'S');
                }
            }
        }

        if (n1 != 0 || n2 != 0) {
            result.append("IMPOSSIBLE");
        } else {
            result.append(directions);
        }

        System.out.println(result);
    }
}