import java.io.*;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[] position, char[] moves) {
        int steps = 0;
        if (calculateDistance(position) <= steps) return String.valueOf(steps);
        
        for (char move : moves) {
            steps++;
            switch (move) {
                case 'S': position[1]--; break;
                case 'N': position[1]++; break;
                case 'W': position[0]--; break;
                case 'E': position[0]++; break;
            }
            if (calculateDistance(position) <= steps) return String.valueOf(steps);
        }
        
        return "IMPOSSIBLE";
    }

    public static int calculateDistance(int[] position) {
        return Math.abs(position[0]) + Math.abs(position[1]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        InputStream inputStream = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1c/t1/1.in") : System.in;
        
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int[] position = new int[2];
                position[0] = scanner.nextInt();
                position[1] = scanner.nextInt();
                String moves = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(position, moves.toCharArray()));
            }
        }
        
        System.err.println("Done in " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}