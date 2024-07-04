import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();

        for (int i = 0; i < totalCases; i++) {
            int intervals = scanner.nextInt();
            Node[] nodes = new Node[intervals];
            for (int j = 0; j < intervals; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                nodes[j] = solution.new Node(start, end);
            }

            Arrays.sort(nodes, solution.new NodeComparator());
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(solution.new EndTimeComparator());

            List<String> availableResponses = new ArrayList<>(Arrays.asList("C", "J"));
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (Node node : nodes) {
                while (!priorityQueue.isEmpty() && priorityQueue.peek().end <= node.begin) {
                    Node finishedNode = priorityQueue.poll();
                    availableResponses.add(finishedNode.responsible);
                }

                if (availableResponses.isEmpty()) {
                    possible = false;
                    break;
                }

                String assigned = availableResponses.remove(0);
                schedule.append(assigned);
                node.responsible = assigned;
                priorityQueue.offer(node);
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + schedule);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    class Node {
        int begin;
        int end;
        String responsible;

        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return Integer.compare(n1.begin, n2.begin);
        }
    }

    class EndTimeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return Integer.compare(n1.end, n2.end);
        }
    }
}