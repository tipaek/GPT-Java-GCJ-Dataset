import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static StringBuilder op;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                String n = scanner.next();
                int[] nums = n.chars().map(Character::getNumericValue).toArray();

                op = new StringBuilder();
                for (int j = 0; j < nums.length; j++) {
                    int num = nums[j];

                    if (num == 0) {
                        op.append("0");
                        continue;
                    }

                    if (j == 0) {
                        appendOpenBraces(num);
                        op.append(num);
                    } else {
                        appendOpenBraces(num - nums[j - 1]);
                        op.append(num);
                    }

                    if (j == nums.length - 1) {
                        appendCloseBraces(num);
                    } else {
                        appendCloseBraces(num - nums[j + 1]);
                    }
                }
                System.out.println("Case #" + i + ": " + op);
            }
        }
    }

    public static void appendOpenBraces(int times) {
        if (times > 0) {
            for (int i = 0; i < times; i++) {
                op.append("(");
            }
        }
    }

    public static void appendCloseBraces(int times) {
        if (times > 0) {
            for (int i = 0; i < times; i++) {
                op.append(")");
            }
        }
    }
}