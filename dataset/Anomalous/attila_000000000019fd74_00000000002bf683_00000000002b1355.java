import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Node {
        int value;
        Node north, south, east, west;
        int eliminatedRound = -1;

        double calculateAverage() {
            double sum = 0;
            double count = 0;
            if (north != null) {
                sum += north.value;
                count++;
            }
            if (south != null) {
                sum += south.value;
                count++;
            }
            if (east != null) {
                sum += east.value;
                count++;
            }
            if (west != null) {
                sum += west.value;
                count++;
            }
            return sum / count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int columns = Integer.parseInt(dimensions[1]);
            List<Node> nodes = new ArrayList<>(rows * columns);
            for (int i = 0; i < rows; i++) {
                String[] values = scanner.nextLine().split(" ");
                for (int j = 0; j < columns; j++) {
                    Node node = new Node();
                    node.value = Integer.parseInt(values[j]);
                    nodes.add(node);
                }
            }
            for (int i = 0; i < rows * columns; i++) {
                if (i % columns != 0) {
                    connectNodes(getNode(nodes, i), getNode(nodes, i - 1), 'w');
                }
                if (i % columns != columns - 1) {
                    connectNodes(getNode(nodes, i), getNode(nodes, i + 1), 'e');
                }
                connectNodes(getNode(nodes, i), getNode(nodes, i + columns), 's');
                connectNodes(getNode(nodes, i), getNode(nodes, i - columns), 'n');
            }

            boolean shouldStop = false;
            long totalSum = 0;
            int currentRound = 1;
            while (!shouldStop) {
                shouldStop = true;
                for (Node node : nodes) {
                    if (node.eliminatedRound != -1) {
                        continue;
                    }
                    totalSum += node.value;
                    double average = node.calculateAverage();
                    if (average > node.value) {
                        node.eliminatedRound = currentRound;
                        shouldStop = false;
                    }
                }
                for (Node node : nodes) {
                    if (node.eliminatedRound == currentRound) {
                        removeNode(node);
                    }
                }
                currentRound++;
            }

            System.out.println("Case #" + testCase + ": " + totalSum);
        }
    }

    private static void removeNode(Node node) {
        if (node.south != null) {
            node.south.north = node.north;
        }
        if (node.north != null) {
            node.north.south = node.south;
        }
        if (node.east != null) {
            node.east.west = node.west;
        }
        if (node.west != null) {
            node.west.east = node.east;
        }
    }

    private static void connectNodes(Node node, Node secondNode, char direction) {
        if (secondNode == null) return;
        switch (direction) {
            case 'w':
                node.west = secondNode;
                secondNode.east = node;
                break;
            case 'e':
                node.east = secondNode;
                secondNode.west = node;
                break;
            case 'n':
                node.north = secondNode;
                secondNode.south = node;
                break;
            case 's':
                node.south = secondNode;
                secondNode.north = node;
                break;
        }
    }

    private static Node getNode(List<Node> nodes, int index) {
        if (index >= 0 && index < nodes.size()) {
            return nodes.get(index);
        }
        return null;
    }
}