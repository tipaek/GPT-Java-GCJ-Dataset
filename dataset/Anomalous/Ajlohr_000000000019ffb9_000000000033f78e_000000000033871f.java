import java.util.*;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int cc = 1; cc <= t; ++cc) {
            int C = in.nextInt();
            int D = in.nextInt();
            TreeMap<Integer, HashSet<Integer>> orderNode = new TreeMap<>();
            
            for (int i = 1; i < C; i++) {
                int orderVal = -in.nextInt();
                orderNode.computeIfAbsent(orderVal, k -> new HashSet<>()).add(i);
            }
            
            HashMap<IntPair, Integer> linkName = new HashMap<>();
            HashMap<Integer, TreeSet<Integer>> connectionsForNode = new HashMap<>();
            HashMap<Integer, Integer> linkValue = new HashMap<>();
            
            for (int j = 0; j < D; j++) {
                int n1 = in.nextInt() - 1;
                int n2 = in.nextInt() - 1;
                linkName.put(new IntPair(n1, n2), j);
                linkName.put(new IntPair(n2, n1), j);
                addLink(connectionsForNode, n1, n2);
            }
            
            TreeSet<Integer> updatedNode = new TreeSet<>();
            updatedNode.add(0);
            HashMap<Integer, Integer> nodeTriggerTime = new HashMap<>();
            nodeTriggerTime.put(0, 0);
            int longestTriggerTime = 0;
            
            for (Map.Entry<Integer, HashSet<Integer>> pair : orderNode.entrySet()) {
                HashSet<Integer> nodesToAdd = pair.getValue();
                int timeToTarget = 0;
                Map<Integer, Integer> upstreamNodeFor = new HashMap<>();
                
                for (Integer nodeToAdd : nodesToAdd) {
                    HashSet<Integer> triggeredReachableNodes = new HashSet<>(updatedNode);
                    triggeredReachableNodes.retainAll(connectionsForNode.get(nodeToAdd));
                    Integer upstreamNode = triggeredReachableNodes.iterator().next();
                    upstreamNodeFor.put(nodeToAdd, upstreamNode);
                    
                    int timeUpstream = nodeTriggerTime.get(upstreamNode);
                    int candidateTime = Math.max(longestTriggerTime + 1, timeUpstream + 1);
                    timeToTarget = Math.max(timeToTarget, candidateTime);
                }
                
                if (timeToTarget == 0) {
                    throw new IllegalStateException();
                }
                
                for (Integer nodeToAdd : nodesToAdd) {
                    int nodeFrom = upstreamNodeFor.get(nodeToAdd);
                    int timeUpstream = nodeTriggerTime.get(nodeFrom);
                    linkValue.put(linkName.get(new IntPair(nodeToAdd, nodeFrom)), timeToTarget - timeUpstream);
                    nodeTriggerTime.put(nodeToAdd, timeToTarget);
                    updatedNode.add(nodeToAdd);
                }
                
                longestTriggerTime = timeToTarget;
            }
            
            System.out.print("Case #" + cc + ":");
            for (int i = 0; i < D; i++) {
                int valToPrint = linkValue.getOrDefault(i, longestTriggerTime + 1);
                System.out.print(" " + valToPrint);
            }
            System.out.println();
        }
    }

    public static void addLink(HashMap<Integer, TreeSet<Integer>> connectionsForNode, int n1, int n2) {
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
            if (o instanceof IntPair) {
                IntPair p = (IntPair) o;
                return p.a == a && p.b == b;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(a) * 31 + Integer.hashCode(b);
        }
    }
}