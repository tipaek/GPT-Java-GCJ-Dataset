import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private ArrayList<int[]> path = new ArrayList<>();
    private Boolean[][] visited;

    ArrayList<int[]> findPath(int one, int two, int sum) {
        visited = new Boolean[sum][sum];
        for (Boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        if (explore(one, two, sum)) {
            return path;
        }
        return path;
    }

    private Boolean explore(int one, int two, int sum) {
        if (one < 1 || two < 1 || two > one) {
            return false;
        }
        if (visited[one - 1][two - 1]) {
            return false;
        }
        
        int value = binomialCoefficient(one - 1, two - 1);
        if (value > sum) {
            return false;
        }
        
        path.add(new int[]{one, two});
        visited[one - 1][two - 1] = true;
        sum -= value;
        
        if (sum == 0) {
            return true;
        }
        
        if (explore(one + 1, two, sum) ||
            explore(one + 1, two + 1, sum) ||
            explore(one - 1, two, sum) ||
            explore(one - 1, two + 1, sum) ||
            explore(one, two - 1, sum) ||
            explore(one, two + 1, sum)) {
            return true;
        }
        
        path.remove(path.size() - 1);
        visited[one - 1][two - 1] = false;
        return false;
    }

    static int binomialCoefficient(int n, int k) {
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

    static void solve(int a, int iteration) {
        ArrayList<int[]> result = new Main().findPath(1, 1, a);
        System.out.println("Case #" + iteration + ": ");
        for (int[] coordinates : result) {
            System.out.println(coordinates[0] + " " + coordinates[1]);
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