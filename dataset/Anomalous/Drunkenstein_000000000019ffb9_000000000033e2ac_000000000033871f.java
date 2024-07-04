import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            PrintWriter out = new PrintWriter(System.out);
            InputReader in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (int test = 1; test <= tests; test++) {
                out.print("Case #" + test + ": ");
                solve(in, out);
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void solve(InputReader in, PrintWriter out) throws Exception {
        int n = in.nextInt();
        long m = in.nextInt();

        int[] distances = new int[n];
        List<Node> knownNodes = new ArrayList<>();
        List<Node> unknownNodes = new ArrayList<>();
        List<Node> allNodes = new ArrayList<>();
        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 1; i < n; i++) {
            distances[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            if (distances[i] >= 0) {
                node.distance = distances[i];
                knownNodes.add(node);
            } else {
                node.order = -distances[i];
                unknownNodes.add(node);
            }
            allNodes.add(node);
            nodeMap.put(i, node);
        }

        knownNodes.sort(Comparator.comparingInt(o -> o.num));
        unknownNodes.sort(Comparator.comparingInt(o -> o.order));

        int currentOrder = 0;
        int knownPointer = 0;
        int unknownPointer = 0;

        while (unknownPointer < unknownNodes.size()) {
            if (unknownNodes.get(unknownPointer).order > currentOrder) {
                knownNodes.get(knownPointer).order = currentOrder;
                knownPointer++;
            } else {
                unknownPointer++;
            }
            currentOrder++;
        }

        for (int i = knownPointer; i < knownNodes.size(); i++) {
            knownNodes.get(i).order = currentOrder++;
        }

        allNodes.sort(Comparator.comparingInt(o -> o.order));

        for (int i = 0; i < allNodes.size(); i++) {
            if (allNodes.get(i).distance == Integer.MAX_VALUE) {
                if (i > 0 && allNodes.get(i).order == allNodes.get(i - 1).order) {
                    allNodes.get(i).distance = allNodes.get(i - 1).distance;
                } else {
                    allNodes.get(i).distance = allNodes.get(i - 1).distance + 1;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int k = in.nextInt() - 1;
            int l = in.nextInt() - 1;
            int distance = Math.abs(nodeMap.get(k).distance - nodeMap.get(l).distance);
            if (distance == 0) distance = 1000;
            result.append(distance).append(" ");
        }

        out.println(result);
    }

    static class Node {
        int num;
        int order = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;

        Node(int num) {
            this.num = num;
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return "";
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}