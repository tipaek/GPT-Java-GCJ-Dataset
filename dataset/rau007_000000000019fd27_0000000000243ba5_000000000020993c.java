import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int z = 0;z < t ;z++) {
            int n = scanner.nextInt();
            int[][] a = new int[n][n];

            int sum = 0;

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    a[i][j] = scanner.nextInt();
                    if(i == j) {
                        sum += a[i][j];
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            int row = 0;
            int col = 0;

            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (set.contains(a[i][j])) {
                        row++;
                        break;
                    } else {
                        set.add(a[i][j]);
                    }
                }
                set.clear();
            }

            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (set.contains(a[j][i])) {
                        col++;
                        break;
                    } else {
                        set.add(a[j][i]);
                    }
                }
                set.clear();
            }

            System.out.println("Case #"+(z+1)+" " + sum + " "+ row+ " " + col);
        }
    }
}
