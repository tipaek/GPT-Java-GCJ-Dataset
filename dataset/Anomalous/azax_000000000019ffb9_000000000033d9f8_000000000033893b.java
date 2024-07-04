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

            int[][] adjacency = new int[k][4];
            for (int i = 0; i < k; i++) {
                adjacency[i][0] = Integer.parseInt(lefts[i]);
                adjacency[i][1] = Integer.parseInt(rights[i]);
            }
            fillAdjacencyMatrix(adjacency, program, edges);

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

    private static long solve(int[][] mat, int[] sjs, int[] ejs, int k) {
        long sum = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < sjs.length; i++) {
            map.computeIfAbsent(sjs[i], x -> new HashSet<>()).add(ejs[i]);
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

            while (true) {
                Node n = pq.poll();
                if (n == null) break;
                finalized.add(n.value);
                distances[n.value] = n.weight;

                if (targets.contains(n.value)) {
                    sum += n.weight;
                    targetsHit++;
                    if (targetsHit == targets.size()) break;
                }

                for (int i = 0; i < 3; i++) {
                    int neighbor, cost;
                    if (i == 0) {
                        if (n.value == 0) continue;
                        neighbor = n.value - 1;
                        cost = mat[n.value][0];
                    } else if (i == 1) {
                        if (n.value == k - 1) continue;
                        neighbor = n.value + 1;
                        cost = mat[n.value][1];
                    } else {
                        neighbor = mat[n.value][3];
                        cost = mat[n.value][2];
                    }

                    if (!finalized.contains(neighbor)) {
                        int weight = distances[n.value] + cost;
                        if (distances[neighbor] == -1 || distances[neighbor] > weight) {
                            distances[neighbor] = weight;
                            pq.add(new Node(neighbor, weight));
                        }
                    }
                }
            }
        }

        return sum;
    }

    private static void fillAdjacencyMatrix(int[][] adjacency, String program, String[] edges) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < program.length(); i++) {
            if (program.charAt(i) == '(') {
                stack.push(i);
            } else {
                int before = stack.pop();
                adjacency[before][2] = Integer.parseInt(edges[before]);
                adjacency[before][3] = i;

                adjacency[i][2] = Integer.parseInt(edges[i]);
                adjacency[i][3] = before;
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
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}