import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace+=matrix[i][i];
            }
            int rownum = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet();
                for (int j = 0; j < n; j++) {
                    if (set.contains(matrix[i][j])) {
                        rownum++;
                        break;
                    }else {
                        set.add(matrix[i][j]);
                    }
                }
            }
            int colnum = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet();
                for (int i = 0; i < n; i++) {
                    if (set.contains(matrix[i][j])) {
                        colnum++;
                        break;
                    }else {
                        set.add(matrix[i][j]);
                    }
                }
            }
            System.out.println("Case #" + T + ": " + trace+" " +rownum+ " "+colnum);
        }
    }
}
