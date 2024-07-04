import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int k = in.nextInt();
            int q = in.nextInt();
            String par = in.next();
            int[] l = new int[k];
            int[] r = new int[k];
            int[] p = new int[k];
            for (int j = 0; j < k; j++) {
                l[j] = in.nextInt();
            }
            for (int j = 0; j < k; j++) {
                r[j] = in.nextInt();
            }
            for (int j = 0; j < k; j++) {
                p[j] = in.nextInt();
            }
            int[] s = new int[q];
            int[] e = new int[q];
            for (int j = 0; j < q; j++) {
                s[j] = in.nextInt();
            }
            for (int j = 0; j < q; j++) {
                e[j] = in.nextInt();
            }
            Deque<Integer> stack = new ArrayDeque<Integer>();
            char[] pp = par.toCharArray();
            int[] port = new int[k];
            for (int j = 0; j < k; j++) {
                if (pp[j] == '(') {
                    stack.addFirst(j);
                } else {
                    int index = stack.removeFirst();
                    port[index] = j;
                    port[j] = index;
                }
            }
            int n = 0;

            for (int j = 0; j < q; j++) {
                long minLatency = Long.MAX_VALUE;
                long fromStart[] = new long[k];
                long fromEnd[] = new long[k];
                for (int jj = 0; jj < k; jj++) {
                    fromStart[jj] = Long.MAX_VALUE;
                    fromEnd[jj] = Long.MAX_VALUE;
                }

                PriorityQueue<Bfs> queue = new PriorityQueue<Bfs>(new Comparator<Bfs> () {
                    public int compare(Bfs a, Bfs b) {
                        if (a.latency == b.latency) return 0;
                        if (a.latency < b.latency) return -1;
                        return 1;
                    }
                });
                int start = s[j] - 1;
                int end = e[j] - 1;
                if (start == end) continue;
                fromStart[start] = 0;
                fromEnd[end] = 0;
                queue.add(new Bfs(start, 0, true));
                queue.add(new Bfs(end, 0, false));
                while (queue.size() != 0)
                {
                    Bfs curr = queue.poll();
                    if (curr.fromStart) {
                        if (curr.pos == end) {
                            n += curr.latency;
                            break;
                        }
                        if (fromEnd[curr.pos] != Long.MAX_VALUE) {
                            n += (fromStart[curr.pos] + fromEnd[curr.pos]);
                            break;
                        }
                        if (curr.pos != 0 && fromStart[curr.pos - 1] > curr.latency + l[curr.pos]) {
                            fromStart[curr.pos - 1] = curr.latency + l[curr.pos];
                            Bfs bfs = new Bfs(curr.pos - 1, curr.latency + l[curr.pos], true);
                            queue.add(bfs);
                        }
                        if (curr.pos != k - 1 && fromStart[curr.pos + 1] > curr.latency + r[curr.pos]) {
                            fromStart[curr.pos + 1] = curr.latency + r[curr.pos];
                            Bfs bfs = new Bfs(curr.pos + 1, curr.latency + r[curr.pos], true);
                            queue.add(bfs);
                        }
                        if (fromStart[port[curr.pos]] > curr.latency + p[curr.pos]) {
                            fromStart[port[curr.pos]] = curr.latency + p[curr.pos];
                            Bfs bfs = new Bfs(port[curr.pos], curr.latency + p[curr.pos], true);
                            queue.add(bfs);
                        }
                    } else {
                        if (curr.pos == start) {
                            n += curr.latency;
                            break;
                        }
                        if (fromStart[curr.pos] != Long.MAX_VALUE) {
                            n += (fromStart[curr.pos] + fromEnd[curr.pos]);
                            break;
                        }
                        if (curr.pos != 0 && fromEnd[curr.pos - 1] > curr.latency + r[curr.pos-1]) {
                            fromEnd[curr.pos - 1] = curr.latency + r[curr.pos-1];
                            Bfs bfs = new Bfs(curr.pos - 1, curr.latency + r[curr.pos-1], false);
                            queue.add(bfs);
                        }
                        if (curr.pos != k - 1 && fromEnd[curr.pos + 1] > curr.latency + l[curr.pos+1]) {
                            fromEnd[curr.pos + 1] = curr.latency + l[curr.pos+1];
                            Bfs bfs = new Bfs(curr.pos + 1, curr.latency + l[curr.pos+1], false);
                            queue.add(bfs);
                        }
                        if (fromEnd[port[curr.pos]] > curr.latency + p[port[curr.pos]]) {
                            fromEnd[port[curr.pos]] = curr.latency + p[port[curr.pos]];
                            Bfs bfs = new Bfs(port[curr.pos], curr.latency + p[port[curr.pos]], false);
                            queue.add(bfs);
                        }
                    }
                }
            }
            System.out.println("Case #" + i + ": " + n);
        }
    }

    private static class Bfs {
        int pos;
        long latency;
        boolean fromStart;

        Bfs(int pos, long latency, boolean fromStart) {
            this.pos = pos;
            this.latency = latency;
            this.fromStart = fromStart;
        }
    }
}