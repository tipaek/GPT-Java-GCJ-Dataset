import java.util.*;

public class Solution {
    
    public static String getResult(int x, int y) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        Queue<QueueElement> queue = new LinkedList<>();
        queue.offer(new QueueElement(0, 0, 0, ""));
        
        visited.putIfAbsent(0, new HashSet<>());
        visited.get(0).add(0);
        
        while (!queue.isEmpty()) {
            QueueElement current = queue.poll();
            if (current.x == x && current.y == y) return current.direction;
            
            for (QueueElement next : getNext(current)) {
                visited.putIfAbsent(next.x, new HashSet<>());
                if (!visited.get(next.x).contains(next.y)) {
                    visited.get(next.x).add(next.y);
                    queue.offer(next);
                }
            }
        }
        return "IMPOSSIBLE";
    }
    
    public static List<QueueElement> getNext(QueueElement element) {
        List<QueueElement> nextMoves = new ArrayList<>();
        long step = 1L << element.step; // 2^step using bitwise shift
        
        if (element.y + step <= 100) {
            nextMoves.add(new QueueElement(element.x, element.y + step, element.step + 1, element.direction + "N"));
        }
        if (element.y - step >= -100) {
            nextMoves.add(new QueueElement(element.x, element.y - step, element.step + 1, element.direction + "S"));
        }
        if (element.x + step <= 100) {
            nextMoves.add(new QueueElement(element.x + step, element.y, element.step + 1, element.direction + "E"));
        }
        if (element.x - step >= -100) {
            nextMoves.add(new QueueElement(element.x - step, element.y, element.step + 1, element.direction + "W"));
        }
        return nextMoves;
    }
    
    public static class QueueElement {
        private final long x;
        private final long y;
        private final int step;
        private final String direction;
        
        public QueueElement(long x, long y, int step, String direction) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.direction = direction;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + getResult(x, y));
        }
    }
}