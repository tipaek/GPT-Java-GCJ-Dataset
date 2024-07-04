import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nam = sc.nextInt();
        for (int tr = 0; tr < nam; tr++) {
            sc.nextLine();
            int N = sc.nextInt();
            int[][] ar = new int[N][N];
            int r = 0, c = 0, trace = 0;
            for (int i = 0; i < N; i++) {
                sc.nextLine();
                HashSet<Integer> row = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    int num = sc.nextInt();
                    if (i == j) trace += num;
                    ar[i][j] = num;
                    row.add(num);
                }
                if (row.size() != N) r++;
            }
            for (int i = 0; i < N; i++) {
                HashSet<Integer> row = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    row.add(ar[j][i]);
                }
                if (row.size() != N) c++;
            }

            System.out.println("Case #" + (tr+1) + ": " + trace + " " + r + " " + c);
        }

    }
}
