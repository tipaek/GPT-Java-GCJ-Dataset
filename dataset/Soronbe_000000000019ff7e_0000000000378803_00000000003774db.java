import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Now 2 stacks are +- even and the orders will alternate between stacks
        // every 2 order the order size increases by 2, but the difference in stacksize increases by 1

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }

    }

    public static void solve(Scanner scanner) {
        String[] names = scanner.nextLine().trim().split(" ");

        String C = names[0];
        String J = names[1];

        int[][] matrix = editDistanceMatrix(C, J);

        int distance = getDistance(matrix);
   //     System.out.println(distance);


        if (distance <= 1) {
            System.out.println(J);
            return;
        }

        String x = apply(C.length(), J.length(), matrix, C, J);
     //   System.out.println(getDistance(x, C));
       // System.out.println(getDistance(x, J));
        System.out.println(x);

    }

    private static int getDistance(int[][] matrix) {
        return matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1];
    } private static int getDistance(String x, String y) {
        return getDistance(editDistanceMatrix(x, y));
    }

    private static int[][] editDistanceMatrix(String first, String second) {
        int[][] matrix = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); ++i) {
            matrix[i][0] = i;
        }

        for (int i = 0; i <= second.length(); ++i) {
            matrix[0][i] = i;
        }

        for (int i = 0; i < first.length(); ++i) {
            for (int j = 0; j < second.length(); ++j) {
                int replace = 1;
                if (first.charAt(i) == second.charAt(j)) {
                    replace = 0;
                }

                int result = Math.min(
                        matrix[i][j] + replace,
                        Math.min(
                                matrix[i + 1][j] + 1,
                                matrix[i][j + 1] + 1
                        ));

                matrix[i + 1][j + 1] = result;
            }
        }

        return matrix;
    }

    private static String apply(int x, int y, int[][] matrix, String left, String right) {
        if (x == 0 && y == 0) {
            return "";
        }

        String direction = "ERROR";
        int best = Integer.MAX_VALUE;
        int newX = x;
        int newY = y;

        if (x > 0 && matrix[x - 1][y] + 1 == matrix[x][y]) {
            best = matrix[x - 1][y];
            direction = "UP";
            newX = x - 1;
            newY = y;
        }

        if (y > 0 && matrix[x][y - 1] + 1 == matrix[x][y]) {
            if (best > matrix[x][y - 1]) {
                best = matrix[x][y - 1];

                direction = "LEFT";
                newX = x;
                newY = y - 1;
            }
        }

        if (y > 0 && x > 0) {
            if (left.charAt(x - 1) == right.charAt(y - 1)) {
                if (matrix[x - 1][y - 1] == matrix[x][y]) {
                    if (best > matrix[x - 1][y - 1]) {
                        best = matrix[x - 1][y - 1];

                        direction = "MATCH";
                        newX = x - 1;
                        newY = y - 1;
                    }
                }
            } else {
                if (matrix[x - 1][y - 1] + 1 == matrix[x][y]) {
                    if (best > matrix[x - 1][y - 1]) {
                        best = matrix[x - 1][y - 1];

                        direction = "REPLACE";
                        newX = x - 1;
                        newY = y - 1;
                    }
                }
            }
        }

        String next = apply(newX, newY, matrix, left, right);

        if (matrix[x][y] <= getDistance(matrix) / 2) {
            switch (direction) {
                case "MATCH":
                case "REPLACE":
                    return next + right.charAt(y - 1);
                case "UP":
                    return next;// + left.charAt(x - 1);
                case "LEFT":
                    return next + right.charAt(y - 1);
            }
        } else {
            switch (direction) {
                case "MATCH":
                case "REPLACE":
                case "UP":
                    return next + left.charAt(x - 1);
                case "LEFT":
                    return next;

            }
        }

        throw new RuntimeException();
    }
}
