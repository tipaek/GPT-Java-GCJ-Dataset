import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();
            boolean isPossible = true;
            
            // Construct the graph
            for (int j = 0; j < n; j++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addConflictIfNeeded(node);
                    node.addConflictIfNeeded(existingNode);
                }
                nodes.add(node);
            }
            
            for (Node node : nodes) {
                if (!node.visited && !assignCamera(node)) {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + testCase + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Node node : nodes) {
                    System.out.print(node.cameraAssigned ? "J" : "C");
                }
                System.out.println();
            }
        }
    }
    
    public static boolean assignCamera(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        ArrayList<Node> remainingNodes = new ArrayList<>();
        boolean currentCamera = true;
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.visited) {
                if (currentNode.cameraAssigned != currentCamera) {
                    return false;
                }
            } else {
                currentNode.visited = true;
                currentNode.cameraAssigned = currentCamera;
                remainingNodes.addAll(currentNode.conflicts);
            }
            
            if (queue.isEmpty()) {
                queue.addAll(remainingNodes);
                remainingNodes.clear();
                currentCamera = !currentCamera;
            }
        }
        
        return true;
    }
}

class Node {
    ArrayList<Node> conflicts = new ArrayList<>();
    int start, finish;
    boolean cameraAssigned;
    boolean visited;
    
    Node(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
    
    void addConflictIfNeeded(Node other) {
        if ((start >= other.start && start < other.finish) ||
            (finish > other.start && finish <= other.finish) ||
            (start < other.start && finish > other.finish)) {
            conflicts.add(other);
        }
    }
}