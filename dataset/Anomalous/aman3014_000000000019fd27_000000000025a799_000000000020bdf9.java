import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; ++t) {
            int n = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();
            boolean isPossible = true;
            
            // Building the directed graph
            for (int j = 0; j < n; ++j) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addIfConflicting(node);
                }
                nodes.add(node);
            }
            
            for (Node node : nodes) {
                if (!assignLabels(node)) {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + (t + 1) + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            
            for (Node node : nodes) {
                System.out.print(node.isCam ? "C" : "J");
            }
            System.out.println();
        }
    }
    
    public static boolean assignLabels(Node node) {
        if (node.visited) {
            return true;
        }
        
        node.visited = true;
        boolean label = node.isCam;
        
        for (Node conflictNode : node.conflicts) {
            if (conflictNode.visited) {
                if (conflictNode.isCam == label) {
                    return false;
                }
            } else {
                conflictNode.isCam = !label;
                if (!assignLabels(conflictNode)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

class Node {
    ArrayList<Node> conflicts = new ArrayList<>();
    int start, end;
    boolean isCam;
    boolean visited;
    
    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    void addIfConflicting(Node other) {
        if ((this.start < other.start && this.end > other.start) || 
            (this.start < other.end && this.end > other.end)) {
            this.conflicts.add(other);
        }
    }
}