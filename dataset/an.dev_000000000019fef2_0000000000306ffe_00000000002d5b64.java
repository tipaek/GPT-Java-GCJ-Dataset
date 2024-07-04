
import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int r, int s) {
        int[][] res = new int[r][s];
        res[0][0] = 1;
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < s; j++) {
                res[i][j] = Math.min(res[i][j-1] + i, res[i-1][j] + i);
            }
        }

        return (r - 1) * (s - 1) + " " + res[r-1][s-1];
    }

    public static int[] change(int[] nums, int a, int b) {
        int[] res = new int[nums.length];
        int i = 0;
        while(i < b - a) {
            res[i] = nums[i + a + 1];
        }
        while(i <= b) {
            res[i] = nums[i - b + 1];
        }
        while(i < nums.length) {
            res[i] = nums[i];
        }
        return res;
    }

    public static boolean isInOrder(int[] nums) {
        int x = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(x > nums[i]) return false;
            x = nums[i];
        }
        return true;
    }

    public static void addPos(StringBuilder sb, int i, int j) {
        sb.append(i + " " + j + '\n');
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1b/t3/1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int[] nums = new int[2];
                nums[0] = scanner.nextInt();
                nums[1] = scanner.nextInt();
                System.out.println("Case #" + testNumber + ": " + solve(nums[0], nums[1]));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}