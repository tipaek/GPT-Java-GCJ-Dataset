
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[][] nums) {
        Arrays.sort(nums, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        char[] res = new char[nums.length];

        int endC = 0;
        int endJ = 0;
        for(int[] cur : nums) {
            if(cur[0] < endC && cur[0] < endJ) {
                return "IMPOSSIBLE";
            }
            if(cur[0] >= endC) {
                endC = cur[1];
                res[cur[2]] = 'C';
            } else {
                endJ = cur[1];
                res[cur[2]] = 'J';
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/parentingparentingreturns-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int nb = scanner.nextInt();
                int[][] nums = new int[nb][3];
                for (int i = 0; i < nb; i++) {
                    nums[i][0] = scanner.nextInt();
                    nums[i][1] = scanner.nextInt();
                    nums[i][2] = i;
                }
                System.out.println("Case #" + testNumber + ": " + solve(nums));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}