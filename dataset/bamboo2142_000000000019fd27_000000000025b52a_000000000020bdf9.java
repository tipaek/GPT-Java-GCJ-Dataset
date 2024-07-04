import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] entry1, int[] entry2) {
                    if (entry1[0] == entry2[0]) {
                        return entry1[1] - entry2[1];
                    }
                    return entry1[0] - entry2[0];
                }
            });
            boolean c = false, j = false;
            StringBuilder sb = new StringBuilder();
            Map<Character, Integer> map = new HashMap<>();
            int currstart = arr[0][0];
            int currend = arr[0][1];
            c = true;
            sb.append('C');
            map.put('C', currend);
            for (int i = 1; i < n; i++) {
                int start = arr[i][0];
                int end = arr[i][1];
                int cend = map.getOrDefault('C', -1);
                int jend = map.getOrDefault('J', -1);
                if (start < cend && start < jend) {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                } else if (start >= cend) {
                    map.put('C', end);
                    sb.append('C');
                    c = true;
                } else {
                    map.put('J', end);
                    sb.append('J');
                    j = true;
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

}
