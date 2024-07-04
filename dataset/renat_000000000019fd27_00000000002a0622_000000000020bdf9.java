import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int id = 1;
        while (t != 0) {
            int n = sc.nextInt();
            int[] board = new int[24 * 60 + 10];
            boolean impossible = false;
            List<Line> elms = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                elms.add(new Line(a, b, i));
                for (int j = a; j < b; j++) {
                    board[j]++;
                    if (board[j] > 2) {
                        impossible = true;
                    }
                }
            }
            elms.sort(Comparator.comparingInt(v -> v.b));
            int[] mx = new int[n];
            int[] path = new int[n + 1];
            int mx1 = -1;
            int idToTake = 0;
            StringBuilder sb = new StringBuilder();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (elms.get(j).b > elms.get(i).a) {
                        // i -> j
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
                sb.append('C');
            }

            boolean ok = true;
            int[] part = new int[n];
            int[] q = new int[n];
            int itq = 0;
            Arrays.fill(part, -1);
            for (int st = 0; st < n; st++) {
                if (part[st] == -1) {
                    int h = 0, t1 = 0;
                    q[t1++] = st;
                    part[st] = 0;
                    while (h < t1) {
                        int v = q[h++];
                        for (int k = 0; k < graph.get(v).size(); k++) {
                            int to = graph.get(v).get(k);
                            if (part[to] == -1) {
                                part[to] = 1 - part[v];
                                q[t1++] = to;
                            } else {
                                ok &=  part[to] != part[v];
                            }
                        }
                    }
                }
            }

            if (!ok)
                sb = new StringBuilder("IMPOSSIBLE");
            else {
                for (int i = 0; i < n; i++) {
                    if (part[i] == 1) {
                        sb.setCharAt(elms.get(i).id, 'J');
                    }
                }
            }
            System.out.println("Case #" + id + ": " + sb.toString());
            id++;
            t--;
        }
    }

    static class Line {
        int a, b;
        int id;

        public Line(int a, int b, int id) {
            this.a = a;
            this.b = b;
            this.id = id;
        }
    }
}
