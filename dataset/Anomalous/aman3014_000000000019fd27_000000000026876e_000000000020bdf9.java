import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();
            boolean isPossible = true;
            
            // Constructing the directed graph
            for (int j = 0; j < n; j++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addIfConflicting(node);
                    node.addIfConflicting(existingNode);
                }
                nodes.add(node);
            }
            
            for (Node node : nodes) {
                if (!node.visited && !assignCameras(node)) {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + (i + 1) + ": ");
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
    
    private static boolean assignCameras(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        ArrayList<Node> remainingNodes = new ArrayList<>();
        boolean cameraType = true;
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.visited) {
                if (currentNode.cameraAssigned != cameraType) {
                    return false;
                }
            } else {
                currentNode.visited = true;
                currentNode.cameraAssigned = cameraType;
                remainingNodes.addAll(currentNode.conflictedNodes);
            }
            
            if (queue.isEmpty()) {
                queue.addAll(remainingNodes);
                remainingNodes.clear();
                cameraType = !cameraType;
            }
        }
        
        return true;
    }
}

class Node {
    ArrayList<Node> conflictedNodes = new ArrayList<>();
    int startTime, endTime;
    boolean cameraAssigned;
    boolean visited;
    
    Node(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }
    
    void addIfConflicting(Node otherNode) {
        if (this.startTime <= otherNode.startTime && this.endTime > otherNode.startTime) {
            conflictedNodes.add(otherNode);
        } else if (this.startTime < otherNode.endTime && this.endTime >= otherNode.endTime) {
            conflictedNodes.add(otherNode);
        } else if (this.startTime >= otherNode.endTime && this.endTime <= otherNode.endTime) {
            conflictedNodes.add(otherNode);
        }
    }
}