
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      for (int i = 1; i <= t; ++i) {
        int lineCount = in.nextInt();
        int[][] input = new int[lineCount][lineCount];
        for (int x = 0; x < lineCount; x++) {
            for (int y = 0; y < lineCount; y++) {
                input[x][y] = in.nextInt();
            }
        }

        int[] output = getDuplicates(input);
        System.out.println("Case #" + i + ": " + getTrace(input) + " " + output[0] + " " + output[1]);
      }
    }

    private static int getTrace(int[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i][i];
        }
        return sum;
    }

    private static int[] getDuplicates(int[][] input) {
        // for each row, use set to store numbers and check if duplicate
        int rowDuplicate = 0;
        for (int i = 0; i < input.length; i++) {
            Set<Integer> nums = new HashSet<>();
            for (int j = 0; j < input.length; j++) {
                int num = input[i][j];
                if (nums.contains(num)) {
                    rowDuplicate++;
                    break;
                } else {
                    nums.add(num);
                }
            }
        }
        // same for each column
        int colDuplicate = 0;
        for (int i = 0; i < input.length; i++) {
            Set<Integer> nums = new HashSet<>();
            for (int j = 0; j < input.length; j++) {
                int num = input[j][i];
                if (nums.contains(num)) {
                    colDuplicate++;
                    break;
                } else {
                    nums.add(num);
                }
            }
        }
        return new int[]{rowDuplicate,colDuplicate};
    }
}
