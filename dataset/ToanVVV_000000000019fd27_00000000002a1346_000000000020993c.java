import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();

        for (int t = 0; t < numCase; t++) {
            int n = in.nextInt();
            int trace = 0;
            int r = 0;
            int c = 0;

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();

                }
            }
            for (int i = 0; i < n; i++) {
                trace = trace + arr[i][i];
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!set.contains(arr[i][j])) {
                        set.add(arr[i][j]);
                    } else {
                        r++;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> y = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!y.contains(arr[j][i])) {
                        y.add(arr[j][i]);
                    } else {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + r + " " + c);
        }
    }
}
