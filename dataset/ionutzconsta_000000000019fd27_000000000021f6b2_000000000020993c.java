import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for(int t = 0; t < tests; t++) {

            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }


            int trace = 0;
            int r = 0;
            int c = 0;
            for(int i = 0; i < n; i++){

                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean dupRow = false;
                boolean dupCol = false;
                trace += mat[i][i];

                for(int j = 0; j < n; j++) {

                    if(!dupRow && rowSet.contains(mat[i][j])) {
                        r++;
                        dupRow = true;
                    }
                    else
                        rowSet.add(mat[i][j]);

                    if(!dupCol && colSet.contains(mat[j][i])) {
                        c++;
                        dupCol = true;
                    }
                    else
                        colSet.add(mat[j][i]);
                }

            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + r + " " + c);
        }


        sc.close();

    }
}
