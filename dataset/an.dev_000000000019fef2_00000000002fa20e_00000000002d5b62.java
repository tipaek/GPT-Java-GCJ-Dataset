
import java.io.*;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[] nums) {
        int a = nums[0], b = nums[1];
        StringBuilder sb = new StringBuilder();
        if((a + b) % 2 == 0 ) return "IMPOSSIBLE";

        while(!(a==0 && b ==1) && !(a==1 && b ==0) && !(a==-1 && b ==0) && !(a==0 && b ==-1)) {
            if((a + b) % 2 == 0 ) return "IMPOSSIBLE";
            if(a % 2 == 0) {
                a /= 2;
                if(((b+1)/2 + a) % 2 == 0) {
                    sb.append("N");
                    b = (b-1)/2;
                } else {
                    sb.append("S");
                    b = (b+1)/2;
                }
            } else {
                b /= 2;
                if(((a+1)/2 + b) % 2 == 0) {
                    sb.append("E");
                    a = (a-1)/2;
                } else {
                    sb.append("W");
                    a = (a+1)/2;
                }
            }
        }

        if(a == 1) sb.append("E");
        if(a == -1) sb.append("W");
        if(b == 1) sb.append("N");
        if(b == -1) sb.append("S");

        return sb.toString();
    }

    public static void addPos(StringBuilder sb, int i, int j) {
        sb.append(i + " " + j + '\n');
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1b/t1/1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int[] nums = new int[2];
                nums[0] = scanner.nextInt();
                nums[1] = scanner.nextInt();
                System.out.println("Case #" + testNumber + ": " + solve(nums));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}