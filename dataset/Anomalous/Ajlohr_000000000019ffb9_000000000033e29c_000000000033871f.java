import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int C = scanner.nextInt();
            int D = scanner.nextInt();
            TreeMap<Integer, HashSet<Integer>> orderNode = new TreeMap<>();
            
            for (int i = 1; i < C; i++) {
                int orderValue = -scanner.nextInt();
                orderNode.computeIfAbsent(orderValue, k -> new HashSet<>()).add(i);
            }
            
            Map<IntPair, Integer> linkName = new HashMap<>();
            Map<Integer, TreeSet<Integer>> connectionsForNode = new HashMap<>();
            Map<Integer, Integer> linkValue = new HashMap<>();
            
            for (int j = 0; j < D; j++) {
                int n1 = scanner.nextInt() - 1;
                int n2 = scanner.nextInt() - 1;
                linkName.put(new IntPair(n1, n2), j);
                linkName.put(new IntPair(n2, n1), j);
                addLink(connectionsForNode, n1, n2);
            }
            
            TreeSet<Integer> updatedNode = new TreeSet<>();
            updatedNode.add(0);
            Map<Integer, Integer> nodeTriggerTime = new HashMap<>();
            nodeTriggerTime.put(0, 0);
            int longestTriggerTime = 0;
            
            for (Map.Entry<Integer, HashSet<Integer>> entry : orderNode.entrySet()) {
                HashSet<Integer> nodesToAdd = entry.getValue();
                int timeToTarget = 0;
                
                for (Integer nodeToAdd : nodesToAdd) {
                    HashSet<Integer> triggeredReachableNodes = new HashSet<>(updatedNode);
                    triggeredReachableNodes.retainAll(connectionsForNode.get(nodeToAdd));
                    int timeUpstream = nodeTriggerTime.get(triggeredReachableNodes.iterator().next());
                    int candidateTime = Math.max(longestTriggerTime + 1, timeUpstream + 1);
                    timeToTarget = Math.max(timeToTarget, candidateTime);
                }
                
                for (Integer nodeToAdd : nodesToAdd) {
                    HashSet<Integer> triggeredReachableNodes = new HashSet<>(updatedNode);
                    triggeredReachableNodes.retainAll(connectionsForNode.get(nodeToAdd));
                    int nodeFrom = triggeredReachableNodes.iterator().next();
                    int timeUpstream = nodeTriggerTime.get(nodeFrom);
                    linkValue.put(linkName.get(new IntPair(nodeToAdd, nodeFrom)), timeToTarget - timeUpstream);
                    nodeTriggerTime.put(nodeToAdd, timeToTarget);
                    updatedNode.add(nodeToAdd);
                }
                longestTriggerTime = timeToTarget;
            }
            
            System.out.print("Case #" + caseNum + ":");
            for (int i = 0; i < D; i++) {
                int valToPrint = linkValue.getOrDefault(i, longestTriggerTime + 1);
                System.out.print(" " + valToPrint);
            }
            System.out.println();
        }
    }

    public static void addLink(Map<Integer, TreeSet<Integer>> connectionsForNode, int n1, int n2) {
        connectionsForNode.computeIfAbsent(n1, k -> new TreeSet<>()).add(n2);
        connectionsForNode.computeIfAbsent(n2, k -> new TreeSet<>()).add(n1);
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntPair intPair = (IntPair) o;
            return a == intPair.a && b == intPair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}