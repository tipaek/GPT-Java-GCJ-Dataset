import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static String str;

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            str = scanner.next();
            String result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String solveTestCase() {
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;
        
        for (char ch : str.toCharArray()) {
            int num = Character.getNumericValue(ch);
            while (currentLevel < num) {
                result.append('(');
                currentLevel++;
            }
            while (currentLevel > num) {
                result.append(')');
                currentLevel--;
            }
            result.append(num);
        }
        while (currentLevel > 0) {
            result.append(')');
            currentLevel--;
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        if (debug) {
            long startTime = System.currentTimeMillis();
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }
}