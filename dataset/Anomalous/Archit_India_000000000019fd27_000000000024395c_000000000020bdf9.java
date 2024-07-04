import java.util.*;

class Solution {

    private static class Node {
        public int start, end, index;

        Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static int[] C, S;
    private static int N;
    private static PriorityQueue<Node> pq;
    private static StringBuilder ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            N = sc.nextInt();
            pq = new PriorityQueue<>(N, Comparator.comparingInt(n -> n.start));
            C = new int[1440];
            S = new int[1440];

            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                pq.add(new Node(start, end, j));
            }

            Node firstTask = pq.poll();
            Arrays.fill(C, firstTask.start, firstTask.end, 1);
            ans = new StringBuilder(" ".repeat(N));
            ans.setCharAt(firstTask.index, 'C');

            boolean impossible = false;

            for (int z = 2; z <= N; z++) {
                Node task = pq.poll();
                boolean cBusy = isBusy(C, task.start, task.end);
                boolean sBusy = isBusy(S, task.start, task.end);

                if (cBusy && sBusy) {
                    impossible = true;
                    break;
                } else if (cBusy) {
                    Arrays.fill(S, task.start, task.end, 1);
                    ans.setCharAt(task.index, 'J');
                } else {
                    Arrays.fill(C, task.start, task.end, 1);
                    ans.setCharAt(task.index, 'C');
                }
            }

            String result = impossible ? "IMPOSSIBLE" : ans.toString();
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean isBusy(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return true;
            }
        }
        return false;
    }
}