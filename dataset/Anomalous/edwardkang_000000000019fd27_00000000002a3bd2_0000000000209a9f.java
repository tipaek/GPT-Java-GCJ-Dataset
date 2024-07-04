import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            char[] charArray = input.toCharArray();
            int[] numbers = new int[charArray.length];
            int[] sortedNumbers = new int[charArray.length];
            Par[] results = new Par[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                int value = Character.getNumericValue(charArray[i]);
                numbers[i] = value;
                sortedNumbers[i] = value;
                results[i] = new Par(0, 0, value);
            }

            Arrays.sort(sortedNumbers);

            for (int i = sortedNumbers.length - 1; i >= 0; i--) {
                int currentNum = sortedNumbers[i];
                boolean proceed = true;
                int index = -1;

                for (int j = 0; j < numbers.length; j++) {
                    if (currentNum == numbers[j]) {
                        index = j;
                        break;
                    } else if (currentNum == numbers.length - 1) {
                        proceed = false;
                    }
                }

                if (numbers[index] > 0 && proceed) {
                    for (int j = 1; j <= currentNum; j++) {
                        int leftLimit = findLeftLimit(numbers, index);
                        int rightLimit = findRightLimit(numbers, index);

                        results[leftLimit].incrementLeft();
                        results[rightLimit].incrementRight();

                        for (int k = leftLimit; k <= rightLimit; k++) {
                            numbers[k]--;
                        }

                        if (numbers[index] == 0) {
                            break;
                        }
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (Par result : results) {
                output.append("(".repeat(result.getLeft()));
                output.append(result.getVal());
                output.append(")".repeat(result.getRight()));
            }

            System.out.println("Case #" + t + ": " + output);
        }
    }

    private static int findLeftLimit(int[] numbers, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (numbers[i] < numbers[index] || numbers[i] == 0) {
                return i + 1;
            }
        }
        return 0;
    }

    private static int findRightLimit(int[] numbers, int index) {
        for (int i = index + 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[index] || numbers[i] == 0) {
                return i - 1;
            }
        }
        return numbers.length - 1;
    }

    static class Par {
        private int left;
        private int right;
        private final int val;

        Par(int left, int right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getVal() {
            return val;
        }

        public void incrementLeft() {
            left++;
        }

        public void incrementRight() {
            right++;
        }
    }
}