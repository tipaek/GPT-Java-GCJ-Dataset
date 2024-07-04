import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    
    private static StringBuilder solve(String source) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            int v = c - '0';
            if (v < depth) {
                for (int j = 0; j < depth - v; j++)
                    result.append(')');
            } else if (v > depth) {
                for (int j = 0; j < v - depth; j++)
                    result.append('(');
            }
            result.append(c);
            depth = v;
        }
        if (depth > 0) {
            for (int j = 0; j < depth; j++)
                result.append(')');
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/NestingDepth-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String source = scanner.next();
                StringBuilder result = solve(source);
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}