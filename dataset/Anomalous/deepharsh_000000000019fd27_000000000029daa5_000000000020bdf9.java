import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[] numbers = new int[n * 2];

            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = scanner.nextInt();
            }

            System.out.println("Case #" + i + ": " + findSequence(numbers, "", 0));
        }

        scanner.close();
    }

    public static String findSequence(int[] numbers, String sequence, int index) {
        if (index >= numbers.length - 2) {
            return "IMPOSSIBLE";
        }

        sequence += "C";

        if (numbers[index + 1] <= numbers[index + 2]) {
            while (numbers[index + 1] <= numbers[index + 2]) {
                sequence += "C";
                index += 2;

                if (index >= numbers.length - 2) {
                    return sequence;
                }
            }
            return findJSequence(numbers, sequence, index + 2);
        } else {
            return findJSequence(numbers, sequence, index + 2);
        }
    }

    public static String findJSequence(int[] numbers, String sequence, int index) {
        if (index >= numbers.length - 2) {
            return "IMPOSSIBLE";
        }

        sequence += "J";

        if (numbers[index + 1] <= numbers[index + 2]) {
            while (numbers[index + 1] <= numbers[index + 2]) {
                sequence += "J";
                index += 2;

                if (index >= numbers.length - 2) {
                    return sequence;
                }
            }
            return findSequence(numbers, sequence, index + 2);
        } else {
            return findSequence(numbers, sequence, index + 2);
        }
    }
}