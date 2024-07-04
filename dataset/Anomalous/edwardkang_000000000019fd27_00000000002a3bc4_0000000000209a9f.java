import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            String line = scanner.next();
            char[] charArray = line.toCharArray();
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
                int index = -1;

                for (int k = 0; k < numbers.length; k++) {
                    if (currentNum == numbers[k]) {
                        index = k;
                        break;
                    }
                }

                if (numbers[index] > 0) {
                    for (int j = 1; j <= currentNum; j++) {
                        int leftLimit = findLeftLimit(numbers, index);
                        int rightLimit = findRightLimit(numbers, index);

                        results[leftLimit].incrementLeft();
                        results[rightLimit].incrementRight();

                        for (int b = leftLimit; b <= rightLimit; b++) {
                            numbers[b]--;
                        }

                        if (numbers[index] == 0) {
                            break;
                        }
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for (Par result : results) {
                for (int l = 0; l < result.getLeft(); l++) {
                    answer.append("(");
                }
                answer.append(result.getVal());
                for (int l = 0; l < result.getRight(); l++) {
                    answer.append(")");
                }
            }

            System.out.println("Case #" + testCase + ": " + answer.toString());
        }
    }

    private static int findLeftLimit(int[] numbers, int index) {
        for (int l = index - 1; l >= 0; l--) {
            if (numbers[l] < numbers[index] || numbers[l] == 0) {
                return l + 1;
            } else if (l == 0) {
                return 0;
            }
        }
        return 0;
    }

    private static int findRightLimit(int[] numbers, int index) {
        for (int r = index + 1; r < numbers.length; r++) {
            if (numbers[r] < numbers[index] || numbers[r] == 0) {
                return r - 1;
            } else if (r == numbers.length - 1) {
                return r;
            }
        }
        return numbers.length - 1;
    }

    static class Par {
        private int left;
        private int right;
        private final int value;

        Par(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getVal() {
            return value;
        }

        public void incrementLeft() {
            left++;
        }

        public void incrementRight() {
            right++;
        }
    }
}