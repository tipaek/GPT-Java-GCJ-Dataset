import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int trace = 0;
            int r = 0;
            int c = 0;
            int[][] matrix = new int[N][N];

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if(j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            for(int j = 0; j < N; j++) {
                HashSet<Integer> row = new HashSet<>();
                for(int k = 0; k < N; k++) {
                    if (row.contains(matrix[j][k])){
                        r++;
                        break;
                    }
                    else {
                        row.add(matrix[j][k]);
                    }
                }
            }

            for(int k = 0; k < N; k++) {
                HashSet<Integer> column = new HashSet<>();
                for(int j = 0; j < N; j++) {
                    if (column.contains(matrix[j][k])){
                        c++;
                        break;
                    }
                    else {
                        column.add(matrix[j][k]);
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
