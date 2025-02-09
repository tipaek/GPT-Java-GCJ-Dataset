import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();

            if (n <= 501) {
                System.out.println("Case #" + (i + 1) + ":\n" + solveForOne(n));
            } else {
                System.out.println("Case #" + (i + 1) + ":\n" + solve(n));
            }
        }
    }

    private static Stack<Integer> getBinary(int number) {
        Stack<Integer> binary = new Stack<>();

        while (number > 0) {
            binary.add(number % 2);
            number /= 2;
        }

        return binary;
    }

    private static String solveForOne(int n) {
        StringBuilder result = new StringBuilder();
        result.append("1 1" + "\n");

        if (n <= 500) {
            for (int i=2; i<=n; i++) {
                result.append(i + " 1" + "\n");
            }
        } else {
            result.append("2 2" + "\n");
            for (int i=2; i<n; i++) {
                result.append(i + " 1" + "\n");
            }
        }

        return result.toString();
    }

    private static String solve(int n) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> binary = getBinary(n);

        System.out.println(binary);
        binary.pop();
        int row = binary.size() + 1;
        int col = 1;

        for (int i=1; i<=row; i++) {
            result.append(row + " " + i + "\n");
        }
        row -= 1;
        col = row;

        while (!binary.isEmpty()) {
            int next = binary.pop();
            if (next == 1) {
                if (col == 1) {
                    for (int i=1; i<=row; i++) {
                        result.append(row + " " + i + "\n");
                    }
                    row -= 1;
                    col = row;
                } else {
                    for (int i=row; i>=1; i--) {
                        result.append(row + " " + i + "\n");
                    }
                    row -= 1;
                    col = 1;
                }
            } else {
                result.append(row + " " + col + "\n");
                row -= 1;
                col = col == 1 ? 1 : row;
            }
        }

        return result.toString();
    }
}
