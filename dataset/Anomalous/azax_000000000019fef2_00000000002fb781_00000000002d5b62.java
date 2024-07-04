import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final long MAX_STEP = 257L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(sc.nextLine());
        Map<Pair, String> targets = new LinkedHashMap<>();

        for (int index = 0; index < numCases; index++) {
            String[] line = sc.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
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
                Pair currentPair = entry.getValue();

                for (Direction direction : Direction.values()) {
                    Pair newPair = new Pair(currentPair.x + direction.dx * step, currentPair.y + direction.dy * step);
                    String newPath = entry.getKey() + direction.symbol;

                    if (targets.contains(newPair)) {
                        cases.put(newPair, newPath);
                        targets.remove(newPair);
                    }

                    nextMap.put(newPath, newPair);
                }
            }

            currentMap = nextMap;
            step *= 2;
        }
    }

    private enum Direction {
        EAST(1, 0, 'E'),
        NORTH(0, 1, 'N'),
        WEST(-1, 0, 'W'),
        SOUTH(0, -1, 'S');

        final long dx;
        final long dy;
        final char symbol;

        Direction(long dx, long dy, char symbol) {
            this.dx = dx;
            this.dy = dy;
            this.symbol = symbol;
        }
    }

    static class Pair {
        final long x;
        final long y;

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