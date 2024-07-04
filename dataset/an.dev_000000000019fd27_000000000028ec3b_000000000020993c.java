import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[][] nums) {
        int n = nums.length;

        int k = 0;
        int r = 0;
        int c = 0;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.clear();
            int temp = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) k += nums[i][j];
                if(set.contains(nums[i][j])) temp = 1;
                set.add(nums[i][j]);
            }
            r += temp;
        }


        for(int j = 0; j < n; j++) {
            set.clear();
            for(int i = 0; i < n; i++) {
                if(set.contains(nums[i][j])) {
                    c++;
                    break;
                }
                set.add(nums[i][j]);
            }
        }

        return k + " " + r + " " + c;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/vestigium-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int nb = scanner.nextInt();
                int[][] nums = new int[nb][nb];
                for (int i = 0; i < nb; i++) {
                    for (int j = 0; j < nb; j++) {
                        nums[i][j] = scanner.nextInt();
                    }
                }
                System.out.println("Case #" + testNumber + ": " + solve(nums));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}