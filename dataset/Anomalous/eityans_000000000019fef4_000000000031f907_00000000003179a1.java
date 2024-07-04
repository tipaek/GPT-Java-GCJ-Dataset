import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());

        for (int t = 0; t < T; t++) {
            final int N = 10000;
            int U = Integer.parseInt(sc.next());
            int[] M = new int[N];
            int[][] cnt = new int[U][26];

            for (int i = 0; i < N; i++) {
                M[i] = Integer.parseInt(sc.next());
                char[] A = sc.next().toCharArray();
                int length = A.length;

                for (int j = length - 1; j >= 0; j--) {
                    char c = A[j];
                    int U_d = length - j - 1;
                    int index = c - 'A';
                    cnt[U_d][index]++;
                }
            }

            int[] lastCnt = cnt[U - 1];
            int[][] key = new int[10][2];
            int index = 0;

            for (int i = 0; i < 26; i++) {
                if (cnt[0][i] != 0) {
                    key[index][0] = i;
                    key[index][1] = lastCnt[i];
                    index++;
                }
            }

            Arrays.sort(key, Comparator.comparingInt(a -> a[1]));

            StringBuilder ans = new StringBuilder();
            ans.append((char) (key[0][0] + 'A'));
            for (int i = 9; i > 0; i--) {
                ans.append((char) (key[i][0] + 'A'));
            }

            System.out.println("Case #" + (t + 1) + ": " + ans);
        }

        sc.close();
    }
}