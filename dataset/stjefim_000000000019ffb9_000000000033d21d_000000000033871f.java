

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int C = in.nextInt();
            int D = in.nextInt();
            int[] data = new int[C + 1];
            int[] paths = new int[C + 1];
            paths[1] = 0;
            for (int c = 2; c <= C; c++) {
                data[c] = in.nextInt();
                paths[c] = -1;
            }
            Edge [][] edges = new Edge[C + 1][C + 1];
            ArrayList<Edge> allEdge = new ArrayList<>();
            for (int d = 0; d < D; d++) {
                int tmp1 = in.nextInt();
                int tmp2 = in.nextInt();
                edges[tmp1][tmp2] = new Edge(tmp1, tmp2, -1);
                edges[tmp2][tmp1] = new Edge(tmp2, tmp1, -1);
                allEdge.add(edges[tmp1][tmp2]);
            }
            int c = 2;
            while (c <= C) {
                int longest = -1;
                for (int i = 1; i <= C; i++) {
                    if (paths[i] > longest) {
                        longest = paths[i];
                    }
                }
                int vertex = -1;
                ArrayList<Integer> found = new ArrayList<>();;
                boolean firstQ = false;
                for (int i = 2; i <= C; i++) {
                    if (data[i] < 0 && data[i] == - (c - 1)) {
                        found.add(i);
                        firstQ = true;
                    }
                }
                int minCost = 1000000;
                if (!firstQ) {
                    for (int i = 2; i <= C; i++) {
                        if (data[i] > 0 && data[i] < minCost) {
                            minCost = data[i];
                            vertex = i;
                        }
                    }
                }
                Edge saved = null;
                if (firstQ) {
                    for (int a : found) {
                        int minPath = 100000000;
                        for (int i = 1; i <= C; i++) {
                            if (edges[a][i] != null) {
                                Edge tmp = edges[a][i];
                                if (paths[tmp.to] != -1) {
                                    if (minPath > paths[tmp.to]) {
                                        minPath = paths[tmp.to];
                                        saved = tmp;
                                    }
                                }
                            }
                        }
                        int delta = longest + 1 - paths[saved.to];
                        paths[a] = paths[saved.to] + delta;
                        edges[saved.to][saved.from].cost = delta;
                        edges[saved.from][saved.to].cost = delta;
                        data[a] = 0;
                    }
                    c += found.size();
                } else {
                    int minPath = 100000000;
                    for (int i = 1; i <= C; i++) {
                        if (edges[vertex][i] != null) {
                            Edge tmp = edges[vertex][i];
                            if (paths[tmp.to] != -1) {
                                if (minPath > paths[tmp.to]) {
                                    minPath = paths[tmp.to];
                                    saved = tmp;
                                }
                            }
                        }
                    }
                    int delta = data[vertex] - paths[saved.to];
                    paths[vertex] = paths[saved.to] + delta;
                    edges[saved.to][saved.from].cost = delta;
                    edges[saved.from][saved.to].cost = delta;
                    c++;
                    data[vertex] = 0;
                }
            }
            out.write(String.format("Case #%d: ", t + 1));
            for (Edge edge : allEdge) {
                if (edge.cost == -1) {
                    out.write(String.format("%d ", 1000000));
                } else {
                    out.write(String.format("%d ", edge.cost));
                }
            }
            out.write("\n");
        }

        out.close();
        in.close();
    }

    public static class Edge {
        public int from;
        public int to;
        public int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

}
