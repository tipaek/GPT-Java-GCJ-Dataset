import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
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
            
            int[] startPositions = new int[q];
            int[] endPositions = new int[q];
            
            for (int i = 0; i < q; i++) {
                startPositions[i] = scanner.nextInt();
            }
            for (int i = 0; i < q; i++) {
                endPositions[i] = scanner.nextInt();
            }
            
            Deque<Integer> stack = new ArrayDeque<>();
            char[] parenthesesArray = parentheses.toCharArray();
            int[] portMapping = new int[k];
            
            for (int i = 0; i < k; i++) {
                if (parenthesesArray[i] == '(') {
                    stack.addFirst(i);
                } else {
                    int matchingIndex = stack.removeFirst();
                    portMapping[matchingIndex] = i;
                    portMapping[i] = matchingIndex;
                }
            }
            
            int totalLatency = 0;
            
            for (int i = 0; i < q; i++) {
                boolean[] visited = new boolean[k];
                PriorityQueue<BfsNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.latency));
                
                int startIndex = startPositions[i] - 1;
                int endIndex = endPositions[i] - 1;
                
                if (startIndex == endIndex) continue;
                
                visited[startIndex] = true;
                priorityQueue.add(new BfsNode(startIndex, 0));
                
                while (!priorityQueue.isEmpty()) {
                    BfsNode currentNode = priorityQueue.poll();
                    
                    if (currentNode.position == endIndex) {
                        totalLatency += currentNode.latency;
                        break;
                    }
                    
                    if (currentNode.position > 0 && !visited[currentNode.position - 1]) {
                        visited[currentNode.position - 1] = true;
                        priorityQueue.add(new BfsNode(currentNode.position - 1, currentNode.latency + leftLatencies[currentNode.position]));
                    }
                    
                    if (currentNode.position < k - 1 && !visited[currentNode.position + 1]) {
                        visited[currentNode.position + 1] = true;
                        priorityQueue.add(new BfsNode(currentNode.position + 1, currentNode.latency + rightLatencies[currentNode.position]));
                    }
                    
                    if (!visited[portMapping[currentNode.position]]) {
                        visited[portMapping[currentNode.position]] = true;
                        priorityQueue.add(new BfsNode(portMapping[currentNode.position], currentNode.latency + portLatencies[currentNode.position]));
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + totalLatency);
        }
    }

    private static class BfsNode {
        int position;
        int latency;

        BfsNode(int position, int latency) {
            this.position = position;
            this.latency = latency;
        }
    }
}