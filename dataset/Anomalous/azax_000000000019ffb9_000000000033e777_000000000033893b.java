import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = Integer.parseInt(sc.nextLine());
            for (int index = 0; index < numCases; index++) {
                String[] kq = sc.nextLine().split(" ");
                int k = Integer.parseInt(kq[0]);
                int q = Integer.parseInt(kq[1]);

                String program = sc.nextLine();
                sc.nextLine(); // Read and discard lefts line
                sc.nextLine(); // Read and discard rights line
                sc.nextLine(); // Read and discard edges line

                int[] adjacency = new int[k];
                fillAdjacencyMatrix(adjacency, program);

                String[] sjs = sc.nextLine().split(" ");
                String[] ejs = sc.nextLine().split(" ");
                int[] startPoints = new int[q];
                int[] endPoints = new int[q];
                for (int i = 0; i < q; i++) {
                    startPoints[i] = Integer.parseInt(sjs[i]) - 1;
                    endPoints[i] = Integer.parseInt(ejs[i]) - 1;
                }

                System.out.println("Case #" + (index + 1) + ": " + solve(adjacency, startPoints, endPoints, k));
            }
        }
    }

    private static long solve(int[] adjacency, int[] startPoints, int[] endPoints, int k) {
        long totalDistance = 0;

        Map<Integer, Set<Integer>> queryMap = new HashMap<>();
        for (int i = 0; i < startPoints.length; i++) {
            queryMap.computeIfAbsent(startPoints[i], key -> new HashSet<>()).add(endPoints[i]);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : queryMap.entrySet()) {
            int source = entry.getKey();
            Set<Integer> targets = entry.getValue();

            Set<Integer> visited = new HashSet<>();
            int[] distances = new int[k];
            Arrays.fill(distances, -1);
            distances[source] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(source, 0));

            int targetsHit = 0;

            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
                if (visited.contains(currentNode.value)) continue;

                visited.add(currentNode.value);
                distances[currentNode.value] = currentNode.weight;

                if (targets.contains(currentNode.value)) {
                    totalDistance += currentNode.weight;
                    targetsHit++;
                    if (targetsHit == targets.size()) break;
                }

                for (int i = 0; i < 3; i++) {
                    int neighbor, cost = currentNode.weight + 1;
                    if (i == 0 && currentNode.value > 0) {
                        neighbor = currentNode.value - 1;
                    } else if (i == 1 && currentNode.value < k - 1) {
                        neighbor = currentNode.value + 1;
                    } else if (i == 2) {
                        neighbor = adjacency[currentNode.value];
                    } else {
                        continue;
                    }

                    if (!visited.contains(neighbor) && (distances[neighbor] == -1 || distances[neighbor] > cost)) {
                        distances[neighbor] = cost;
                        pq.add(new Node(neighbor, cost));
                    }
                }
            }
        }
        return totalDistance;
    }

    private static void fillAdjacencyMatrix(int[] adjacency, String program) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < program.length(); i++) {
            if (program.charAt(i) == '(') {
                stack.push(i);
            } else {
                int matchingIndex = stack.pop();
                adjacency[matchingIndex] = i;
                adjacency[i] = matchingIndex;
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