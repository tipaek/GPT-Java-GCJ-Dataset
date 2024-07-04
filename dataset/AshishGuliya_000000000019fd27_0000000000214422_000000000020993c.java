import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        vestigium();
    }

    private static void vestigium() {
        int N;
        int r; int c;
        int T = scanner.nextInt();
        int trace;
        int[][] matrix = new int[100][100];
        for (int t = 1; t <= T; t++){
            N = scanner.nextInt();
            trace =0;
            for (int i =0; i < N; i++) {
                for (int j = 0; j < N; j ++) {
                    matrix[i][j] = scanner.nextInt();
                    if(i ==j)
                        trace += matrix[i][j];
                }
            }
            r = getRowCount(matrix,N);
            c = getColumnCount(matrix,N);
            System.out.println("Case #"+ t +": "+trace+" " + r + " "+ c +"");
        }
    }

    private static int getRowCount(int[][] matrix, int n) {
        Set<Integer> set = new HashSet<>();
        int rc =0;
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                if(set.contains(matrix[i][j])){
                    rc++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        return rc;
    }

    private static int getColumnCount(int[][] matrix, int n) {
        Set<Integer> set = new HashSet<>();
        int rc =0;
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                if(set.contains(matrix[j][i])){
                    rc++;
                    break;
                }
                set.add(matrix[j][i]);
            }
        }
        return rc;
    }
}
