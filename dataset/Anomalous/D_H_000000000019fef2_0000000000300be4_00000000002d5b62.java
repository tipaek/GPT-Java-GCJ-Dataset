import java.util.*;

public class Solution {

    private static Set<Position> visitedPositions = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            visitedPositions.clear();
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            int jumpLength = 1;

            List<Location> currentLocations = new ArrayList<>();
            currentLocations.add(new Location(new Position(0, 0), ""));
            boolean foundSolution = false;

            while ((jumpLength - Math.abs(targetX)) < Math.abs(targetY)) {
                List<Location> nextLocations = new ArrayList<>();

                for (Location location : currentLocations) {
                    if (!visitedPositions.contains(location.position)) {
                        int x = location.position.x;
                        int y = location.position.y;
                        String steps = location.steps;
                        String result = null;

                        if (x - jumpLength == targetX && y == targetY) {
                            result = steps + "W";
                        } else if (x + jumpLength == targetX && y == targetY) {
                            result = steps + "E";
                        } else if (x == targetX && y - jumpLength == targetY) {
                            result = steps + "S";
                        } else if (x == targetX && y + jumpLength == targetY) {
                            result = steps + "N";
                        }

                        visitedPositions.add(location.position);

                        if (result != null) {
                            foundSolution = true;
                            System.out.println("Case #" + testCase + ": " + result);
                            break;
                        } else {
                            addNewLocation(nextLocations, x - jumpLength, y, steps + "W");
                            addNewLocation(nextLocations, x + jumpLength, y, steps + "E");
                            addNewLocation(nextLocations, x, y - jumpLength, steps + "S");
                            addNewLocation(nextLocations, x, y + jumpLength, steps + "N");
                        }
                    }
                }

                if (foundSolution) {
                    break;
                }

                currentLocations = nextLocations;
                jumpLength *= 2;
            }

            if (!foundSolution) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void addNewLocation(List<Location> locations, int x, int y, String steps) {
        Position newPosition = new Position(x, y);
        if (!visitedPositions.contains(newPosition)) {
            locations.add(new Location(newPosition, steps));
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