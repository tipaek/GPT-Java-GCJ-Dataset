import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            long sum = x + y;
            long absSum = Math.abs(x) + Math.abs(y);

            if (sum % 2 == 0) {
                System.out.println("IMPOSSIBLE");
            } else if (absSum == 1) {
                if (x == 1) {
                    System.out.println("E");
                } else if (x == -1) {
                    System.out.println("W");
                } else if (y == 1) {
                    System.out.println("N");
                } else if (y == -1) {
                    System.out.println("S");
                }
            } else {
                long steps = 0;
                long power = 1;
                while (power < absSum) {
                    steps++;
                    power *= 2;
                }
                long totalSteps = (1L << steps) - 1;
                long diff = (totalSteps - sum) / 2;

                for (int i = 0; i < steps; i++) {
                    long currentStep = 1L << i;
                    if ((diff & currentStep) != 0) {
                        currentStep *= -1;
                    }
                    currentStep /= Math.abs(currentStep);

                    if (x % 2 != 0) {
                        if (currentStep < 0) {
                            System.out.print("W");
                        } else {
                            System.out.print("E");
                        }
                        x -= currentStep;
                    } else {
                        if (currentStep < 0) {
                            System.out.print("S");
                        } else {
                            System.out.print("N");
                        }
                        y -= currentStep;
                    }
                    x /= 2;
                    y /= 2;
                }
                System.out.println();
            }
        }
    }
}