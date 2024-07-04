import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int tc = 1; tc <= t; tc++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String res = "IMPOSSIBLE";
            Map<Integer, Set<Integer>> visited = new HashMap<>();
            Queue<Point> queue = new LinkedList<>();
            
            queue.add(new Point(0, 0));
            queue.add(new Point(-1, -1)); // Delimiter for levels
            
            int stick = 1;
            
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                
                if (p.x == -1 && p.y == -1) {
                    if (!queue.isEmpty()) {
                        queue.add(new Point(-1, -1));
                    }
                    stick *= 2;
                    continue;
                }
                
                int x = p.x;
                int y = p.y;
                
                if (!visited.containsKey(x)) {
                    visited.put(x, new HashSet<>());
                }
                
                if (visited.get(x).contains(y)) {
                    continue;
                }
                
                visited.get(x).add(y);
                
                if (x == X && y == Y) {
                    res = p.s;
                    break;
                }
                
                if (isValid(X, Y, x - stick, y)) {
                    queue.add(new Point(x - stick, y, p.s + "W"));
                }
                if (isValid(X, Y, x + stick, y)) {
                    queue.add(new Point(x + stick, y, p.s + "E"));
                }
                if (isValid(X, Y, x, y - stick)) {
                    queue.add(new Point(x, y - stick, p.s + "S"));
                }
                if (isValid(X, Y, x, y + stick)) {
                    queue.add(new Point(x, y + stick, p.s + "N"));
                }
            }
            
            System.out.println("Case #" + tc + ": " + res);
        }
        
        sc.close();
    }
    
    static boolean isValid(int X, int Y, int x, int y) {
        return Math.abs(x) <= Math.abs(X) && Math.abs(y) <= Math.abs(Y);
    }
}

class Point {
    String s;
    int x, y;

    Point(int x, int y) {
        this(x, y, "");
    }

    Point(int x, int y, String s) {
        this.s = s;
        this.x = x;
        this.y = y;
    }
}