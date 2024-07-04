import java.util.*;

public class Solution {
    private static List<String> result = new ArrayList<>();
    private static int targetSum;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = input.nextInt();
            targetSum = n;
            Map<String, List<String>> graph = new HashMap<>();

            List<List<Integer>> triangle = generatePascalTriangle(n);
            int[][] directions = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};

            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= r; c++) {
                    String position = r + " " + c;
                    for (int[] dir : directions) {
                        int x = r + dir[0];
                        int y = c + dir[1];
                        if (x >= 1 && x <= triangle.size() && y >= 1 && y <= triangle.get(x - 1).size()) {
                            graph.computeIfAbsent(position, k -> new ArrayList<>()).add(x + " " + y);
                        }
                    }
                }
            }

            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= r; c++) {
                    if (findPath(graph, new HashSet<>(), r + " " + c, triangle.get(r - 1).get(c - 1), triangle, new ArrayList<>())) {
                        r = n + 1;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ":");
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

    private static boolean findPath(Map<String, List<String>> graph, Set<String> visited, String position, int sum, List<List<Integer>> triangle, List<String> path) {
        path.add(position);
        visited.add(position);
        if (sum == targetSum && path.size() <= 500) {
            result = new ArrayList<>(path);
            return true;
        }

        for (String neighbor : graph.get(position)) {
            if (visited.contains(neighbor)) continue;
            visited.add(neighbor);
            if (findPath(graph, visited, neighbor, sum + triangle.get(neighbor.charAt(0) - '0' - 1).get(neighbor.charAt(2) - '0' - 1), triangle, path)) {
                return true;
            }
            visited.remove(neighbor);
        }
        path.remove(position);
        return false;
    }

    private static List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Collections.singletonList(1)));

        for (int r = 1; r < n; r++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> previousRow = triangle.get(r - 1);

            row.add(1);
            for (int c = 1; c < r; c++) {
                row.add(previousRow.get(c - 1) + previousRow.get(c));
            }
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
}