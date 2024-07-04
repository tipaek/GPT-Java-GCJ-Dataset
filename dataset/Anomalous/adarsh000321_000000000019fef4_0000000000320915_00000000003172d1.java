import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            resultBuilder.append("Case #").append(testCase).append(": ");
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            Long[] numbers = new Long[n];
            HashSet<Long> numberSet = new HashSet<>();

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextLong();
                numberSet.add(numbers[i]);
            }

            if (d == 2) {
                handleD2(resultBuilder, numbers);
            } else if (d == 3) {
                handleD3(resultBuilder, numbers, numberSet);
            }

            if (testCase != testCases) {
                resultBuilder.append("\n");
            }
        }

        System.out.print(resultBuilder);
    }

    private static void handleD2(StringBuilder resultBuilder, Long[] numbers) {
        Arrays.sort(numbers);
        boolean hasDuplicate = false;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i].equals(numbers[i + 1])) {
                hasDuplicate = true;
                break;
            }
        }

        resultBuilder.append(hasDuplicate ? 0 : 1);
    }

    private static void handleD3(StringBuilder resultBuilder, Long[] numbers, HashSet<Long> numberSet) {
        Arrays.sort(numbers);
        boolean hasThreeDuplicates = false;
        boolean hasTwoDuplicates = false;

        for (int i = 0; i < numbers.length; i++) {
            if (i + 2 < numbers.length && numbers[i].equals(numbers[i + 1])) {
                hasTwoDuplicates = true;
            }
            if (i + 2 < numbers.length && numbers[i].equals(numbers[i + 1]) && numbers[i].equals(numbers[i + 2])) {
                hasThreeDuplicates = true;
            }
        }

        if (hasThreeDuplicates) {
            resultBuilder.append(0);
        } else if (hasTwoDuplicates) {
            resultBuilder.append(1);
        } else {
            boolean hasDouble = false;
            for (Long number : numbers) {
                if (numberSet.contains(2 * number)) {
                    hasDouble = true;
                    break;
                }
            }
            resultBuilder.append(hasDouble ? 1 : 2);
        }
    }
}