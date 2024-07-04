import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            for (int i = 0; i < numberOfTestCases; i++) {
                boolean found = false;
                
                for (int r = -8; r < 8 && !found; r++) {
                    for (int c = -8; c < 8 && !found; c++) {
                        Point point = new Point(r, c);
                        printCoordinates(found, point);
                        
                        String response = sc.nextLine();
                        switch (response) {
                            case "CENTER":
                                found = true;
                                break;
                            case "HIT":
                            case "MISS":
                                // No action needed for "HIT" and "MISS"
                                break;
                            case "WRONG":
                                System.exit(1);
                                break;
                        }
                    }
                }
            }
        }
    }

    private static void printCoordinates(boolean found, Point point) {
        if (!found) {
            System.out.printf("%d %d%n", point.getX(), point.getY());
        }
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}