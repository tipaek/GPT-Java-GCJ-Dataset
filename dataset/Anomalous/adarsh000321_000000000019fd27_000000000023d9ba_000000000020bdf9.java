import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static Point[] points;
    static int numberOfPoints;

    public static void main(String[] args) throws Exception {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder caseResult = new StringBuilder();
            caseResult.append("Case #").append(testCase).append(": ");
            numberOfPoints = scanner.nextInt();
            points = new Point[numberOfPoints];

            for (int i = 0; i < numberOfPoints; i++) {
                points[i] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point point1, Point point2) {
                    if (point1.x == point2.x) {
                        return point1.y - point2.y;
                    }
                    return point1.x - point2.x;
                }
            });

            char[] assignments = new char[numberOfPoints];
            Arrays.fill(assignments, '0');
            assignments[0] = 'J';
            Point previous = points[0];

            for (int i = 1; i < numberOfPoints; i++) {
                if (!intersects(points[i], previous)) {
                    assignments[i] = 'J';
                    previous = points[i];
                }
            }

            for (int j = 0; j < numberOfPoints; j++) {
                if (assignments[j] == '0') {
                    assignments[j] = 'C';
                }
            }

            if (isValid(assignments)) {
                caseResult.append(String.valueOf(assignments));
            } else {
                caseResult.append("IMPOSSIBLE");
            }

            caseResult.append("\n");
            result.append(caseResult);
        }

        System.out.print(result);
    }

    static boolean isValid(char[] assignments) {
        for (int i = 0; i < assignments.length; i++) {
            if (assignments[i] == 'C') {
                for (int j = 0; j < assignments.length; j++) {
                    if (i == j) continue;
                    if (assignments[j] == 'C' && intersects(points[i], points[j])) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < assignments.length; i++) {
            if (assignments[i] == 'J') {
                for (int j = 0; j < assignments.length; j++) {
                    if (i == j) continue;
                    if (assignments[j] == 'J' && intersects(points[i], points[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean intersects(Point point1, Point point2) {
        return (point1.x > point2.x && point1.x < point2.y) || (point1.y > point2.x && point1.y < point2.y);
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}