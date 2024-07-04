import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();
            boolean isPossible = true;

            // Constructing the directed graph
            for (int j = 0; j < n; j++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addConflictIfNeeded(node);
                }
                nodes.add(node);
            }

            for (Node node : nodes) {
                if (!assignCam(node)) {
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
                System.out.print(node.isCam() ? "C" : "J");
            }
            System.out.println();
        }
    }

    public static boolean assignCam(Node node) {
        if (node.isVisited()) {
            return true;
        }

        node.setCam(false);
        node.setVisited(true);

        for (Node conflictNode : node.getConflicts()) {
            if (conflictNode.isVisited()) {
                if (conflictNode.isCam() == node.isCam()) {
                    return false;
                }
            } else {
                conflictNode.setCam(!node.isCam());
                conflictNode.setVisited(true);
                if (!assignCam(conflictNode)) {
                    return false;
                }
            }
        }

        return true;
    }
}

class Node {
    private ArrayList<Node> conflicts = new ArrayList<>();
    private int start;
    private int finish;
    private boolean cam;
    private boolean visited;

    Node(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    void addConflictIfNeeded(Node other) {
        if ((this.start < other.start && this.finish > other.start) ||
            (this.start < other.finish && this.finish > other.finish)) {
            conflicts.add(other);
        }
    }

    ArrayList<Node> getConflicts() {
        return conflicts;
    }

    boolean isCam() {
        return cam;
    }

    void setCam(boolean cam) {
        this.cam = cam;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }
}