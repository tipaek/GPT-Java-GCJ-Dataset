import java.util.*;

public class Solution {

    static Set<Position> visitedPositions = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numCases; testCase++) {
            visitedPositions.clear();
            int xTarget = scanner.nextInt();
            int yTarget = scanner.nextInt();
            int jump = 1;

            List<Location> locations = new ArrayList<>();
            locations.add(new Location(new Position(0, 0), ""));
            boolean foundSolution = false;

            while ((jump - Math.abs(xTarget)) < Math.abs(yTarget)) {
                if (foundSolution) {
                    break;
                }
                List<Location> newLocations = new ArrayList<>();
                for (Location loc : locations) {
                    if (!visitedPositions.contains(loc.position)) {
                        int x = loc.position.x;
                        int y = loc.position.y;
                        String steps = loc.steps;
                        String solution = null;

                        if (x - jump == xTarget && y == yTarget) {
                            solution = steps + "W";
                        }
                        if (x + jump == xTarget && y == yTarget) {
                            solution = steps + "E";
                        }
                        if (x == xTarget && y - jump == yTarget) {
                            solution = steps + "S";
                        }
                        if (x == xTarget && y + jump == yTarget) {
                            solution = steps + "N";
                        }

                        visitedPositions.add(loc.position);

                        if (solution != null) {
                            foundSolution = true;
                            System.out.println("Case #" + testCase + ": " + solution);
                            break;
                        } else {
                            addNewLocation(newLocations, x - jump, y, steps + "W");
                            addNewLocation(newLocations, x + jump, y, steps + "E");
                            addNewLocation(newLocations, x, y - jump, steps + "S");
                            addNewLocation(newLocations, x, y + jump, steps + "N");
                        }
                    }
                }
                locations = newLocations;
                jump *= 2;
            }
            if (!foundSolution) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void addNewLocation(List<Location> newLocations, int x, int y, String steps) {
        Position newPosition = new Position(x, y);
        if (!visitedPositions.contains(newPosition)) {
            newLocations.add(new Location(newPosition, steps));
        }
    }

}

class Location {
    Position position;
    String steps;

    public Location(Position position, String steps) {
        this.position = position;
        this.steps = steps;
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}