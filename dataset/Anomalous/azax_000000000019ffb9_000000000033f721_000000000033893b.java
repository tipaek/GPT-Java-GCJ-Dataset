import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            String[] kq = scanner.nextLine().split(" ");
            int k = Integer.parseInt(kq[0]);
            int q = Integer.parseInt(kq[1]);

            String program = scanner.nextLine();
            String[] leftWeights = scanner.nextLine().split(" ");
            String[] rightWeights = scanner.nextLine().split(" ");
            String[] edgeWeights = scanner.nextLine().split(" ");

            int[][] adjacencyMatrix = new int[k][4];
            for (int i = 0; i < k; i++) {
                adjacencyMatrix[i][0] = Integer.parseInt(leftWeights[i]);
                adjacencyMatrix[i][1] = Integer.parseInt(rightWeights[i]);
            }
            populateAdjacencyMatrix(adjacencyMatrix, program, edgeWeights);

            String[] startPositions = scanner.nextLine().split(" ");
            String[] endPositions = scanner.nextLine().split(" ");
            int[] startIndices = new int[q];
            int[] endIndices = new int[q];
            for (int i = 0; i < q; i++) {
                startIndices[i] = Integer.parseInt(startPositions[i]) - 1;
                endIndices[i] = Integer.parseInt(endPositions[i]) - 1;
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + findShortestPaths(adjacencyMatrix, startIndices, endIndices, k));
        }
        scanner.close();
    }

    private static long findShortestPaths(int[][] matrix, int[] startIndices, int[] endIndices, int k) {
        long totalDistance = 0;

        Map<Integer, Set<Integer>> queryMap = new HashMap<>();
        for (int i = 0; i < startIndices.length; i++) {
            queryMap.computeIfAbsent(startIndices[i], key -> new HashSet<>()).add(endIndices[i]);
        }

        for (Integer source : queryMap.keySet()) {
            Set<Integer> targets = queryMap.get(source);
            int targetsReached = 0;

            Set<Integer> finalized = new HashSet<>();
            int[] distances = new int[k];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[source] = 0;

            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(new Node(source, 0));

            while (!priorityQueue.isEmpty()) {
                Node currentNode = priorityQueue.poll();
                finalized.add(currentNode.value);
                distances[currentNode.value] = currentNode.weight;

                if (targets.contains(currentNode.value)) {
                    totalDistance += currentNode.weight;
                    targetsReached++;
                    if (targetsReached == targets.size()) {
                        break;
                    }
                }

                for (int i = 0; i < 3; i++) {
                    int neighbor, cost;
                    if (i == 0) {
                        if (currentNode.value == 0) continue;
                        neighbor = currentNode.value - 1;
                        cost = matrix[currentNode.value][0];
                    } else if (i == 1) {
                        if (currentNode.value == k - 1) continue;
                        neighbor = currentNode.value + 1;
                        cost = matrix[currentNode.value][1];
                    } else {
                        neighbor = matrix[currentNode.value][3];
                        cost = matrix[currentNode.value][2];
                    }

                    if (!finalized.contains(neighbor)) {
                        int newWeight = distances[currentNode.value] + cost;
                        if (distances[neighbor] > newWeight) {
                            distances[neighbor] = newWeight;
                            priorityQueue.add(new Node(neighbor, newWeight));
                        }
                    }
                }
            }
        }

        return totalDistance;
    }

    private static void populateAdjacencyMatrix(int[][] adjacencyMatrix, String program, String[] edgeWeights) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < program.length(); i++) {
            if (program.charAt(i) == '(') {
                stack.push(i);
            } else {
                int start = stack.pop();
                adjacencyMatrix[start][2] = Integer.parseInt(edgeWeights[start]);
                adjacencyMatrix[start][3] = i;

                adjacencyMatrix[i][2] = Integer.parseInt(edgeWeights[i]);
                adjacencyMatrix[i][3] = start;
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int value;
        int weight;

        Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}