import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        
        for (int i = 0; i < testCases; i++) {
            String[] coordinates = scanner.nextLine().split(" ");
            int x = Integer.parseInt(coordinates[0].trim());
            int y = Integer.parseInt(coordinates[1].trim());
            
            String result = findPath(0, 0, x, y, 1, "");
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    private static String findPath(int currX, int currY, int targetX, int targetY, int power, String path) {
        if (currX == targetX && currY == targetY) {
            return path;
        } else if (path.length() > 1000) {
            return "IMPOSSIBLE";
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(currX, currY, path, power));
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            if (currentNode.x == targetX && currentNode.y == targetY) {
                return currentNode.path;
            }
            
            int step = (int) Math.pow(2, currentNode.power - 1);
            
            queue.add(new Node(currentNode.x + step, currentNode.y, currentNode.path + "E", currentNode.power + 1));
            queue.add(new Node(currentNode.x - step, currentNode.y, currentNode.path + "W", currentNode.power + 1));
            queue.add(new Node(currentNode.x, currentNode.y + step, currentNode.path + "N", currentNode.power + 1));
            queue.add(new Node(currentNode.x, currentNode.y - step, currentNode.path + "S", currentNode.power + 1));
        }
        
        return "IMPOSSIBLE";
    }
    
    private static class Node {
        int x, y, power;
        String path;
        
        Node(int x, int y, String path, int power) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.power = power;
        }
    }
}