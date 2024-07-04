import java.util.ArrayList;
import java.util.Scanner;

public class codeJam1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); //the number of test cases

        int[] k = new int[t];
        int[] r = new int[t];
        int[] c = new int[t];

        //ArrayList<Integer> row = new ArrayList<Integer>();
        //ArrayList<Integer> col = new ArrayList<Integer>();

        for (int ti = 0; ti < t; ++ti) {
            int n = scanner.nextInt();  //the size of the matrix

            int[][] arr = new int[n][n];

            ArrayList<Integer> row = new ArrayList<Integer>();
            ArrayList<Integer> col = new ArrayList<Integer>();

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    arr[i][j] = scanner.nextInt();
                    if (i == j) {
                        k[ti] = k[ti] + arr[i][j];
                    }

                    if (j > 0 && !row.contains(i)) {
                        for (int jc = 0; jc <= j; ++jc) {
                            if (arr[i][jc] == arr[i][j] && j!=jc && !row.contains(i)) {
                                row.add(i);
                                jc = j;
                            }
                        }
                    }

                    if (i > 0 && !col.contains(j)) {
                        for (int ic = 0; ic <= i; ++ic) {
                            if (arr[ic][j] == arr[i][j] && i!=ic && !col.contains(j)) {
                                col.add(j);
                                ic = i;
                            }
                        }
                    }

                }
                r[ti] = row.size();
                c[ti] = col.size();
            }


            String result = (new StringBuilder()).append("Case #").append(ti + 1).append(": ").append(k[ti]).append(" ").append(r[ti]).append(" ").append(c[ti]).toString();
            System.out.println(result);

        }
        scanner.close();


    }
}
