import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int k = scanner.nextInt();
            int q = scanner.nextInt();
            String parentheses = scanner.next();
            int[] leftLatencies = new int[k];
            int[] rightLatencies = new int[k];
            int[] portLatencies = new int[k];

            for (int i = 0; i < k; i++) {
                leftLatencies[i] = scanner.nextInt();
            }
            for (int i = 0; i < k; i++) {
                rightLatencies[i] = scanner.nextInt();
            }
            for (int i = 0; i < k; i++) {
                portLatencies[i] = scanner.nextInt();
            }

            int[] startPoints = new int[q];
            int[] endPoints = new int[q];
            for (int i = 0; i < q; i++) {
                startPoints[i] = scanner.nextInt();
            }
            for (int i = 0; i < q; i++) {
                endPoints[i] = scanner.nextInt();
            }

            Deque<Integer> stack = new ArrayDeque<>();
            char[] parenthesisArray = parentheses.toCharArray();
            int[] portMatches = new int[k];
            for (int i = 0; i < k; i++) {
                if (parenthesisArray[i] == '(') {
                    stack.addFirst(i);
                } else {
                    int matchedIndex = stack.removeFirst();
                    portMatches[matchedIndex] = i;
                    portMatches[i] = matchedIndex;
                }
            }

            long totalLatency = 0;
            for (int i = 0; i < q; i++) {
                long minLatency = Long.MAX_VALUE;
                long[] startLatencies = new long[k];
                long[] endLatencies = new long[k];
                Arrays.fill(startLatencies, Long.MAX_VALUE);
                Arrays.fill(endLatencies, Long.MAX_VALUE);

                PriorityQueue<BfsNode> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(node -> node.latency));
                int start = startPoints[i] - 1;
                int end = endPoints[i] - 1;

                if (start == end) continue;

                startLatencies[start] = 0;
                endLatencies[end] = 0;
                priorityQueue.add(new BfsNode(start, 0, true));
                priorityQueue.add(new BfsNode(end, 0, false));

                while (!priorityQueue.isEmpty()) {
                    BfsNode currentNode = priorityQueue.poll();

                    if (currentNode.fromStart) {
                        if (currentNode.position == end) {
                            totalLatency += currentNode.latency;
                            break;
                        }
                        if (endLatencies[currentNode.position] != Long.MAX_VALUE) {
                            totalLatency += (startLatencies[currentNode.position] + endLatencies[currentNode.position]);
                            break;
                        }
                        if (currentNode.position > 0 && startLatencies[currentNode.position - 1] > currentNode.latency + leftLatencies[currentNode.position]) {
                            startLatencies[currentNode.position - 1] = currentNode.latency + leftLatencies[currentNode.position];
                            priorityQueue.add(new BfsNode(currentNode.position - 1, currentNode.latency + leftLatencies[currentNode.position], true));
                        }
                        if (currentNode.position < k - 1 && startLatencies[currentNode.position + 1] > currentNode.latency + rightLatencies[currentNode.position]) {
                            startLatencies[currentNode.position + 1] = currentNode.latency + rightLatencies[currentNode.position];
                            priorityQueue.add(new BfsNode(currentNode.position + 1, currentNode.latency + rightLatencies[currentNode.position], true));
                        }
                        if (startLatencies[portMatches[currentNode.position]] > currentNode.latency + portLatencies[currentNode.position]) {
                            startLatencies[portMatches[currentNode.position]] = currentNode.latency + portLatencies[currentNode.position];
                            priorityQueue.add(new BfsNode(portMatches[currentNode.position], currentNode.latency + portLatencies[currentNode.position], true));
                        }
                    } else {
                        if (currentNode.position == start) {
                            totalLatency += currentNode.latency;
                            break;
                        }
                        if (startLatencies[currentNode.position] != Long.MAX_VALUE) {
                            totalLatency += (startLatencies[currentNode.position] + endLatencies[currentNode.position]);
                            break;
                        }
                        if (currentNode.position > 0 && endLatencies[currentNode.position - 1] > currentNode.latency + rightLatencies[currentNode.position - 1]) {
                            endLatencies[currentNode.position - 1] = currentNode.latency + rightLatencies[currentNode.position - 1];
                            priorityQueue.add(new BfsNode(currentNode.position - 1, currentNode.latency + rightLatencies[currentNode.position - 1], false));
                        }
                        if (currentNode.position < k - 1 && endLatencies[currentNode.position + 1] > currentNode.latency + leftLatencies[currentNode.position + 1]) {
                            endLatencies[currentNode.position + 1] = currentNode.latency + leftLatencies[currentNode.position + 1];
                            priorityQueue.add(new BfsNode(currentNode.position + 1, currentNode.latency + leftLatencies[currentNode.position + 1], false));
                        }
                        if (endLatencies[portMatches[currentNode.position]] > currentNode.latency + portLatencies[portMatches[currentNode.position]]) {
                            endLatencies[portMatches[currentNode.position]] = currentNode.latency + portLatencies[portMatches[currentNode.position]];
                            priorityQueue.add(new BfsNode(portMatches[currentNode.position], currentNode.latency + portLatencies[portMatches[currentNode.position]], false));
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + totalLatency);
        }
    }

    private static class BfsNode {
        int position;
        long latency;
        boolean fromStart;

        BfsNode(int position, long latency, boolean fromStart) {
            this.position = position;
            this.latency = latency;
            this.fromStart = fromStart;
        }
    }
}