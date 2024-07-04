import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] M = new int[N][N];
            int trace = 0;
            int r = 0;
            for (int i=0; i < N; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j=0; j < N; j++) {
                    M[i][j] = scanner.nextInt();
                    set.add(M[i][j]);
                    if (i == j) trace += M[i][i];
                }
                if (set.size() != N) r++;
            }
            int c = 0;
            for (int j=0; j < N; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i=0; i < N; i++) {
                    set.add(M[i][j]);
                }
                if (set.size() != N) c++;
            }    
            System.out.println("Case #"+(t+1)+": "+trace+" "+r+" "+c);
        }
    }
}