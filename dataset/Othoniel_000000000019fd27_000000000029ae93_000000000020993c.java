import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int k, r, c;
        for (int x = 1; x <= T; x++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    matrix[i][j] = input.nextInt();
                }
            }
            k=0;
            for (int i = 0; i < N; i++){
                k+=matrix[i][i];
            }

            r = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> list = new TreeSet<>();
                for (int j = 0; j < N; j++) {
                    if (list.contains(matrix[i][j])){
                        r++;
                        break;
                    } else {
                        list.add(matrix[i][j]);
                    }
                }
            }

            c=0;
            for (int i = 0; i < N; i++) {
                Set<Integer> list = new TreeSet<>();
                for (int j = 0; j < N; j++) {
                    if (list.contains(matrix[j][i])){
                        c++;
                        break;
                    } else {
                        list.add(matrix[j][i]);
                    }
                }
            }

            System.out.println(String.format("Case #%s: %s %s %s", x, k, r, c));
        }
    }
}
