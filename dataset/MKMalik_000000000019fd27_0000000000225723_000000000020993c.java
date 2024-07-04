
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0; i<t; i++) {
            int k = 0;
            int r = 0;
            int c = 0;
            int n = in.nextInt();

            int arr[][] = new int[n][n];
            for (int j=0; j<n; j++) {
                Set<Integer> check_row = new HashSet<Integer>();
                boolean check_r = true;
                boolean check_c = true;
                for (int l=0; l<n; l++) {
                    arr[j][l] = in.nextInt();
                    if (check_r)
                        check_r = check_row.add(arr[j][l]);
                    if (j==l) k+= arr[j][l];
                }
                if (!check_r) r++;
            }

            // for column
            for (int a=0; a<n; a++) {
                Set<Integer> check_col = new HashSet<Integer>();
                boolean temp = true;
                for (int b=0; b<n; b++) {
                    temp = check_col.add(arr[b][a]);
                    if (!temp) {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
    }
}
