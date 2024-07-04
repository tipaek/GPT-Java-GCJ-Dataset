import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testA.in";

    public static PrintWriter writer;
    public static Scanner scanner;

    public static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    public static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    public static long now() {
        return System.nanoTime();
    }

    public static double round(double value, int sigDigits) {
        double scale = Math.pow(10, sigDigits);
        return Math.round(value * scale) / scale;
    }

    public static void printTime(long start, long end) {
        long elapsed = end - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(end * msPerNs, 4) + ")");
    }

    public static class Path {
        ArrayDeque<Character> path;
        long currentX;
        long currentY;

        public Path(long startX, long startY) {
            currentX = startX;
            currentY = startY;
            path = new ArrayDeque<>();
        }

        public Path(long x, long y, ArrayDeque<Character> p) {
            currentX = x;
            currentY = y;
            path = new ArrayDeque<>(p);
        }

        public Path addStep(char dir, long stepSize) {
            long x = currentX;
            long y = currentY;
            ArrayDeque<Character> p = new ArrayDeque<>(path);

            switch (dir) {
                case 'N': y += stepSize; break;
                case 'S': y -= stepSize; break;
                case 'E': x += stepSize; break;
                case 'W': x -= stepSize; break;
            }

            p.add(dir);
            return new Path(x, y, p);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            return sb.toString();
        }
    }

    public static void nextCase(int caseNum) {
        long targetX = scanner.nextInt();
        long targetY = scanner.nextInt();
        ArrayDeque<Path> options = new ArrayDeque<>();
        ArrayDeque<Path> prevOptions;
        long stepSize = 1;
        Path solution = null;

        options.add(new Path(0, 0));

        while (solution == null && !options.isEmpty()) {
            prevOptions = options;
            options = new ArrayDeque<>();

            for (Path path : prevOptions) {
                if (path.currentX == targetX && path.currentY == targetY) {
                    solution = path;
                    break;
                }

                long xMod = Math.abs(path.currentX - targetX) % (2 * stepSize);
                long yMod = Math.abs(path.currentY - targetY) % (2 * stepSize);

                if (xMod == 0 && yMod == stepSize) {
                    options.add(path.addStep('N', stepSize));
                    options.add(path.addStep('S', stepSize));
                } else if (xMod == stepSize && yMod == 0) {
                    options.add(path.addStep('W', stepSize));
                    options.add(path.addStep('E', stepSize));
                }
            }

            stepSize *= 2;
        }

        String answer = (solution == null) ? "IMPOSSIBLE" : solution.toString();
        writer.print("Case #" + caseNum + ": " + answer);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            nextCase(i + 1);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}