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

                for (int r = -7; r <= 7; r++) {
                    for (int c = -7; c <= 7; c++) {
                        Points point = new Points(r, c);
                        if (!found) {
                            System.out.printf("%d %d%n", point.getX(), point.getY());
                        }

                        String response = sc.nextLine();

                        if ("CENTER".equals(response)) {
                            found = true;
                            break;
                        } else if ("WRONG".equals(response)) {
                            System.exit(1);
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }
        }
    }

    private static class Points {
        private final int x;
        private final int y;

        public Points(int x, int y) {
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
            Points points = (Points) o;
            return x == points.x && y == points.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}