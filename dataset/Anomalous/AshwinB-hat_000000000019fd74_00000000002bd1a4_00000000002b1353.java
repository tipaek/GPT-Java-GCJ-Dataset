import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private ArrayList<int[]> coordinates = new ArrayList<>();
    private Boolean[][] visited;

    public ArrayList<int[]> findPaths(int one, int two, int sum) {
        visited = new Boolean[sum][sum];
        for (Boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        if (explore(one, two, sum)) {
            return coordinates;
        }
        return coordinates;
    }

    private Boolean explore(int one, int two, int sum) {
        // Dimension check
        if (one < 1 || two < 1 || two > one) {
            return false;
        }
        // Visited check
        if (visited[one - 1][two - 1]) {
            return false;
        }
        int value = binomialCoefficient(one - 1, two - 1);

        if (value > sum) {
            return false;
        }
        coordinates.add(new int[]{one, two});
        visited[one - 1][two - 1] = true;
        sum -= value;
        if (sum == 0) {
            return true;
        }
        // Explore in six directions
        if (explore(one + 1, two, sum) || explore(one + 1, two + 1, sum) || explore(one - 1, two, sum) ||
            explore(one - 1, two + 1, sum) || explore(one, two - 1, sum) || explore(one, two + 1, sum)) {
            return true;
        }
        coordinates.remove(coordinates.size() - 1);
        visited[one - 1][two - 1] = false;
        return false;
    }

    // Returns value of Binomial Coefficient C(n, k)
    private static int binomialCoefficient(int n, int k) {
        int res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    private static void solve(int sum, int iteration) {
        ArrayList<int[]> result = new Main().findPaths(1, 1, sum);
        System.out.println("Case #" + iteration + ": ");
        for (int[] coord : result) {
            System.out.println(coord[0] + " " + coord[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(scanner.nextInt(), i);
        }
    }
}