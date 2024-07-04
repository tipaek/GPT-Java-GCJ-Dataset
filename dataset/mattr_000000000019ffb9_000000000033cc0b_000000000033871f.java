import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static class Node {
        List<Node> neighbours = new ArrayList<>();
        int name;
        int latency;
        boolean reached = false;

        Node(int name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner sc) throws Exception {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) throws Exception {
        String[] in = sc.nextLine().split(" ");
        int c = Integer.parseInt(in[0]);
        int d = Integer.parseInt(in[1]);

        int[] info = new int[c + 1];
        HashMap<String, Integer> connections = new HashMap<>();
        String[] connectOrder = new String[d];
        Node[] nodes = new Node[c + 1];

        Node startNode = new Node(1);
        startNode.latency = 0;
        startNode.reached = true;
        nodes[1] = startNode;

        String[] inputs = sc.nextLine().split(" ");

        for (int i = 2; i <= c; i++) {
            info[i] = - Integer.parseInt(inputs[i - 2]);
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < d; i++) {
            String con = sc.nextLine();
            connections.put(con, 100000);
            connectOrder[i] = con;

            String[] conArr = con.split(" ");
            int a = Integer.parseInt(conArr[0]);
            int b = Integer.parseInt(conArr[1]);

            nodes[a].neighbours.add(nodes[b]);
            nodes[b].neighbours.add(nodes[a]);
        }
        // -------


        LinkedList<Node> toProcess = new LinkedList<>();

        while (toProcess.size() < c - 1) {
            int nbNodeReached = toProcess.size() + 1;

            for (int i = 2; i <= c; i++) {
                if (info[i] == nbNodeReached) {
                    nodes[i].latency = nbNodeReached;
                    toProcess.addLast(nodes[i]);
                }
            }
        }

        while (!toProcess.isEmpty()) {
            Node curr = toProcess.pollFirst();

            for (Node neigh : curr.neighbours) {
                if (neigh.reached) {
                    int linkWeight = curr.latency - neigh.latency;

                    if (linkWeight > 0) {

                        int start = Math.min(curr.name, neigh.name);
                        int end = Math.max(curr.name, neigh.name);

                        connections.put(start + " " + end, linkWeight);
                        curr.reached = true;
                    }
                }
            }
        }




        // -------
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < d - 1; i++) {
            res.append(connections.get(connectOrder[i]));
            res.append(" ");
        }
        res.append(connections.get(connectOrder[d - 1]));

        printRes(caseNumber, res.toString());
    }

    private static void printRes(int caseNumber, String res) {
        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + res);
    }
}
