import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final long MAX_STEP = 4294967297L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(sc.nextLine());
        Map<Pair, String> targets = new LinkedHashMap<>();
        for (int i = 0; i < numCases; i++) {
            String[] coordinates = sc.nextLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            targets.put(new Pair(x, y), "IMPOSSIBLE");
        }
        findPaths(targets);
        int caseNumber = 1;
        for (Map.Entry<Pair, String> entry : targets.entrySet()) {
            System.out.println("Case #" + caseNumber + ": " + entry.getValue());
            caseNumber++;
        }
        sc.close();
    }

    private static void findPaths(Map<Pair, String> cases) {
        Set<Pair> targets = new HashSet<>(cases.keySet());
        Map<String, Pair> currentMap = new HashMap<>();
        currentMap.put("", new Pair(0, 0));
        long step = 1;

        while (!targets.isEmpty() && step < MAX_STEP) {
            Map<String, Pair> nextMap = new HashMap<>();
            for (Map.Entry<String, Pair> entry : currentMap.entrySet()) {
                Pair position = entry.getValue();
                for (Direction direction : Direction.values()) {
                    Pair newPosition = new Pair(position.x + direction.dx * step, position.y + direction.dy * step);
                    String newPath = entry.getKey() + direction.symbol;
                    if (targets.contains(newPosition)) {
                        cases.put(newPosition, newPath);
                        targets.remove(newPosition);
                    }
                    nextMap.put(newPath, newPosition);
                }
            }
            targets.removeIf(p -> step / 2 > Math.abs(p.x) && step / 2 > Math.abs(p.y));
            currentMap = nextMap;
            step *= 2;
        }
    }

    enum Direction {
        EAST('E', 1, 0), 
        NORTH('N', 0, 1), 
        WEST('W', -1, 0), 
        SOUTH('S', 0, -1);

        final char symbol;
        final int dx, dy;

        Direction(char symbol, int dx, int dy) {
            this.symbol = symbol;
            this.dx = dx;
            this.dy = dy;
        }
    }

    static class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}