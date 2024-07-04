import java.util.Scanner;
import java.util.ArrayList;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            ArrayList<Integer> matrix = new ArrayList<Integer>();
            int trace = 0;
            for (int j = 0; j < n*n; j++) {
                int k = scan.nextInt();
                matrix.add(k);
            }

            for (int u = 0; u < n; u++) {
                    trace += matrix.get(u*n + u);
            }

            int r = 0;
            for (int u = 0; u < n; u++) {
                ArrayList<Integer> row = new ArrayList<Integer>();
                for (int v = 0; v < n; v++) {
                    if (row.contains(matrix.get(u*n + v))) {
                        r++;
                        break;
                    } else {
                        row.add(matrix.get(u*n + v));
                    }
                }
            }

            int c = 0;
            for (int v = 0; v < n; v++) {
                ArrayList<Integer> column = new ArrayList<Integer>();
                for (int u = 0; u < n; u++) {
                    if (column.contains(matrix.get(u*n + v))) {
                        c++;
                        break;
                    } else {
                        column.add(matrix.get(u*n + v));
                    }
                }
            }


            System.out.format("Case #%d: %d %d %d\n", i, trace, r, c);
            matrix.clear();
        }
        scan.close();
    }
}