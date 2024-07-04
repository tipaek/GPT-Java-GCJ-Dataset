import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        matrix[0][0] = 1;
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = Math.min(matrix[i][j - 1] + i, matrix[i - 1][j] + i);
            }
        }

        return (rows - 1) * (cols - 1) + " " + matrix[rows - 1][cols - 1];
    }

    public static int[] change(int[] nums, int start, int end) {
        int[] result = new int[nums.length];
        int index = 0;
        
        while (index < end - start) {
            result[index] = nums[index + start + 1];
            index++;
        }
        while (index <= end) {
            result[index] = nums[index - end + 1];
            index++;
        }
        while (index < nums.length) {
            result[index] = nums[index];
            index++;
        }
        return result;
    }

    public static boolean isInOrder(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void addPos(StringBuilder sb, int row, int col) {
        sb.append(row).append(" ").append(col).append('\n');
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        InputStream inputStream = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1b/t3/1.in") : System.in;
        
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int[] dimensions = new int[2];
                dimensions[0] = scanner.nextInt();
                dimensions[1] = scanner.nextInt();
                System.out.println("Case #" + testCase + ": " + solve(dimensions[0], dimensions[1]));
            }
        }
        
        System.err.println("Done in " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}