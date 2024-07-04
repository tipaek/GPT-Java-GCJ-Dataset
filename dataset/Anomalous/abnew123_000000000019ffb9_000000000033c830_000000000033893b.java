import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int k = scanner.nextInt();
            int q = scanner.nextInt();
            int[] inputs = new int[q];
            int[] outputs = new int[q];
            String parenthesesString = scanner.next();
            char[] parentheses = parenthesesString.toCharArray();
            int total = 0;
            
            List<List<Integer>> adjacencyList = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                List<Integer> neighbors = new ArrayList<>();
                if (i > 0) neighbors.add(i - 1);
                if (i < k - 1) neighbors.add(i + 1);
                adjacencyList.add(neighbors);
            }
            
            for (int i = 0; i < k; i++) scanner.nextInt();
            for (int i = 0; i < k; i++) scanner.nextInt();
            for (int i = 0; i < k; i++) scanner.nextInt();
            for (int i = 0; i < q; i++) inputs[i] = scanner.nextInt() - 1;
            for (int i = 0; i < q; i++) outputs[i] = scanner.nextInt() - 1;
            
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < parentheses.length; i++) {
                if (parentheses[i] == '(') {
                    stack.push(i);
                } else {
                    int matchingIndex = stack.pop();
                    adjacencyList.get(i).add(matchingIndex);
                    adjacencyList.get(matchingIndex).add(i);
                }
            }
            
            for (int i = 0; i < q; i++) {
                total += findShortestPath(inputs[i], outputs[i], adjacencyList, k);
            }
            
            System.out.println("Case #" + caseNum + ": " + total);
        }
    }

    private static int findShortestPath(int src, int dest, List<List<Integer>> adjacencyList, int vertices) {
        int[] predecessors = new int[vertices];
        int[] distances = new int[vertices];
        bfs(adjacencyList, src, dest, vertices, predecessors, distances);
        
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while (predecessors[crawl] != -1) {
            path.add(predecessors[crawl]);
            crawl = predecessors[crawl];
        }
        
        return distances[dest];
    }

    private static void bfs(List<List<Integer>> adjacencyList, int src, int dest, int vertices, int[] predecessors, int[] distances) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);
        
        visited[src] = true;
        distances[src] = 0;
        queue.add(src);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distances[neighbor] = distances[currentNode] + 1;
                    predecessors[neighbor] = currentNode;
                    queue.add(neighbor);
                    
                    if (neighbor == dest) return;
                }
            }
        }
    }
}