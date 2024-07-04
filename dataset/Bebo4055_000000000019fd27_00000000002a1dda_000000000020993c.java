import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in. nextInt();
        int n;

        ArrayList<int[][]> arrays = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            n = in.nextInt();
            int a[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = in.nextInt();
                }
            }
            arrays.add(a);
        }


        for (int i = 0; i < m; i++) {
            int a = 0, b = 0, c = 0;
            n = arrays.get(i).length;
            for (int j = 0; j < n; j++) {
                a += arrays.get(i)[j][j];
            }
            for (int j = 0; j < n; j++) {
                boolean sumr , sumc;
                boolean row[] = new boolean[n];
                boolean column[] = new boolean[n];
                for (int k = 0; k < n; k++) {
                    row[arrays.get(i)[j][k]-1] = true;
                    column[arrays.get(i)[k][j]-1] = true;
                }
                for (int k = 0; k < n; k++) {
                    if (!row[k]) {
                        b++;
                        break;
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (!column[k]) {
                        c++;
                        break;
                    }
                }
            }
            int index = i+1;
            System.out.println("Case #" + index + ": " + a + " " + b + " " + c + " ");

        }

    }
}
