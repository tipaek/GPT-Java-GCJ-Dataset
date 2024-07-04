import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static boolean debug = false;
    private static int N;

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = scanner.nextInt();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        List<String> steps = new ArrayList<>();
        if (N <= 500) {
            for (int i = 1; i <= N; i++) {
                steps.add(i + " 1");
            }
        } else if (N <= 997) {
            handleRange501To997(steps);
        } else if (N <= 1000) {
            handleRange998To1000(steps);
        }
        return String.join("\n", steps);
    }

    private static void handleRange501To997(List<String> steps) {
        int diff = N - 500;
        int sum = 0;
        for (int i = 1; i <= diff + 1; i++) {
            steps.add(i + " 1");
            sum++;
        }
        steps.add((diff + 2) + " 2");
        sum += (diff + 1);
        steps.add((diff + 2) + " 1");
        sum++;
        int row = diff + 3;
        while (steps.size() < 500) {
            steps.add(row + " 1");
            sum++;
            row++;
        }
        printDebug("Sum" + sum + " - " + steps.size());
    }

    private static void handleRange998To1000(List<String> steps) {
        int diff = N - 500;
        int sum = 0;
        steps.add("1 1");
        steps.add("2 1");
        int nextRow = 0;
        if (N == 998) {
            steps.add("3 1");
            steps.add("4 2");
            steps.add("4 1");
            nextRow = 5;
            sum = 7;
            diff -= 2;
        } else if (N == 999) {
            steps.add("3 1");
            steps.add("4 1");
            steps.add("5 2");
            steps.add("5 1");
            nextRow = 6;
            sum = 9;
            diff -= 3;
        } else if (N == 1000) {
            steps.add("3 1");
            steps.add("4 1");
            steps.add("5 1");
            steps.add("6 2");
            steps.add("6 1");
            nextRow = 7;
            sum = 11;
            diff -= 4;
        }

        for (int i = nextRow; i <= diff + 1; i++) {
            steps.add(i + " 1");
            sum++;
        }
        steps.add((diff + 2) + " 2");
        sum += (diff + 1);
        steps.add((diff + 2) + " 1");
        sum++;
        int row = diff + 3;
        while (steps.size() < 500) {
            steps.add(row + " 1");
            sum++;
            row++;
        }
        printDebug("Sum" + sum + " - " + steps.size());
    }

    private static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }
}