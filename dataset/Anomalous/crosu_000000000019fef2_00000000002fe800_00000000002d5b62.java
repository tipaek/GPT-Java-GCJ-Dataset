import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {

    private static boolean debug = false;
    private static boolean fromFile = false;
    private static String inputFile = "testA.in";

    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    private static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    private static long currentTime() {
        return System.nanoTime();
    }

    private static double roundToSignificantDigits(double value, int significantDigits) {
        double scale = Math.pow(10, significantDigits);
        return Math.round(value * scale) / scale;
    }

    private static void printElapsedTime(long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        double millisecondsPerNanosecond = Math.pow(10, -6);

        debugPrintln("Time elapsed: " + roundToSignificantDigits(elapsedTime * millisecondsPerNanosecond, 4) +
                " ms (" + roundToSignificantDigits(startTime * millisecondsPerNanosecond, 4) + " ms, " +
                roundToSignificantDigits(endTime * millisecondsPerNanosecond, 4) + " ms)");
    }

    public static class Path {
        private ArrayDeque<Character> path;
        private int currentX;
        private int currentY;

        public Path(int startX, int startY) {
            this.currentX = startX;
            this.currentY = startY;
            this.path = new ArrayDeque<>();
        }

        public Path(int x, int y, ArrayDeque<Character> p) {
            this.currentX = x;
            this.currentY = y;
            this.path = new ArrayDeque<>(p);
        }

        public Path addStep(char direction, int stepSize) {
            int x = currentX;
            int y = currentY;

            switch (direction) {
                case 'N': y += stepSize; break;
                case 'S': y -= stepSize; break;
                case 'E': x += stepSize; break;
                case 'W': x -= stepSize; break;
            }

            ArrayDeque<Character> newPath = new ArrayDeque<>(path);
            newPath.add(direction);

            return new Path(x, y, newPath);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (char step : path) {
                result.append(step);
            }
            return result.toString();
        }
    }

    private static void processCase(int caseNumber) {
        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();
        ArrayDeque<Path> currentOptions = new ArrayDeque<>();
        ArrayDeque<Path> previousOptions;
        int stepSize = 1;
        Path solution = null;

        currentOptions.add(new Path(0, 0));

        while (solution == null && !currentOptions.isEmpty()) {
            previousOptions = currentOptions;
            currentOptions = new ArrayDeque<>();

            for (Path path : previousOptions) {
                if (path.currentX == targetX && path.currentY == targetY) {
                    solution = path;
                    break;
                }

                int xMod = Math.abs(path.currentX - targetX) % (2 * stepSize);
                int yMod = Math.abs(path.currentY - targetY) % (2 * stepSize);

                if (xMod == 0 && yMod == stepSize) {
                    currentOptions.add(path.addStep('N', stepSize));
                    currentOptions.add(path.addStep('S', stepSize));
                } else if (xMod == stepSize && yMod == 0) {
                    currentOptions.add(path.addStep('W', stepSize));
                    currentOptions.add(path.addStep('E', stepSize));
                }
            }
            stepSize *= 2;
        }

        String result = (solution == null) ? "IMPOSSIBLE" : solution.toString();
        writer.print("Case #" + caseNumber + ": " + result);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processCase(i + 1);

            if (i < testCases - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}