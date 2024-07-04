
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t=0; t<T; t++) {
            int N = scan.nextInt();
            HashSet<Integer>[] rowHash = new HashSet[N];
            HashSet<Integer>[] colHash = new HashSet[N];
            int[] rowInt = new int[N];
            int[] colInt = new int[N];
            for (int i=0; i<N; i++) {
                rowHash[i] = new HashSet<>();
                colHash[i] = new HashSet<>();
            }

            int trace = 0;
            int nr = 0;
            int nc = 0;
            
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    int M = scan.nextInt();
                    if (r == c) trace += M;
                    if (!rowHash[r].add(M)) rowInt[r] = 1;
                    if (!colHash[c].add(M)) colInt[c] = 1;
                }
            }
            
            for (int i=0; i<N; i++) {
                nr += rowInt[i];
                nc += colInt[i];
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t+1, trace, nr, nc);
        }
    }
}
