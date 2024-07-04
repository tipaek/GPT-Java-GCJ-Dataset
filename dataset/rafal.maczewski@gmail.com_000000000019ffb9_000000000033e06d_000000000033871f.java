import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }


    static class Node {
        int updateTime;         // when was this updated (0 if unknown)
        int nodesBefore;        // how many nodes before were udated (0 if unknown)
        boolean visited = false;

        List<Integer> connectedNodes = new ArrayList<>();
        List<Integer> connIdxes = new ArrayList<>();
        public void addNode(int v2, int connIdx) {
            connectedNodes.add(v2);
            connIdxes.add(connIdx);
        }
    }

    static class X {
        int n1;
        int n2;
    }


    private static void solve(int caseNr, Scanner in) {
        int c = in.nextInt();
        int d = in.nextInt();

        List<Node> nodes = new ArrayList<>();

        int result[] = new int[d];

        List<Node> nodesWithNodeBefore = new ArrayList<>();
        List<Node> nodesWithFixedTime = new ArrayList<>();

        Node n0 = new Node();
        n0.nodesBefore = 0;
        n0.updateTime = 0;
        nodes.add(n0);
        for (int i = 1; i < c; i++) {
            Node n = new Node();
            int x = in.nextInt();
            if (x < 0) {
                n.nodesBefore = -x;
                nodesWithNodeBefore.add(n);
            } else {
                n.updateTime = x;
                nodesWithFixedTime.add(n);
            }
            nodes.add(n);
        }

        for (int i = 0; i < d; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            nodes.get(v1-1).addNode(v2-1, i);
            nodes.get(v2-1).addNode(v1-1, i);
        }



        nodesWithNodeBefore.sort(Comparator.comparingInt(o -> o.nodesBefore));
        nodesWithFixedTime.sort(Comparator.comparingInt(o -> o.updateTime));

        int n2 = 0;
        int n1 = 0;
        int nodeCount = 1;
        int currentTime = 0;

        while (n1 < nodesWithNodeBefore.size()) {
            Node n = nodesWithNodeBefore.get(n1);

            if (n.nodesBefore == nodeCount) {
                int cnt = 0;
                while (n.nodesBefore == nodeCount && n1 < nodesWithNodeBefore.size()) {
                    n.updateTime = currentTime + 1;
                    n1++;
                    cnt++;
                    if (n1 < nodesWithNodeBefore.size()) {
                        n = nodesWithNodeBefore.get(n1);
                    }
                }
                nodeCount += cnt;
                currentTime++;
            } else {
                if (nodeCount > n.nodesBefore) {
                    throw new RuntimeException("!!!!");
                }
                while (nodeCount < n.nodesBefore) {
                    Node nn = nodesWithFixedTime.get(n2);
                    n2++;
                    int cnt = 1;
                    nn.nodesBefore = nodeCount;
                    currentTime = nn.updateTime;
                    while (n2 < nodesWithFixedTime.size() && nodesWithFixedTime.get(n2).updateTime == nn.updateTime) {
                        cnt++;
                        Node nnn = nodesWithFixedTime.get(n2);
                        nnn.nodesBefore = nodeCount;
                        currentTime = nn.updateTime;
                        n2++;
                    }
                    nodeCount += cnt;
                }
            }
        }

        // all nodes have nodesBefore set

        List<Node> sortedNodes = new ArrayList<>(nodes);
        sortedNodes.sort(Comparator.comparingInt(o -> o.updateTime));

//        currentTime = 0;
//        int nodesBefore = 0;
        for (int i = 0; i < sortedNodes.size(); i++) {
            Node n = sortedNodes.get(i);

            currentTime = n.updateTime;
            n.visited = true;

            List<Integer> connectedNodes = n.connectedNodes;
            List<Integer> connIdxes = n.connIdxes;
            for (int j = 0; j < connectedNodes.size(); j++) {
                Node cc = nodes.get(connectedNodes.get(j));
                if (cc.visited) {
                    int latency = currentTime - cc.updateTime;
                    if (latency <= 0) {
                        latency = 1;
                    }
                    result[connIdxes.get(j)] = latency;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                result[i] = 1;
            }
        }

        System.out.print("Case #" + caseNr + ": ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.flush();

    }

}