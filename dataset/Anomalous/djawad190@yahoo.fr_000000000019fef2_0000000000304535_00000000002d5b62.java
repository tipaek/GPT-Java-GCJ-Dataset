import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            String solution = findPath(0, 0, x, y, "");
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String findPath(long startX, long startY, long targetX, long targetY, String currentPath) {
        List<String> solutions = new ArrayList<>();
        List<Position> positions = new ArrayList<>();

        positions.add(createPosition(startX, startY, targetX, targetY, currentPath, NORTH));
        positions.add(createPosition(startX, startY, targetX, targetY, currentPath, SOUTH));
        positions.add(createPosition(startX, startY, targetX, targetY, currentPath, EAST));
        positions.add(createPosition(startX, startY, targetX, targetY, currentPath, WEST));

        for (Position position : positions) {
            if (position.isSolution) {
                solutions.add(position.path);
            } else if (!position.path.equals(IMPOSSIBLE)) {
                String result = findPath(position.x, position.y, targetX, targetY, position.path);
                if (!result.equals(IMPOSSIBLE)) {
                    solutions.add(result);
                }
            }
        }

        if (solutions.isEmpty()) {
            return IMPOSSIBLE;
        }

        String bestSolution = solutions.get(0);
        for (String solution : solutions) {
            if (solution.length() < bestSolution.length()) {
                bestSolution = solution;
            }
        }

        return bestSolution;
    }

    private static Position createPosition(long startX, long startY, long targetX, long targetY, String currentPath, String direction) {
        long jump = (long) Math.pow(2, currentPath.length());
        long newX = startX;
        long newY = startY;
        String newPath = currentPath;

        switch (direction) {
            case NORTH:
                newY += jump;
                newPath += NORTH;
                break;
            case SOUTH:
                newY -= jump;
                newPath += SOUTH;
                break;
            case EAST:
                newX += jump;
                newPath += EAST;
                break;
            case WEST:
                newX -= jump;
                newPath += WEST;
                break;
        }

        if (Math.abs(newX) > Math.abs(targetX) + 1 || Math.abs(newY) > Math.abs(targetY) + 1) {
            newPath = IMPOSSIBLE;
        }

        boolean isSolution = newX == targetX && newY == targetY;
        return new Position(newX, newY, newPath, isSolution);
    }

    private static class Position {
        long x;
        long y;
        String path;
        boolean isSolution;

        Position(long x, long y, String path, boolean isSolution) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.isSolution = isSolution;
        }
    }
}