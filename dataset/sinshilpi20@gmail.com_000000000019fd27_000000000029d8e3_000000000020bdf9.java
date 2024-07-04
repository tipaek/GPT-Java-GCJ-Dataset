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

            for (int start = 0; start < nt; start++) {
                if (isStart(start, adj) && isFirstPath(start, adj, visited, ct)) {
                    answerFound = true;
                    break;
                }
            }

            if (!answerFound) System.out.println("Case #" + ct + ": " + "IMPOSSIBLE");
            ++ct;
        }
    }

    private static boolean isFirstPath(int start, boolean[][] adj, boolean[] visited, int ct) {
        visited[start] = true;
        if (isEnd(start, adj)) {
            if (allVisited(visited)) {
                printSolution(visited, ct);
                return true;
            }
            for (int j = 0; j < adj.length; j++) {
                if (!visited[j] && isSecondPath(j, adj, visited)) {
                    printSolution(visited, ct);
                    return true;
                }
            }
            visited[start] = false;
            return false;
        }
        for (int i = 0; i < adj.length; i++) {
            if (adj[start][i] && isFirstPath(i, adj, visited, ct)) return true;
        }
        visited[start] = false;
        return false;
    }

    private static boolean isSecondPath(int start, boolean[][] adj, boolean[] visited) {
        visited[start] = true;
        if (allVisited(visited)) {
            visited[start] = false;
            return true;
        }
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i] && adj[start][i] && isSecondPath(i, adj, visited)) {
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

//    //
//    private static void printmat(boolean[][] adj) {
//        for (int i = 0; i < adj.length; i++) {
//            System.out.println();
//            for (int j = 0; j < adj.length; j++) {
//                System.out.print(adj[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}