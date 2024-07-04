import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;
    static boolean[] color;

    static boolean intersects(Point p, Point q) {
        return (p.y > q.x && p.y < q.y) || (p.x > q.x && p.x < q.y) || 
               (q.x > p.x && q.x < p.y) || (q.y > p.x && q.y < p.y) || 
               (p.x == q.x && q.y == p.y);
    }

    static boolean isBipartite(int vertex) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList[vertex]) {
            if (visited[neighbor]) {
                if (color[neighbor] == color[vertex]) {
                    return false;
                }
            } else {
                color[neighbor] = !color[vertex];
                if (!isBipartite(neighbor)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            StringBuilder result = new StringBuilder();
            int n = sc.nextInt();
            result.append("Case #").append(i + 1).append(": ");
            Point[] points = new Point[n];
            adjacencyList = new ArrayList[n];
            visited = new boolean[n];
            color = new boolean[n];

            for (int j = 0; j < n; j++) {
                adjacencyList[j] = new ArrayList<>();
            }

            for (int j = 0; j < n; j++) {
                points[j] = new Point(sc.nextInt(), sc.nextInt());
            }

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (intersects(points[j], points[k])) {
                        adjacencyList[j].add(k);
                        adjacencyList[k].add(j);
                    }
                }
            }

            boolean possible = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    if (!isBipartite(j)) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int j = 0; j < n; j++) {
                    result.append(color[j] ? 'C' : 'J');
                }
            }
            result.append("\n");
            System.out.print(result.toString());
        }
        sc.close();
    }
}