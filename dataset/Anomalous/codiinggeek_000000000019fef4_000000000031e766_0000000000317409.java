import java.io.*;
import java.util.*;

public class Solution {
    static final long MOD = 1000000000L;

    public static void main(String[] args) {
        try {
            FastReader reader = new FastReader();
            int testCases = reader.nextInt();
            int caseNumber = 1;
            
            while (testCases-- > 0) {
                int e = reader.nextInt();
                int n = reader.nextInt();
                String directions = reader.next();
                int length = directions.length();
                List<Coordinate> coordinates = new ArrayList<>();

                for (int i = 0; i < length; i++) {
                    char direction = directions.charAt(i);
                    if (direction == 'N') n++;
                    else if (direction == 'E') e++;
                    else if (direction == 'S') n--;
                    else if (direction == 'W') e--;

                    coordinates.add(new Coordinate(e, n));
                }

                int currentX = 0, currentY = 0, minSteps = 0;
                boolean found = false;

                for (Coordinate coord : coordinates) {
                    int targetX = coord.x;
                    int targetY = coord.y;

                    if (currentX == targetX && currentY == targetY) {
                        minSteps++;
                        found = true;
                        break;
                    }
                    
                    if (isAdjacent(currentX, currentY, targetX, targetY)) {
                        minSteps++;
                        found = true;
                        break;
                    }

                    if (targetX > currentX) currentX++;
                    else if (targetX < currentX) currentX--;
                    else if (targetY > currentY) currentY++;
                    else if (targetY < currentY) currentY--;

                    minSteps++;
                }

                if (!found) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + minSteps);
                }
                caseNumber++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static boolean isAdjacent(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) == 1 && y1 == y2) || (Math.abs(y1 - y2) == 1 && x1 == x2);
    }

    static class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}