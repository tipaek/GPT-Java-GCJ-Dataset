import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int testCase = 1; testCase <= cases; testCase++) {
            String str = scanner.next();
            int[] nums = new int[str.length()];

            for (int i = 0; i < str.length(); i++) {
                nums[i] = Character.getNumericValue(str.charAt(i));
            }

            System.out.println("Case #" + testCase + ": " + generateString(nums, 0, nums.length - 1, 0));
        }

        scanner.close();
    }

    public static String generateString(int[] array, int left, int right, int prevParen) {
        StringBuilder sb = new StringBuilder();
        int min = getMin(array, left, right);

        for (int i = 0; i < min - prevParen; i++) {
            sb.append("(");
        }

        if (left == right) {
            sb.append(array[left]);
        } else {
            int start = left;
            int end = right;

            while (start <= right) {
                while (start <= right && array[start] == min) {
                    sb.append(array[start]);
                    start++;
                }

                if (start > right) break;

                end = start;

                while (end <= right && array[end] != min) {
                    end++;
                }

                end--;

                sb.append(generateString(array, start, end, min));
                start = end + 1;
            }
        }

        for (int i = 0; i < min - prevParen; i++) {
            sb.append(")");
        }

        return sb.toString();
    }

    private static int getMin(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}