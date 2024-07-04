import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            int[][] arr = new int[n][n];

            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++){
                    arr[j][k] = scanner.nextInt();
                }
            }

            solve(i + 1, n, arr);

        }

    }

    private static void solve(int index, int n, int[][] arr) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;


        for(int i=0;i<n; i++) {
            trace += arr[i][i];
        }


        for(int x =0;x<n;x++) {
            boolean[] column = new boolean[n];
            for (int y=0;y<n;y++) {
                int index2 = arr[x][y];
                if(column[index - 1]) {
                    repeatedRows++;
                    break;
                }
                column[index - 1] = true;
            }
        }

        for(int x =0;x<n;x++) {
            boolean[] rows = new boolean[n];
            for (int y=0;y<n;y++) {
                int index2 = arr[y][x];
                if(rows[index - 1] ) {
                    repeatedColumns++;
                    break;
                }
                rows[index - 1] = true;
            }
        }


        System.out.println(String.format("Case #%s: %d %d %d", index, trace, repeatedRows, repeatedColumns));
    }
}
