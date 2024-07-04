import java.util.*;
import java.util.Scanner;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        int triangles[][] = constructTriangle(500);
        for (int k = 1; k <= num; k++) {
            int sum = scanner.nextInt();
            System.out.println("Case #" + k + ": " + helper(sum, triangles));
        }
    }

    static int[][] constructTriangle(int m) {
        int result[][] = new int[m+1][m+1];
        result[1][1] = 1;
        for(int i = 2; i <= m; i++) {
            for(int j = 1; j <= i; j++) {
                result[i][j] = result[i-1][j-1] + result[i-1][j];
            }
        }
        return result;
    }

    static String helper(int sum, int array[][]) {
        List<String>steps = new ArrayList<>();
        steps.add("1 1");
        HashSet<String>visited = new HashSet<>();
        visited.add("1 1");
        return go(steps, new int[]{1, 1}, sum - 1, 1, visited, array);

    }
    static int dirs[][] = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};

    static String go(List<String>steps, int prev[], int sum, int len, Set<String>visited, int array[][]) {
        if(len > 500) return null;
        if(sum < 0) {
            return null;
        }
        if(sum == 0) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < steps.size(); i++) {
                builder.append(steps.get(i)).append("\n");
            }
            return builder.toString();

        }

        for(int dir[]: dirs) {
            int x = prev[0] + dir[0];
            int y = prev[1] + dir[1];
            if(x > 0 && y > 0 && y <= x) {
                String key = x + " " + y;
                if(visited.contains(key)) continue;
                visited.add(key);
                steps.add(key);
                String result = go(steps, new int[]{x, y}, sum - array[x][y], len+1, visited, array);
                if(result != null) return result;
                steps.remove(steps.size() - 1);
                visited.remove(key);
            }
        }

        return null;

    }

}
