import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int queries = inp.nextInt();

        for (int i = 0; i < queries; i++) {
            int N = inp.nextInt();
            int[][] M = new int[N][N];
            int trace = 0;
            int rowNo = 0;
            int colNo = 0;

            for (int j = 0; j < N; j++) {
                Set<Integer> temp = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    M[j][k] = inp.nextInt();
                    if (j == k) {
                        trace += M[j][k];
                    }
                    temp.add(M[j][k]);
                }
                if (temp.size() != N) {
                    rowNo++;
                }
            }

            colNo = findColDuplicate(M, N);
            ans.append("Case #").append(i + 1).append(": ")
               .append(trace).append(" ")
               .append(rowNo).append(" ")
               .append(colNo).append("\n");
        }

        System.out.print(ans);
        inp.close();
    }

    private static int findColDuplicate(int[][] M, int N) {
        int colNo = 0;
        for (int j = 0; j < N; j++) {
            Set<Integer> temp = new HashSet<>();
            for (int k = 0; k < N; k++) {
                temp.add(M[k][j]);
            }
            if (temp.size() != N) {
                colNo++;
            }
        }
        return colNo;
    }
}