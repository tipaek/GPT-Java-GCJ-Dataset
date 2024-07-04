import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String movements = scanner.next();
            
            List<int[]> positions = new ArrayList<>();
            positions.add(new int[]{startX, startY});
            
            for (int i = 0; i < movements.length(); i++) {
                int[] lastPosition = positions.get(positions.size() - 1);
                int newX = lastPosition[0];
                int newY = lastPosition[1];
                
                switch (movements.charAt(i)) {
                    case 'N': newY++; break;
                    case 'S': newY--; break;
                    case 'E': newX++; break;
                    case 'W': newX--; break;
                }
                
                positions.add(new int[]{newX, newY});
            }
            
            int minSteps = findMinSteps(positions, movements);
            if (minSteps != -1) {
                System.out.println("Case #" + caseNumber + ": " + minSteps);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }

    private static int findMinSteps(List<int[]> positions, String movements) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited.add("0,0");
        
        for (int i = 1; i < positions.size(); i++) {
            int[] target = positions.get(i);
            int targetX = target[0];
            int targetY = target[1];
            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int steps = current[2];
                
                if (x == targetX && y == targetY) {
                    return steps + 1;
                }
                
                addNewPosition(queue, visited, x + 1, y, steps + 1);
                addNewPosition(queue, visited, x - 1, y, steps + 1);
                addNewPosition(queue, visited, x, y + 1, steps + 1);
                addNewPosition(queue, visited, x, y - 1, steps + 1);
            }
        }
        
        return -1; // Return -1 if impossible
    }

    private static void addNewPosition(Queue<int[]> queue, Set<String> visited, int x, int y, int steps) {
        String positionKey = x + "," + y;
        if (!visited.contains(positionKey)) {
            queue.add(new int[]{x, y, steps});
            visited.add(positionKey);
        }
    }
}