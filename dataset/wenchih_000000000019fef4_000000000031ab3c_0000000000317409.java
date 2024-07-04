import java.util.*;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {
    static Map<Character, int[]> map;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        map = new HashMap<>();
        map.put('E', new int[] {0, 1});
        map.put('W', new int[] {0, -1});
        map.put('N', new int[] {1, 0});
        map.put('S', new int[] {-1, 0});
        for (int k = 1; k <= num; k++) {
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            String line = scanner.nextLine().trim();
            int len = line.length();
            int points[][] = new int[len+1][2];
            points[0] = new int[]{x, y};
            for(int i = 0; i < len; i++) {
                int dir[] = map.get(line.charAt(i));
                points[i+1] = new int[]{x + dir[0], y + dir[1]};
                x = points[i+1][0];
                y = points[i+1][1];
            }
            System.out.println("Case #" + k + ": " + helper(points, len));
        }
    }

    private static String helper(int points[][], int n) {
       int minStep = n + 1;
        for(int i = 0; i < points.length; i++) {
            int dis = Math.abs(points[i][0]) + Math.abs(points[i][1]);
            if(dis <= i) {
                minStep = Math.min(minStep, Math.max(i,dis));
            }
        }
        if(minStep > n) {
            return "IMPOSSIBLE";
        }
        return String.valueOf(minStep);

    }

}
