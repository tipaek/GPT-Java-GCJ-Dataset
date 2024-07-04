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
                boolean visited[] = new boolean[k];
                PriorityQueue<Bfs> queue = new PriorityQueue<Bfs>(new Comparator<Bfs> () {
                    public int compare(Bfs a, Bfs b) {
                        return a.latency - b.latency;
                    }
                });
                int start = s[j] - 1;
                int end = e[j] - 1;
                if (start == end) continue;
                visited[start]=true;
                queue.add(new Bfs(start, 0));
                while (queue.size() != 0)
                {

                    Bfs curr = queue.poll();
                    if (curr.pos == end) {
                        n += curr.latency;
                        break;
                    }
                    if (curr.pos != 0 && !visited[curr.pos-1]) {
                        visited[curr.pos-1] = true;
                        Bfs bfs = new Bfs(curr.pos-1, curr.latency + l[curr.pos]);
                        queue.add(bfs);
                    }
                    if (curr.pos != k-1 && !visited[curr.pos+1]) {
                        visited[curr.pos+1] = true;
                        Bfs bfs = new Bfs(curr.pos+1, curr.latency + r[curr.pos]);
                        queue.add(bfs);
                    }
                    if (!visited[port[curr.pos]]) {
                        visited[port[curr.pos]] = true;
                        Bfs bfs = new Bfs(port[curr.pos], curr.latency + p[curr.pos]);
                        queue.add(bfs);
                    }

                }
            }
            System.out.println("Case #" + i + ": " + n);
        }
    }

    private static class Bfs {
        int pos;
        int latency;

        Bfs(int pos, int latency) {
            this.pos = pos;
            this.latency = latency;
        }
    }
}