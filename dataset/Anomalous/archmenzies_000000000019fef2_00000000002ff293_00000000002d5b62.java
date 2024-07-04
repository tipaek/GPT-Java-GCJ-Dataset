import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {

    enum Direction {
        N(1), E(1), S(-1), W(-1);

        private final int sign;

        Direction(int sign) {
            this.sign = sign;
        }

        public int getDistance(int i) {
            return sign * (int) Math.pow(2, i);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int[] coordinates = Stream.of(inputReader.readLine().split(" "))
                                          .mapToInt(Integer::parseInt)
                                          .toArray();
                int x = coordinates[0];
                int y = coordinates[1];

                int maxJumps = (int) Math.ceil(Math.log(Math.abs(x) + Math.abs(y) + 1) / Math.log(2));

                String path = findPath(x, y, maxJumps);
                System.out.printf("Case #%d: %s%n", t, path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findPath(int x, int y, int maxJumps) {
        if (x == 0 && y == 0) {
            return "";
        } else if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            return "IMPOSSIBLE";
        } else {
            return getPath("", x, y, maxJumps);
        }
    }

    private static String getPath(String currentPath, int x, int y, int maxJumps) {
        if (currentPath.length() > maxJumps && (x != 0 || y != 0)) {
            return "IMPOSSIBLE";
        } else if (x == 0 && y == 0) {
            return currentPath;
        } else {
            String north = getPath(currentPath + Direction.N.name(), x, y - Direction.N.getDistance(currentPath.length()), maxJumps);
            String south = getPath(currentPath + Direction.S.name(), x, y - Direction.S.getDistance(currentPath.length()), maxJumps);
            String east = getPath(currentPath + Direction.E.name(), x - Direction.E.getDistance(currentPath.length()), y, maxJumps);
            String west = getPath(currentPath + Direction.W.name(), x - Direction.W.getDistance(currentPath.length()), y, maxJumps);

            return reducePaths(reducePaths(north, south), reducePaths(east, west));
        }
    }

    private static String reducePaths(String path1, String path2) {
        if ("IMPOSSIBLE".equals(path1) && "IMPOSSIBLE".equals(path2)) {
            return "IMPOSSIBLE";
        } else if ("IMPOSSIBLE".equals(path1)) {
            return path2;
        } else if ("IMPOSSIBLE".equals(path2)) {
            return path1;
        } else {
            return path1.length() <= path2.length() ? path1 : path2;
        }
    }
}