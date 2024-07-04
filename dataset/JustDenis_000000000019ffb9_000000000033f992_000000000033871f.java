import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            solve(scanner, i);
        }
    }

    private static void solve(Scanner scanner, int testNum) {
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int riched = 1;
        List<List<Integer>> neg = new ArrayList<>();
        for (int i = 0; i <= C; i++) {
            neg.add(new ArrayList<>());
        }
        Map<Integer, GraphNode> gm = new HashMap<>();
        gm.put(1, new GraphNode(1, 0, 0));
        for (int i = 2; i <= C; i++) {
            int x = scanner.nextInt();

            Integer delay = null;
            if (x < 0) {
                neg.get(-x).add(i);
            } else {
                delay = x;
            }
            gm.put(i, new GraphNode(i, x, delay));
        }

        List<Pair<Integer, Integer>> DL = new ArrayList<>();
        for (int i = 0; i < D; i++) {
            int li = scanner.nextInt();
            int ri = scanner.nextInt();

            gm.get(li).con.add(ri);
            gm.get(ri).con.add(li);
            DL.add(new Pair<>(li, ri));
        }

//        Queue<Integer> queue = new ArrayDeque<>();

//        queue.add(1);

        for (int i = 0; i < neg.size(); i++) {
            List<Integer> list = neg.get(i);
            int maxDel = 0;
            for (int iGN : list) {
                maxDel = Math.max(maxDel, findDelNeg(iGN,gm.get(iGN).x, gm));
            }
            for (int iGN : list) {
                gm.get(iGN).delay = maxDel;
            }
        }

//        while (!queue.isEmpty()) {
//            int curIndex = queue.poll();
//
//        }

        System.out.print("Case #" + (testNum + 1) +  ": ");
        for (Pair<Integer, Integer> p : DL) {
            int abs = Math.abs(gm.get(p.getValue()).delay - gm.get(p.getKey()).delay);
            System.out.print("" + (abs != 0 ? abs : 99999) + " ");
        }
        System.out.println("");
    }

    private static int findDelNeg(int iGN, int curX, Map<Integer, GraphNode> gm) {
        GraphNode node = gm.get(iGN);
        int minDel = Integer.MAX_VALUE;
        for (int con : node.con) {
            GraphNode conNode = gm.get(con);
            if (curX > 0 || (conNode.x <= 0 && curX + 1 != conNode.x)) {
                continue;
            }
            if (conNode.x == curX + 1) {
                return conNode.delay + 1;
            }
            minDel = conNode.delay + 1;
        }
        return minDel;
    }

    static class GraphNode {
        int i;
        int x;
        Integer delay;
        List<Integer> con = new ArrayList<>();

        public GraphNode(int i, int x, Integer delay) {
            this.i = i;
            this.x = x;
            this.delay = delay;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GraphNode graph = (GraphNode) o;
            return i == graph.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i);
        }
    }
}