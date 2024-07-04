import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int numIntervals = scanner.nextInt();
            List<Node> nodes = new ArrayList<>();
            boolean isPossible = true;

            // Constructing the graph
            for (int i = 0; i < numIntervals; i++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addConflictIfNecessary(node);
                }
                nodes.add(node);
            }

            for (Node node : nodes) {
                if (!assignCamera(node)) {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Node node : nodes) {
                    System.out.print(node.isCameraJ ? "J" : "C");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    private static boolean assignCamera(Node startNode) {
        if (startNode.isVisited) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        List<Node> remainingNodes = new ArrayList<>();
        boolean cameraType = true;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.isVisited) {
                if (currentNode.isCameraJ != cameraType) {
                    return false;
                }
            } else {
                currentNode.isVisited = true;
                currentNode.isCameraJ = cameraType;
                remainingNodes.addAll(currentNode.conflictingNodes);
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
    List<Node> conflictingNodes = new ArrayList<>();
    int startTime, endTime;
    boolean isCameraJ;
    boolean isVisited;

    Node(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    void addConflictIfNecessary(Node otherNode) {
        if ((this.startTime < otherNode.startTime && this.endTime > otherNode.startTime) ||
            (this.startTime < otherNode.endTime && this.endTime > otherNode.endTime)) {
            conflictingNodes.add(otherNode);
        }
    }
}