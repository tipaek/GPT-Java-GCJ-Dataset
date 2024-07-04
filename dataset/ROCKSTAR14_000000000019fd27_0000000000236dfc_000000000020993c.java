import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int q=1;q<=t;q++) {
            int n = s.nextInt();
            int [][] arr = new int [n][n];
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++)
                    arr[i][j] = s.nextInt();
            }
            int c = 0;
            for (int i=0;i<n;i++) {
                Set<Integer> set = new HashSet<>();
                int j = 0;
                for (;j<n;j++) {
                    if (set.contains(arr[i][j]))
                        break;
                    else set.add(arr[i][j]);
                }
                if (j != n) c ++;
            }
            int r = 0;
            for (int i=0;i<n;i++) {
                Set<Integer> set = new HashSet<>();
                int j = 0;
                for (;j<n;j++) {
                    if (set.contains(arr[j][i]))
                        break;
                    else set.add(arr[j][i]);
                }
                if (j != n) r ++;
            }
            int trace = 0;
            for (int i=0;i<n;i++)
                trace += arr[i][i];
            System.out.println("Case #" + q + ": " + trace + " " + c + " " + r);
        }
    }
}
