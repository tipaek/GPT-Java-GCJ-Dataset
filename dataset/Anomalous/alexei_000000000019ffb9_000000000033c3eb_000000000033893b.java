import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            int k = scanner.nextInt();
            int q = scanner.nextInt();
            String parentheses = scanner.next();
            int[] left = new int[k];
            int[] right = new int[k];
            int[] portal = new int[k];
            
            for (int i = 0; i < k; i++) {
                left[i] = scanner.nextInt();
            }
            for (int i = 0; i < k; i++) {
                right[i] = scanner.nextInt();
            }
            for (int i = 0; i < k; i++) {
                portal[i] = scanner.nextInt();
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
            char[] parArray = parentheses.toCharArray();
            int[] portMapping = new int[k];
            
            for (int i = 0; i < k; i++) {
                if (parArray[i] == '(') {
                    stack.addFirst(i);
                } else {
                    int index = stack.removeFirst();
                    portMapping[index] = i;
                    portMapping[i] = index;
                }
            }
            
            int totalLatency = 0;
            
            for (int i = 0; i < q; i++) {
                boolean[] visited = new boolean[k];
                PriorityQueue<Bfs> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a.latency));
                int start = startPoints[i] - 1;
                int end = endPoints[i] - 1;
                
                if (start == end) continue;
                
                visited[start] = true;
                queue.add(new Bfs(start, 0));
                
                while (!queue.isEmpty()) {
                    Bfs current = queue.poll();
                    
                    if (current.pos == end) {
                        totalLatency += current.latency;
                        break;
                    }
                    
                    if (current.pos > 0 && !visited[current.pos - 1]) {
                        visited[current.pos - 1] = true;
                        queue.add(new Bfs(current.pos - 1, current.latency + left[current.pos]));
                    }
                    
                    if (current.pos < k - 1 && !visited[current.pos + 1]) {
                        visited[current.pos + 1] = true;
                        queue.add(new Bfs(current.pos + 1, current.latency + right[current.pos]));
                    }
                    
                    if (!visited[portMapping[current.pos]]) {
                        visited[portMapping[current.pos]] = true;
                        queue.add(new Bfs(portMapping[current.pos], current.latency + portal[current.pos]));
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + totalLatency);
        }
    }

    private static class Bfs {
        int pos;
        long latency;

        Bfs(int pos, long latency) {
            this.pos = pos;
            this.latency = latency;
        }
    }
}