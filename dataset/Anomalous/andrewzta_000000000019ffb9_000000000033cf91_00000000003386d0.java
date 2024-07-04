import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        WormholeSolver solver = new WormholeSolver();
        int testCases = Integer.parseInt(scanner.next());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            solver.solve(testCase, scanner, writer);
        }
        writer.close();
    }
}

class WormholeSolver {
    private static final boolean DEBUG = false;

    public void solve(int testCase, Scanner scanner, PrintWriter writer) {
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner);
        }

        int maxResult = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                final long deltaX = points[j].x - points[i].x;
                final long deltaY = points[j].y - points[i].y;
                Point[] sortedPoints = points.clone();
                Arrays.sort(sortedPoints, new Comparator<Point>() {
                    public int compare(Point p1, Point p2) {
                        long crossProduct1 = deltaX * p1.y - deltaY * p1.x;
                        long crossProduct2 = deltaX * p2.y - deltaY * p2.x;
                        return Long.compare(crossProduct1, crossProduct2);
                    }
                });

                int singleCount = 0;
                int doubleCount = 0;
                int innerCount = 0;
                int currentCount = 0;
                long previousValue = 0;
                if (DEBUG) writer.print("  ");
                for (int k = 0; k < n; k++) {
                    long currentValue = deltaX * sortedPoints[k].y - deltaY * sortedPoints[k].x;
                    if (DEBUG) writer.print(currentValue + " ");
                    if (k == 0 || currentValue == previousValue) {
                        currentCount++;
                    } else {
                        if (currentCount == 1) {
                            singleCount++;
                        } else {
                            doubleCount += 2;
                            innerCount += currentCount - 2;
                        }
                        currentCount = 1;
                    }
                    previousValue = currentValue;
                }
                if (DEBUG) writer.println();
                if (currentCount == 1) {
                    singleCount++;
                } else {
                    doubleCount += 2;
                    innerCount += currentCount - 2;
                }

                int result = doubleCount + innerCount;
                if (innerCount % 2 == 1 && singleCount > 1) {
                    singleCount = 1;
                }
                result += Math.min(singleCount, 2);
                if (DEBUG)
                    writer.println(i + " " + j + " " + deltaX + " " + deltaY + " " + singleCount + " " + doubleCount + " " + innerCount + " " + result);
                if (result > maxResult) {
                    maxResult = result;
                }
            }
        }
        writer.println("Case #" + testCase + ": " + maxResult);
    }

    static class Point {
        long x;
        long y;

        public Point(Scanner scanner) {
            x = scanner.nextLong();
            y = scanner.nextLong();
        }
    }
}