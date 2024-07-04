import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Solution {

    public static int calculateSum(int[][] arr, int rows, int cols) {
        int sum = 0;
        Map<Pair, List<Pair>> neighborMap = new HashMap<>();
        List<Pair> marked = new ArrayList<>();

        // Initial marking based on average neighbors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += arr[i][j];
                double neighborSum = 0;
                int count = 0;

                if (j > 0) {
                    neighborSum += arr[i][j - 1];
                    count++;
                }
                if (j < cols - 1) {
                    neighborSum += arr[i][j + 1];
                    count++;
                }
                if (i > 0) {
                    neighborSum += arr[i - 1][j];
                    count++;
                }
                if (i < rows - 1) {
                    neighborSum += arr[i + 1][j];
                    count++;
                }

                if (count > 0 && neighborSum / count > arr[i][j]) {
                    marked.add(new Pair(i, j));
                }
            }
        }

        // Mark cells with -1
        for (Pair p : marked) {
            arr[p.x][p.y] = -1;
        }

        // Initialize neighbor map
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] != -1) {
                    neighborMap.put(new Pair(i, j), findNeighbors(arr, i, j));
                }
            }
        }

        // Main loop to update the sum and mark cells
        while (!marked.isEmpty()) {
            marked.clear();

            for (Pair p : neighborMap.keySet()) {
                sum += arr[p.x][p.y];
                List<Pair> neighbors = neighborMap.get(p);
                double neighborSum = 0;

                for (Pair neighbor : neighbors) {
                    neighborSum += arr[neighbor.x][neighbor.y];
                }

                if (arr[p.x][p.y] < neighborSum / neighbors.size()) {
                    marked.add(p);
                }
            }

            for (Pair p : marked) {
                arr[p.x][p.y] = -1;
                List<Pair> neighbors = neighborMap.get(p);

                for (Pair neighbor : neighbors) {
                    if (arr[neighbor.x][neighbor.y] != -1) {
                        neighborMap.put(neighbor, findNeighbors(arr, neighbor.x, neighbor.y));
                    }
                }

                neighborMap.remove(p);
            }
        }

        return sum;
    }

    public static List<Pair> findNeighbors(int[][] arr, int x, int y) {
        List<Pair> neighbors = new ArrayList<>();
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = x + 1; i < rows; i++) {
            if (arr[i][y] != -1) {
                neighbors.add(new Pair(i, y));
                break;
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if (arr[i][y] != -1) {
                neighbors.add(new Pair(i, y));
                break;
            }
        }

        for (int j = y + 1; j < cols; j++) {
            if (arr[x][j] != -1) {
                neighbors.add(new Pair(x, j));
                break;
            }
        }

        for (int j = y - 1; j >= 0; j--) {
            if (arr[x][j] != -1) {
                neighbors.add(new Pair(x, j));
                break;
            }
        }

        return neighbors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] arr = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int result = calculateSum(arr, rows, cols);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}