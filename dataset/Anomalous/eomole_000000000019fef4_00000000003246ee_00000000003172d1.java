import java.util.Arrays;
import java.util.Scanner;

class ProblemSolver {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int arraySize = scanner.nextInt();
                int divisor = scanner.nextInt();
                long[] numbers = new long[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    numbers[i] = scanner.nextLong();
                }
                Arrays.sort(numbers);
                if (divisor > 3) {
                    throw new IllegalArgumentException("Divisor greater than 3 is not supported.");
                }

                int result = (divisor == 2) ? handleTwo(numbers) : handleThree(numbers);
                System.out.printf("Case #%d: %d%n", caseNum, result);
            }
        }
    }

    private static int handleTwo(long[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                return 0;
            }
        }
        return 1;
    }

    private static int handleThree(long[] numbers) {
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i - 2] == numbers[i - 1] && numbers[i - 1] == numbers[i]) {
                return 0;
            }
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (Arrays.binarySearch(numbers, 0, i, numbers[i] / 2) >= 0) {
                    return 1;
                }
            }
        }
        return 2;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        ProblemSolver.main(args);
    }
}