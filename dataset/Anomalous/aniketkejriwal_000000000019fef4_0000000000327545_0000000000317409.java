import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        
        for (int i = 1; i <= T; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.nextLine().trim();
            
            ArrayList<int[]> positions = new ArrayList<>();
            positions.add(new int[]{X, Y});
            
            for (char move : M.toCharArray()) {
                int[] lastPos = positions.get(positions.size() - 1);
                switch (move) {
                    case 'N':
                        positions.add(new int[]{lastPos[0], lastPos[1] + 1});
                        break;
                    case 'S':
                        positions.add(new int[]{lastPos[0], lastPos[1] - 1});
                        break;
                    case 'E':
                        positions.add(new int[]{lastPos[0] + 1, lastPos[1]});
                        break;
                    case 'W':
                        positions.add(new int[]{lastPos[0] - 1, lastPos[1]});
                        break;
                }
            }
            
            int minSteps = -1;
            Set<String> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 0});
            visited.add("0,0");
            
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0], y = current[1], steps = current[2];
                
                if (steps < positions.size() && x == positions.get(steps)[0] && y == positions.get(steps)[1]) {
                    minSteps = steps;
                    break;
                }
                
                if (steps + 1 < positions.size()) {
                    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                    for (int[] dir : directions) {
                        int newX = x + dir[0], newY = y + dir[1];
                        String key = newX + "," + newY;
                        if (!visited.contains(key)) {
                            queue.add(new int[]{newX, newY, steps + 1});
                            visited.add(key);
                        }
                    }
                }
            }
            
            if (minSteps != -1) {
                System.out.println("Case #" + i + ": " + minSteps);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        in.close();
    }
}