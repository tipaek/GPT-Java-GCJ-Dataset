import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int r, int s) {
        return String.valueOf((r - 1) * (s - 1));
    }

    public static int[] change(int[] nums, int a, int b) {
        int[] res = new int[nums.length];
        int i = 0;
        for (i = 0; i < b - a; i++) {
            res[i] = nums[i + a + 1];
        }
        for (; i <= b; i++) {
            res[i] = nums[i - b + 1];
        }
        for (; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static boolean isInOrder(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void addPos(StringBuilder sb, int i, int j) {
        sb.append(i).append(" ").append(j).append('\n');
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1b/t3/1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int r = scanner.nextInt();
                int s = scanner.nextInt();
                System.out.println("Case #" + testNumber + ": " + solve(r, s));
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}