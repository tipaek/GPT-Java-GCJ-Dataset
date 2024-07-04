import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ct = 1;
        while (ct <= t) {
            int nt = sc.nextInt();
            int[][] ar = new int[nt][2];
            boolean[][] adj = new boolean[nt][nt];
            boolean[] visited = new boolean[nt];
            boolean answerFound = false;

            for (int i = 0; i < nt; i++) {
                ar[i][0] = sc.nextInt();
                ar[i][1] = sc.nextInt();
            }

            for (int i = 0; i < nt; i++) {
                for (int j = 0; j < nt; j++) {
                    if (i != j && ar[i][1] <= ar[j][0]) {
                        adj[i][j] = true;
                    }
                }
            }
//            printmat(adj);

            for (int i = 0; i < nt; i++) {
                if (!visited[i] && isStart(i, adj)) {
                    visited[i] = true;
                    if (possible(i, adj, visited, ct)) {
                        answerFound = true;
                        break;
                    }
                    visited[i] = false;
                }
            }
            if (!answerFound) System.out.println("Case #" + ct + ": " + "IMPOSSIBLE");
            ++ct;
        }
    }
//
//    private static void printmat(boolean[][] adj) {
//        for (int i = 0; i < adj.length; i++) {
//            System.out.println();
//            for (int j = 0; j < adj.length; j++) {
//                System.out.print(adj[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    private static boolean possible(int start, boolean[][] adj, boolean[] visited, int ct) {
        for (int i = 0; i < adj.length; i++) {
            if (adj[start][i]) {
                visited[i] = true;
                if (isEnd(i, adj)) {
                    if (allVisited(visited)) {
                        printSolution(visited, ct);
                        return true;
                    }
                    for (int j = 0; j < adj.length; j++) {
                        if (!visited[j] && dfs(j, adj, visited)) {
                            printSolution(visited, ct);
                            return true;
                        }
                    }
                } else {
                    if (possible(i, adj, visited, ct)) return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    private static boolean dfs(int start, boolean[][] adj, boolean[] visited) {
        visited[start] = true;
        if (allVisited(visited)) {
            visited[start] = false;
            return true;
        }
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i] && dfs(i, adj,visited)) {
                visited[start] = false;
                return true;
            }
        }
        visited[start] = false;
        return false;
    }

    private static void printSolution (boolean[] visited, int ct) {
        StringBuilder sb = new StringBuilder();
        for (boolean vis : visited) {
            if (vis) sb.append("C");
            else sb.append("J");
        }
        System.out.println("Case #" + ct + ": " + sb.toString());
    }

    private static boolean allVisited(boolean[] visited) {
        int count = 0;
        for (boolean status : visited) if (status) count++;
        return count == visited.length;
    }

    private static boolean isStart(int j, boolean[][] adj) {
        for (boolean[] row : adj) {
            if (row[j]) return false;
        }
        return true;
    }

    private static boolean isEnd(int j, boolean[][] adj) {
        for (int i = 0; i < adj.length; i++) {
            if (adj[j][i]) return false;
        }
        return true;
    }
}