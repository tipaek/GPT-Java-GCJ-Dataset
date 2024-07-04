import java.util.*;

public class Solution {

    static Set<Position> visitedPositions = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            visitedPositions.clear();
            int xTarget = scanner.nextInt();
            int yTarget = scanner.nextInt();
            int jump = 1;

            List<Location> locations = new ArrayList<>();
            locations.add(new Location(new Position(0, 0), ""));
            boolean foundAnswer = false;

            while ((jump - Math.abs(xTarget)) < Math.abs(yTarget)) {
                List<Location> newLocations = new ArrayList<>();
                for (Location location : locations) {
                    if (!visitedPositions.contains(location.position)) {
                        int x = location.position.x;
                        int y = location.position.y;
                        String steps = location.steps;
                        String answer = null;

                        if (x - jump == xTarget && y == yTarget) {
                            answer = steps + "W";
                        }
                        if (x == xTarget - jump && y == yTarget) {
                            answer = steps + "E";
                        }
                        if (x == xTarget && y - jump == yTarget) {
                            answer = steps + "S";
                        }
                        if (x == xTarget && y == yTarget - jump) {
                            answer = steps + "N";
                        }

                        visitedPositions.add(location.position);

                        if (answer != null) {
                            foundAnswer = true;
                            System.out.println("Case #" + testCase + ": " + answer);
                            break;
                        } else {
                            addNewLocations(newLocations, x, y, jump, steps);
                        }
                    }
                }
                if (foundAnswer) break;
                locations = newLocations;
                jump *= 2;
            }
            if (!foundAnswer) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void addNewLocations(List<Location> newLocations, int x, int y, int jump, String steps) {
        if (!visitedPositions.contains(new Position(x - jump, y))) {
            newLocations.add(new Location(new Position(x - jump, y), steps + "W"));
        }
        if (!visitedPositions.contains(new Position(x + jump, y))) {
            newLocations.add(new Location(new Position(x + jump, y), steps + "E"));
        }
        if (!visitedPositions.contains(new Position(x, y - jump))) {
            newLocations.add(new Location(new Position(x, y - jump), steps + "S"));
        }
        if (!visitedPositions.contains(new Position(x, y + jump))) {
            newLocations.add(new Location(new Position(x, y + jump), steps + "N"));
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}