import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.meat();
    }

    private void meat() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i=0; i<t; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    int r = scanner.nextInt();
                    arr[j][k] = r;
                }
            }


            int row = 0;
            int col = 0;
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<n; j++) {
                set.clear();
                for (int k=0; k<n; k++) {
                    int r = arr[j][k];
                    set.add(r);
                }
                if (set.size()!=n) {
                    ++row;
                }
                set.clear();
                for (int k=0; k<n; k++) {
                    int r = arr[k][j];
                    set.add(r);
                }
                if (set.size()!=n) {
                    ++col;
                }
            }


            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += arr[j][j];
            }


            System.out.printf("Case #%d: %d %d %d\n", i+1, sum, row, col);
        }



    }

}
