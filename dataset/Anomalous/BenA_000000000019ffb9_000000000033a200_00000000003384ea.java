import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String[] directions = scanner.nextLine().split(" ");
            int left = Integer.parseInt(directions[0]);
            int right = Integer.parseInt(directions[1]);
            String result = findPosition(left, right);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    public static String findPosition(int left, int right) {
        return findPosition(left, right, 1);
    }

    public static String findPosition(int left, int right, int currentStep) {
        if (right > left) {
            if (currentStep > right) {
                return (currentStep - 1) + " " + left + " " + right;
            }
            return findPosition(left, right - currentStep, currentStep + 1);
        } else {
            if (currentStep > left) {
                return (currentStep - 1) + " " + left + " " + right;
            }
            return findPosition(left - currentStep, right, currentStep + 1);
        }
    }
}