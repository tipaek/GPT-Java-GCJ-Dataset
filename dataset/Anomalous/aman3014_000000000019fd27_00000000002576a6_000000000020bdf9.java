import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addIfConflicting(node);
                }
                nodes.add(node);
            }

            boolean isPossible = true;
            for (Node node : nodes) {
                if (!assignRoles(node)) {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Node node : nodes) {
                    System.out.print(node.role ? "C" : "J");
                }
                System.out.println();
            }
        }
    }

    public static boolean assignRoles(Node node) {
        if (!node.visited) {
            node.role = false;
            node.visited = true;
        }

        for (Node conflictNode : node.conflicts) {
            if (!conflictNode.visited) {
                conflictNode.role = !node.role;
                conflictNode.visited = true;
                if (!assignRoles(conflictNode)) {
                    return false;
                }
            } else if (conflictNode.role == node.role) {
                return false;
            }
        }
        return true;
    }
}

class Node {
    int start, end;
    boolean role;
    boolean visited;
    ArrayList<Node> conflicts;

    Node(int start, int end) {
        this.start = start;
        this.end = end;
        this.role = false;
        this.visited = false;
        this.conflicts = new ArrayList<>();
    }

    void addIfConflicting(Node other) {
        if ((this.start < other.start && this.end > other.start) || 
            (this.start < other.end && this.end > other.end)) {
            this.conflicts.add(other);
        }
    }
}