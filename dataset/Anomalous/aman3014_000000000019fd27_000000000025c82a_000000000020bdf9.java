import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Node> nodes = new ArrayList<>();
            boolean isPossible = true;
            
            // Create nodes and build the conflict graph
            for (int j = 0; j < n; j++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addConflictIfNecessary(node);
                }
                nodes.add(node);
            }
            
            for (Node node : nodes) {
                if (!assignRoles(node)) {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + t + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Node node : nodes) {
                    System.out.print(node.isCam ? "J" : "C");
                }
                System.out.println();
            }
        }
    }
    
    private static boolean assignRoles(Node startNode) {
        if (startNode.visited) return true;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        List<Node> nextLevel = new ArrayList<>();
        boolean currentRole = true;
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.visited) {
                if (currentNode.isCam != currentRole) {
                    return false;
                }
            } else {
                currentNode.visited = true;
                currentNode.isCam = currentRole;
                nextLevel.addAll(currentNode.conflicts);
            }
            
            if (queue.isEmpty()) {
                queue.addAll(nextLevel);
                nextLevel.clear();
                currentRole = !currentRole;
            }
        }
        
        return true;
    }
}

class Node {
    List<Node> conflicts = new ArrayList<>();
    int start, finish;
    boolean isCam;
    boolean visited;
    
    Node(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
    
    void addConflictIfNecessary(Node other) {
        if ((this.start < other.start && this.finish > other.start) ||
            (this.start < other.finish && this.finish > other.finish)) {
            this.conflicts.add(other);
            other.conflicts.add(this);
        }
    }
}