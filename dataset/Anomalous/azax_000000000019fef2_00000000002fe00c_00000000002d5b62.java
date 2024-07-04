import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final long MAX_STEP = 2147483649L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        Map<Pair, String> targets = new LinkedHashMap<>();
        
        for (int i = 0; i < numCases; i++) {
            String[] coordinates = scanner.nextLine().split(" ");
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
        
        scanner.close();
    }

    private static void findPaths(Map<Pair, String> cases) {
        Set<Pair> targets = new HashSet<>(cases.keySet());
        Map<String, Pair> currentPaths = new HashMap<>();
        currentPaths.put("", new Pair(0, 0));
        long step = 1;
        
        while (!targets.isEmpty() && step < MAX_STEP) {
            Map<String, Pair> newPaths = new HashMap<>();
            
            for (Map.Entry<String, Pair> entry : currentPaths.entrySet()) {
                Pair currentPosition = entry.getValue();
                
                for (Direction direction : Direction.values()) {
                    Pair nextPosition = new Pair(currentPosition.x + direction.dx * step, currentPosition.y + direction.dy * step);
                    String newPath = entry.getKey() + direction.symbol;
                    
                    if (targets.contains(nextPosition)) {
                        cases.put(nextPosition, newPath);
                        targets.remove(nextPosition);
                    }
                    
                    newPaths.put(newPath, nextPosition);
                }
            }
            
            targets.removeIf(p -> step / 2 > Math.abs(p.x) && step / 2 > Math.abs(p.y));
            currentPaths = newPaths;
            step *= 2;
        }
    }

    private static class Pair {
        long x;
        long y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
}