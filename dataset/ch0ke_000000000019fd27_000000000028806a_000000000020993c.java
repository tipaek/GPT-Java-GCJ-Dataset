import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int k = 0;
            int[][] M = new int[N][N];
            for (int j = 0; j < M.length; j++) {
                for (int j2 = 0; j2 < M[j].length; j2++) {
                    M[j][j2] = in.nextInt();
                    if (j == j2) k += M[j][j2];
                }
            }
            int r = 0;
            for (int j = 0; j < M.length; j++) {
                HashSet<Integer> h = new HashSet<>();
                for (int j2 = 0; j2 < M.length; j2++) {
                    if (!h.add(M[j][j2])) {
                        r++;
                        break;
                    }
                }
            }
            int c = 0;
            for (int j = 0; j < M.length; j++) {
                HashSet<Integer> h = new HashSet<>();
                for (int j2 = 0; j2 < M.length; j2++) {
                    if (!h.add(M[j2][j])) {
                        c++;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i+1, k, r, c);
        }
    }
}