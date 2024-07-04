import java.util.HashSet;
import java.util.Scanner;

public class codejam_a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            for (int j = 0; j < N;j ++) {
                HashSet<Integer> set = new HashSet<>();
                boolean rowRepeat = false;
                for (int k = 0; k < N; k++) {
                    if (j == k) {
                        trace+= arr[j][k];
                    }
                    int num = arr[j][k];
                    if (set.contains(num)) {
                        rowRepeat = true;
                    }
                    set.add(num);
                }
                if (rowRepeat) {
                    rowRepeats++;
                }
            }
            for (int k = 0; k < N; k++) {
                HashSet<Integer> set = new HashSet<>();
                boolean colRepeat = false;
                for (int j = 0; j < N; j++) {

                    int num = arr[j][k];
                    if (set.contains(num)) {
                        colRepeat = true;
                    }
                    set.add(num);
                }
                if (colRepeat) {
                    colRepeats++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i+1, trace, rowRepeats, colRepeats);
        }
    }
}
