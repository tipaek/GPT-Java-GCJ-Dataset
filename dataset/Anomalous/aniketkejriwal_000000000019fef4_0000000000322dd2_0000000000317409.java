import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= T; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();
            
            List<int[]> positions = new ArrayList<>();
            positions.add(new int[]{X, Y});
            
            for (int j = 0; j < M.length(); j++) {
                char move = M.charAt(j);
                int[] lastPosition = positions.get(positions.size() - 1);
                int newX = lastPosition[0];
                int newY = lastPosition[1];
                
                switch (move) {
                    case 'N': newY++; break;
                    case 'S': newY--; break;
                    case 'E': newX++; break;
                    case 'W': newX--; break;
                }
                
                positions.add(new int[]{newX, newY});
            }
            
            boolean found = false;
            int minTime = 0;
            
            Set<String> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 0}); // x, y, time
            
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int time = current[2];
                
                if (time < positions.size() && x == positions.get(time)[0] && y == positions.get(time)[1]) {
                    minTime = time;
                    found = true;
                    break;
                }
                
                if (visited.contains(x + "," + y)) continue;
                visited.add(x + "," + y);
                
                queue.add(new int[]{x + 1, y, time + 1});
                queue.add(new int[]{x - 1, y, time + 1});
                queue.add(new int[]{x, y + 1, time + 1});
                queue.add(new int[]{x, y - 1, time + 1});
            }
            
            if (found) {
                System.out.println("Case #" + i + ": " + minTime);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}