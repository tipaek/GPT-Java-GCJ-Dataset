import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int t = sc.nextInt();
        int sum = 0;
        int r = 0;
        int c = 0;
        for (int s = 0; s < t; s++) {
            sum = 0;
            r = 0;
            c = 0;
            int n = sc.nextInt();
            int[][] ar = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = sc.nextInt();
                }
                System.out.println(Arrays.toString(ar[i]));
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map.put(ar[i][j], map.getOrDefault(ar[i][j], 0) + 1);
                    map2.put(ar[j][i], map2.getOrDefault(ar[j][i], 0) + 1);
                    if (i == j) {
                        sum += ar[i][j];
                    }
                }
                for (int j = 1; j < n + 1; j++) {
                    if (map.containsKey(j) && map.get(j) > 1) {
                        r++;
                        break;
                    }
                }
                for (int j = 1; j < n + 1; j++) {
                    if (map2.containsKey(j) && map2.get(j) > 1) {
                        c++;
                        break;
                    }
                }
                map.clear();
                map2.clear();
            }
            System.out.println("Case #" + (s + 1) + ": " + sum + " " + r + " " + c);
        }
    }
}