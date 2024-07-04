import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; ++t) {
            int n = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();
            boolean isPossible = true;
            
            // Constructing the graph
            for (int j = 0; j < n; ++j) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addIfConflicting(node);
                }
                nodes.add(node);
            }
            
            for (Node node : nodes) {
                if (!node.visited && !assignCam(node)) {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + (t + 1) + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Node node : nodes) {
                    System.out.print(node.cam ? "J" : "C");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
    
    public static boolean assignCam(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        ArrayList<Node> remainingNodes = new ArrayList<>();
        boolean currentCam = true;
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.visited) {
                if (currentNode.cam != currentCam) {
                    return false;
                }
            } else {
                currentNode.visited = true;
                currentNode.cam = currentCam;
                remainingNodes.addAll(currentNode.conflicts);
            }
            
            if (queue.isEmpty()) {
                queue.addAll(remainingNodes);
                remainingNodes.clear();
                currentCam = !currentCam;
            }
        }
        
        return true;
    }
}

class Node {
    ArrayList<Node> conflicts = new ArrayList<>();
    int start, end;
    boolean cam;
    boolean visited;
    
    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    void addIfConflicting(Node other) {
        if ((this.start <= other.start && this.end > other.start) || 
            (this.start < other.end && this.end >= other.end)) {
            this.conflicts.add(other);
            other.conflicts.add(this);
        }
    }
}