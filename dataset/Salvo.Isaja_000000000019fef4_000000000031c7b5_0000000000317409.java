import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false; 
   
    private static int solve(int offsetX, int offsetY, String peppurrPath) {
        int[] xs = new int[peppurrPath.length() + 1];
        int[] ys = new int[peppurrPath.length() + 1];
        xs[0] = offsetX;
        ys[0] = offsetY;
        for (int i = 0; i < peppurrPath.length(); i++) {
            char c = peppurrPath.charAt(i);
            switch (c) {
                case 'N': xs[i + 1] = xs[i]; ys[i + 1] = ys[i] + 1; break;
                case 'S': xs[i + 1] = xs[i]; ys[i + 1] = ys[i] - 1; break;
                case 'E': xs[i + 1] = xs[i] + 1; ys[i + 1] = ys[i]; break;
                case 'W': xs[i + 1] = xs[i] - 1; ys[i + 1] = ys[i]; break;
            }
        }
        for (int i = 0; i < peppurrPath.length() + 1; i++) {
            int dist = Math.abs(xs[i]) + Math.abs(ys[i]);
            if (dist <= i) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/round1c/ProblemA-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int offsetX = scanner.nextInt();
                int offsetY = scanner.nextInt();
                String peppurrPath = scanner.next();
                int steps = solve(offsetX, offsetY, peppurrPath);
                System.out.println("Case #" + testNumber + ": " + (steps < 0 ? "IMPOSSIBLE" : steps));
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}