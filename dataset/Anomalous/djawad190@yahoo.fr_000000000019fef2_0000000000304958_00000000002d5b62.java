import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            long x = in.nextLong();
            long y = in.nextLong();
            long distance = calculateDistance(0, 0, x, y);

            if (distance % 2 == 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            String solution = findPath(0, 0, x, y, "");
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    static final String NORTH = "N";
    static final String SOUTH = "S";
    static final String EAST = "E";
    static final String WEST = "W";
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    static String findPath(long x1, long y1, long x, long y, String currentPath) {
        ArrayList<String> solutions = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();

        positions.add(generatePosition(x1, y1, x, y, currentPath, NORTH));
        positions.add(generatePosition(x1, y1, x, y, currentPath, SOUTH));
        positions.add(generatePosition(x1, y1, x, y, currentPath, EAST));
        positions.add(generatePosition(x1, y1, x, y, currentPath, WEST));

        for (Position pos : positions) {
            if (pos.isSolution) {
                solutions.add(pos.path);
            } else if (!pos.path.equals(IMPOSSIBLE)) {
                String solution = findPath(pos.x, pos.y, x, y, pos.path);
                if (!solution.equals(IMPOSSIBLE)) {
                    solutions.add(solution);
                }
            }
        }

        if (solutions.isEmpty()) {
            return IMPOSSIBLE;
        } else {
            String bestSolution = solutions.get(0);
            for (String solution : solutions) {
                if (bestSolution.length() > solution.length()) {
                    bestSolution = solution;
                }
            }
            return bestSolution;
        }
    }

    static Position generatePosition(long x1, long y1, long x, long y, String currentPath, String direction) {
        String path = currentPath;
        long jump = (long) Math.pow(2, currentPath.length());

        switch (direction) {
            case NORTH:
                y1 += jump;
                path += NORTH;
                if (Math.abs(y1) > Math.abs(y) + 1) path = IMPOSSIBLE;
                break;
            case SOUTH:
                y1 -= jump;
                path += SOUTH;
                if (Math.abs(y1) > Math.abs(y) + 1) path = IMPOSSIBLE;
                break;
            case EAST:
                x1 += jump;
                path += EAST;
                if (Math.abs(x1) > Math.abs(x) + 1) path = IMPOSSIBLE;
                break;
            case WEST:
                x1 -= jump;
                path += WEST;
                if (Math.abs(x1) > Math.abs(x) + 1) path = IMPOSSIBLE;
                break;
        }

        boolean isSolution = x1 == x && y1 == y;
        return new Position(x1, y1, path, isSolution);
    }

    static class Position {
        long x;
        long y;
        String path;
        boolean isSolution;

        public Position(long x, long y, String path, boolean isSolution) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.isSolution = isSolution;
        }
    }

    static long calculateDistance(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}