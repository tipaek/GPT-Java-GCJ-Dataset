import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int target = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");
            if (target <= 501) {
                printSolution(target);
            }
        }
    }

    private static void printSolution(int target) {
        if (target == 501) {
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("3 2");
            for (int i = 4; i < 501; i++) {
                System.out.println((i - 1) + " 1");
            }
        } else {
            for (int i = 1; i <= target; i++) {
                System.out.println(i + " 1");
            }
        }
    }
}