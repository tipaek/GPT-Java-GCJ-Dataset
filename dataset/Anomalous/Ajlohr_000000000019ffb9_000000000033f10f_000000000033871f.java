import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int nodesCount = scanner.nextInt();
            int edgesCount = scanner.nextInt();
            TreeMap<Integer, HashSet<Integer>> orderNodeMap = new TreeMap<>();
            
            for (int i = 1; i < nodesCount; i++) {
                int orderValue = -scanner.nextInt();
                orderNodeMap.computeIfAbsent(orderValue, k -> new HashSet<>()).add(i);
            }
            
            HashMap<IntPair, Integer> linkNameMap = new HashMap<>();
            HashMap<Integer, TreeSet<Integer>> connectionsMap = new HashMap<>();
            HashMap<Integer, Integer> linkValueMap = new HashMap<>();
            
            for (int j = 0; j < edgesCount; j++) {
                int node1 = scanner.nextInt() - 1;
                int node2 = scanner.nextInt() - 1;
                linkNameMap.put(new IntPair(node1, node2), j);
                linkNameMap.put(new IntPair(node2, node1), j);
                addLink(connectionsMap, node1, node2);
            }
            
            TreeSet<Integer> updatedNodes = new TreeSet<>();
            updatedNodes.add(0);
            HashMap<Integer, Integer> nodeTriggerTimeMap = new HashMap<>();
            nodeTriggerTimeMap.put(0, 0);
            int longestTriggerTime = 0;
            
            for (Map.Entry<Integer, HashSet<Integer>> entry : orderNodeMap.entrySet()) {
                HashSet<Integer> nodesToAdd = entry.getValue();
                int timeToTarget = 0;
                
                for (Integer nodeToAdd : nodesToAdd) {
                    HashSet<Integer> reachableNodes = new HashSet<>(updatedNodes);
                    reachableNodes.retainAll(connectionsMap.get(nodeToAdd));
                    int upstreamTime = nodeTriggerTimeMap.get(reachableNodes.iterator().next());
                    int candidateTime = Math.max(longestTriggerTime + 1, upstreamTime + 1);
                    timeToTarget = Math.max(timeToTarget, candidateTime);
                }
                
                if (timeToTarget == 0) {
                    throw new IllegalStateException();
                }
                
                for (Integer nodeToAdd : nodesToAdd) {
                    HashSet<Integer> reachableNodes = new HashSet<>(updatedNodes);
                    reachableNodes.retainAll(connectionsMap.get(nodeToAdd));
                    int fromNode = reachableNodes.iterator().next();
                    int upstreamTime = nodeTriggerTimeMap.get(fromNode);
                    linkValueMap.put(linkNameMap.get(new IntPair(nodeToAdd, fromNode)), timeToTarget - upstreamTime);
                    nodeTriggerTimeMap.put(nodeToAdd, timeToTarget);
                    updatedNodes.add(nodeToAdd);
                }
                
                longestTriggerTime = timeToTarget;
            }
            
            System.out.print("Case #" + testCase + ":");
            for (int i = 0; i < edgesCount; i++) {
                int valueToPrint = longestTriggerTime + 1;
                if (linkValueMap.containsKey(i)) {
                    valueToPrint = linkValueMap.get(i);
                }
                System.out.print(" " + valueToPrint);
            }
            System.out.println();
        }
    }

    public static void addLink(HashMap<Integer, TreeSet<Integer>> connectionsMap, int node1, int node2) {
        connectionsMap.computeIfAbsent(node1, k -> new TreeSet<>()).add(node2);
        connectionsMap.computeIfAbsent(node2, k -> new TreeSet<>()).add(node1);
    }

    public static class IntPair {
        public int a;
        public int b;

        public IntPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof IntPair) {
                IntPair pair = (IntPair) o;
                return pair.a == a && pair.b == b;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(a) * 31 + Integer.hashCode(b);
        }
    }
}