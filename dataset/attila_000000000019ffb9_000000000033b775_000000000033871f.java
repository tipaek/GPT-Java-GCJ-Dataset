//package codejam2020r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Edge {
        int from, to;
        int index;
        int value = 1000000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int ttt = Integer.parseInt(sc.readLine());
        for (int tt = 1; tt <= ttt; tt++) {
            String[] line = sc.readLine().split(" ");
            int c = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
            line = sc.readLine().split(" ");
            int[][] x = new int[line.length][2];
            int[] latency = new int[c + 1];
            latency[0] = -1;
            latency[1] = 0;
            for (int i = 2; i < latency.length; i++) {
                latency[i] = -1;
            }
            Map<Integer, Map<Integer, Edge>> result = new HashMap<>();
            Map<Integer, List<Edge>> graph = new HashMap<>();
            for (int i = 0; i < x.length; i++) {
                x[i][0] = Integer.parseInt(line[i]);
                x[i][1] = i + 2;
            }
            Arrays.sort(x, Comparator.comparingInt(o -> -o[0]));
            for (int i = 1; i <= d; i++) {
                line = sc.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                put(u, v, graph, i, result);
                put(v, u, graph, i, null);
            }

            int i = 0;

            int targetLatency = 0;
            while (i < x.length) {
                targetLatency++;
                int curr = x[i][0];
                List<Integer> allSim = new ArrayList<>();
                allSim.add(x[i][1]);
                while (i + 1 < x.length && x[i + 1][0] == curr) {
                    allSim.add(x[++i][1]);
                }
                i++;

                for (int toSetNow : allSim) {
                    List<Integer> allSetNeighbours = getSetNeighbours(graph, toSetNow, latency);

                    for (int setNegigh : allSetNeighbours) {
                        int nLat = latency[setNegigh];
                        int latDiff = targetLatency - nLat;
                        if (latDiff == 0) latDiff = 1;
                        setEdge(result, toSetNow, setNegigh, latDiff);
                    }
                    latency[toSetNow] = targetLatency;
                }
            }

            int[] resultArray = new int[d + 1];
            for (Map<Integer, Edge> rr : result.values()) {
                for (Edge e : rr.values()) {
                    resultArray[e.index] = e.value;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < resultArray.length; j++) {
                if (j > 1) {
                    sb.append(' ');
                }
                sb.append(resultArray[j]);
            }
            System.out.println("Case #" + tt + ": " + sb.toString());
        }
    }

    private static void setEdge(Map<Integer, Map<Integer, Edge>> result, int a, int b, int lat) {
        result.get(a).get(b).value = lat;
    }


    private static List<Integer> getSetNeighbours(Map<Integer, List<Edge>> graph, int node, int[] latency) {
        List<Integer> nn = new ArrayList<>();
        for (Edge e : graph.get(node)) {
            int i = e.to;
            if (latency[i] != -1) {
                nn.add(i);
            }
        }
        return nn;
    }

    private static void put(int u, int v, Map<Integer, List<Edge>> graph, int index, Map<Integer, Map<Integer, Edge>> result) {
        List<Edge> list = graph.get(u);
        if (list == null) {
            list = new ArrayList<>();
            graph.put(u, list);
        }
        Edge e = new Edge();
        e.from = u;
        e.to = v;
        e.index = index;
        list.add(e);

        if (result != null) {
            Map<Integer, Edge> r1 = result.get(u);
            if (r1 == null) {
                r1 = new HashMap<>();
                result.put(u, r1);
            }
            r1.put(v, e);

            Map<Integer, Edge> r2 = result.get(v);
            if (r2 == null) {
                r2 = new HashMap<>();
                result.put(v, r2);
            }
            r2.put(u, e);
        }
    }
}
