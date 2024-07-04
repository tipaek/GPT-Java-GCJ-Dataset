import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                boolean found = false;
                for (int row = -9; row < 8; row++) {
                    for (int col = -9; col < 8; col++) {
                        if (!found) {
                            printCoordinates(new Point(row, col));
                        }
                        String response = scanner.nextLine();
                        switch (response) {
                            case "CENTER":
                                found = true;
                                break;
                            case "HIT":
                            case "MISS":
                                break;
                            case "WRONG":
                                System.exit(1);
                        }
                        if (found) {
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }
        }
    }

    private static void printCoordinates(Point point) {
        System.out.println(point.getX() + " " + point.getY());
    }

    private static class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}