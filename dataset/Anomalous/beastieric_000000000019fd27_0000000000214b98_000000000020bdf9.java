import java.util.*;

public class Solution {
    // 0 means unvisited, 1 means J, -1 means C
    static int[] schedule;
    static boolean isPossible;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            schedule = new int[n];
            isPossible = true;
            Pair[] activitiesOrig = new Pair[n];
            Pair[] activities = new Pair[n];

            for (int j = 0; j < n; j++) {
                activitiesOrig[j] = new Pair(sc.nextInt(), sc.nextInt(), j);
                activities[j] = new Pair(activitiesOrig[j].start, activitiesOrig[j].end, j);
            }

            List<List<Integer>> adj = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                adj.add(new ArrayList<>());
            }

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (overlap(activities[j], activities[k])) {
                        adj.get(j).add(k);
                        adj.get(k).add(j);
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (schedule[j] == 0) {
                    schedule[j] = -1;
                    dfs(adj, j);
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int a : schedule) {
                    result.append(a == 1 ? "J" : "C");
                }
                System.out.println(result.toString());
            }
        }
        sc.close();
    }

    public static void dfs(List<List<Integer>> adj, int curr) {
        for (int next : adj.get(curr)) {
            if (schedule[next] == schedule[curr]) {
                isPossible = false;
                return;
            }
            if (schedule[next] == 0) {
                schedule[next] = -schedule[curr];
                dfs(adj, next);
            }
        }
    }

    public static boolean overlap(Pair a, Pair b) {
        if (a.start > b.start) {
            return overlap(b, a);
        }
        return a.end > b.start;
    }

    public static class Pair {
        int start, end, id;

        public Pair(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}