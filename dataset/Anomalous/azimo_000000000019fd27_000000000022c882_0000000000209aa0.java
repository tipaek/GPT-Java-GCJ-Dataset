import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            String[] inputs = scanner.nextLine().split(" ");
            int arraySize = Integer.parseInt(inputs[0]);
            int trace = Integer.parseInt(inputs[1]);

            if (isPossible(arraySize, trace)) {
                System.out.printf("Case #%d: POSSIBLE\n", testCase);
                printMatrix(arraySize);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            }
        }

        scanner.close();
    }

    private static boolean isPossible(int arraySize, int trace) {
        if (arraySize == 2 && (trace == 2 || trace == 4)) {
            return true;
        } else if (arraySize > 2 && (trace == arraySize || trace == arraySize * arraySize
                || trace == (arraySize * (arraySize + 1)) / 2)) {
            return true;
        }
        return false;
    }

    private static void printMatrix(int arraySize) {
        for (int i = 1; i <= arraySize; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = i; j < i + arraySize; j++) {
                row.append((j % arraySize == 0 ? arraySize : j % arraySize)).append(" ");
            }
            System.out.println(row.toString().trim());
        }
    }
}