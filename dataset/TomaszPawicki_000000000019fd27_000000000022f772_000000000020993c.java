public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = s.nextInt();
            int k = 0;
            int[][] tab = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    tab[i][j] = s.nextInt();
                    if (i == j) {
                        k += tab[i][j];
                    }
                }
            }

            int r = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(tab[i][j]);
                }
                if (set.size() < n) {
                    r++;
                }
            }

            int c = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    set.add(tab[i][j]);
                }
                if (set.size() < n) {
                    c++;
                }
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);

        }
    }
}
