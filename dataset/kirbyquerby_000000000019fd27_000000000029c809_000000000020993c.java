import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int numCases = in.nextInt();
        for(int currCase=0; currCase<numCases;currCase++) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];

            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    mat[r][c] = in.nextInt();
                }
            }

            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += mat[i][i];
            }

            int numRows, numCols;
            numRows = numCols = 0;

            Set<Integer> set = new HashSet<>();
            for(int row = 0; row < n; row++) {
                for(int col = 0; col < n; col++) {
                    int num = mat[row][col];
                    if(set.contains(num)) {
                        numRows++;
                        break;
                    }
                    set.add(num);
                }
                set.clear();
            }

            for(int col = 0; col < n; col++) {
                for(int row = 0; row < n; row++) {
                    int num = mat[row][col];
                    if(set.contains(num)) {
                        numCols++;
                        break;
                    }
                    set.add(num);
                }
                set.clear();
            }

            System.out.printf("Case #%d: %d %d %d%n", currCase + 1, sum, numRows, numCols);
        }



    }


}