import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0 ; i < t ; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int j = 0 ; j < n ; j++) {
                for (int k = 0 ; k < n ; k++) {
                    a[j][k] = sc.nextInt();
                }
            }
            int ca = i + 1;
            int kk = 0;
            for (int j = 0 ; j < n ; j++) {
                for (int k = 0 ; k < n ; k++) {
                    if (j == k) kk+= a[j][k];
                }
            }
            int r = 0;
            for (int j = 0 ; j < n ; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0 ; k < n ; k++) {
                    set.add(a[j][k]);
                }
                if (set.size() != n) r++;
            }
            int c = 0;
            for (int j = 0 ; j < n ; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0 ; k < n ; k++) {
                    set.add(a[k][j]);
                }
                if (set.size() != n) c++;
            }
            System.out.println("Case #" + ca + ": " + kk + " " + r + " " + c);
        }
    }

}