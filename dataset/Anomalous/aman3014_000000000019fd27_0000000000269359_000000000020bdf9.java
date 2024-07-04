import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            ArrayList<Node> nodes = new ArrayList<>();
            boolean possible = true;

            // Prepare the directed graph
            for (int j = 0; j < n; ++j) {
                Node node = new Node(in.nextInt(), in.nextInt());
                for (Node existingNode : nodes) {
                    existingNode.addIfConflicting(node);
                    node.addIfConflicting(existingNode);
                }
                nodes.add(node);
            }

            for (Node node : nodes) {
                if (!node.visited && !assignCameras(node)) {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Node node : nodes) {
                    System.out.print(node.camera ? "J" : "C");
                }
                System.out.println();
            }
        }
    }

    private static boolean assignCameras(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        ArrayList<Node> remaining = new ArrayList<>();
        boolean camera = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.visited) {
                if (current.camera != camera) {
                    return false;
                }
            } else {
                current.visited = true;
                current.camera = camera;
                remaining.addAll(current.conflicts);
            }

            if (queue.isEmpty()) {
                queue.addAll(remaining);
                remaining.clear();
                camera = !camera;
            }
        }

        return true;
    }
}

class Node {
    ArrayList<Node> conflicts = new ArrayList<>();
    int start, finish;
    boolean camera;
    boolean visited;

    Node(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    void addIfConflicting(Node other) {
        if ((start >= other.start && start < other.finish) || 
            (finish > other.start && finish <= other.finish)) {
            conflicts.add(other);
        }
    }
}