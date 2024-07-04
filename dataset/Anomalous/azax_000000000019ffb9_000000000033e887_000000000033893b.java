import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(sc.nextLine());
        for (int index = 0; index < numCases; index++) {
            String[] kq = sc.nextLine().split(" ");
            int k = Integer.parseInt(kq[0]);
            int q = Integer.parseInt(kq[1]);

            String program = sc.nextLine();
            String[] lefts = sc.nextLine().split(" ");
            String[] rights = sc.nextLine().split(" ");
            String[] edges = sc.nextLine().split(" ");

            int[] adjacency = new int[k];
            fillAdjacencyMatrix(adjacency, program);

            String[] essJays = sc.nextLine().split(" ");
            String[] eeJays = sc.nextLine().split(" ");
            int[] sjs = new int[q];
            int[] ejs = new int[q];
            for (int i = 0; i < q; i++) {
                sjs[i] = Integer.parseInt(essJays[i]) - 1;
                ejs[i] = Integer.parseInt(eeJays[i]) - 1;
            }

            System.out.println("Case #" + (index + 1) + ": " + solve(adjacency, sjs, ejs, k));
        }
        sc.close();
    }

    private static long solve(int[] mat, int[] sjs, int[] ejs, int k) {
        long sum = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < sjs.length; i++) {
            map.computeIfAbsent(sjs[i], key -> new HashSet<>()).add(ejs[i]);
        }

        for (Integer source : map.keySet()) {
            Set<Integer> targets = map.get(source);
            int targetsHit = 0;

            Set<Integer> finalized = new HashSet<>();
            int[] distances = new int[k];
            Arrays.fill(distances, -1);
            distances[source] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(source, 0));

            while (!pq.isEmpty() && targetsHit < targets.size()) {
                Node currentNode = pq.poll();
                if (finalized.contains(currentNode.value)) continue;
                finalized.add(currentNode.value);

                if (targets.contains(currentNode.value)) {
                    sum += currentNode.weight;
                    targetsHit++;
                }

                int[] neighbors = {currentNode.value - 1, currentNode.value + 1, mat[currentNode.value]};
                for (int neighbor : neighbors) {
                    if (neighbor >= 0 && neighbor < k && !finalized.contains(neighbor)) {
                        int newDist = currentNode.weight + 1;
                        if (distances[neighbor] == -1 || newDist < distances[neighbor]) {
                            distances[neighbor] = newDist;
                            pq.add(new Node(neighbor, newDist));
                        }
                    }
                }
            }
        }

        return sum;
    }

    private static void fillAdjacencyMatrix(int[] adjacency, String program) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < program.length(); i++) {
            if (program.charAt(i) == '(') {
                stack.push(i);
            } else {
                int openIndex = stack.pop();
                adjacency[openIndex] = i;
                adjacency[i] = openIndex;
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