import java.util.*;

class Solution {

    private static void solve(int N, Scanner sc, int x) {
        int[][] mat = new int [N][N];
        int k = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = sc.nextInt();
                mat[i][j] = v;
            }
        }

        for (int i = 0; i < N; i++) {
            k += mat[i][i];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = mat[i][j];
                if (set.contains(v)) {
                    r++;
                    break;
                } {
                    set.add(v);
                }
            }
            set.clear();
        }

        set.clear();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                int v = mat[i][j];
                if (set.contains(v)) {
                    c++;
                    break;
                } {
                    set.add(v);
                }
            }
            set.clear();
        }


        System.out.println(String.format("Case　#%d: %d %d %d", x, k, r, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            solve(N, sc, i + 1);
        }
    }
}
