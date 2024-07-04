
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[] nums, char[] moves) {
        int step = 0;
        if(dist(nums) <= step) return step + "";
        for(char move : moves) {
            step++;
            if(move == 'S') nums[1]--;
            if(move == 'N') nums[1]++;
            if(move == 'W') nums[0]--;
            if(move == 'E') nums[0]++;
            if(dist(nums) <= step) return step + "";
        }
        return "IMPOSSIBLE";
    }

    public static int dist(int[] nums) {
        return Math.abs(nums[0]) + Math.abs(nums[1]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1c/t1/1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int[] nums = new int[2];
                nums[0] = scanner.nextInt();
                nums[1] = scanner.nextInt();
                String moves = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(nums, moves.toCharArray()));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}