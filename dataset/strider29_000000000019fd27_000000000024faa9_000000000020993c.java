import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int t,t1;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        t1 = t;
        while (t-- > 0) {
            int n = scanner.nextInt();
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int rowAns = 0;
            int colAns = 0;
            int trace = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    if (set.contains(arr[i][j])) {
                        rowAns++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    if (set.contains(arr[j][i])) {
                        colAns++;
                        break;
                    }
                    set.add(arr[j][i]);
                }
            }
            for (int i = 0; i < n; i++) {
                trace+=arr[i][i];
            }
            System.out.println("Case #" + (t1-t) + ": " + trace + " " + rowAns + " " + colAns);
        }
    }
}
