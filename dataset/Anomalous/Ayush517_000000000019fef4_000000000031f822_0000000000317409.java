import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            
            char[] directionArray = directions.toCharArray();
            Set<Pair> visited = new HashSet<>();
            Queue<Pair> queue = new LinkedList<>();
            
            queue.add(new Pair(0, 0));
            visited.add(new Pair(0, 0));
            
            int steps = 0;
            boolean reached = false;
            
            for (int i = 0; i < directionArray.length && !reached; i++) {
                steps++;
                if (directionArray[i] == 'S') {
                    x--;
                } else if (directionArray[i] == 'N') {
                    x++;
                } else if (directionArray[i] == 'E') {
                    y++;
                } else if (directionArray[i] == 'W') {
                    y--;
                }
                
                Pair current = new Pair(x, y);
                int size = queue.size();
                
                for (int j = 0; j < size; j++) {
                    Pair position = queue.poll();
                    
                    int[][] moves = {
                        {position.x, position.y + 1},
                        {position.x, position.y - 1},
                        {position.x + 1, position.y},
                        {position.x - 1, position.y}
                    };
                    
                    for (int[] move : moves) {
                        Pair nextPosition = new Pair(move[0], move[1]);
                        if (current.equals(nextPosition)) {
                            reached = true;
                            break;
                        }
                        if (!visited.contains(nextPosition)) {
                            queue.add(nextPosition);
                            visited.add(nextPosition);
                        }
                    }
                    
                    if (reached) {
                        break;
                    }
                }
            }
            
            if (reached) {
                System.out.println("Case #" + testCase + ": " + steps);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}

class Pair {
    int x;
    int y;
    
    Pair(int x, int y) {
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