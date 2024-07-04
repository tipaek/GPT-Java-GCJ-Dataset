
import java.util.*;

class Solution {

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();

            int[][] array = new int[n+1][n+1];
            int trace, row, col;
            trace = row = col = 0;

            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    int num = scanner.nextInt();
                    if(j==k) trace += num;
                    array[j][k] = num;
                }
            }

            for(int j=0; j<n; j++) {
                List<Integer> rowList = new ArrayList<>();
                for(int k=0; k<n; k++) {
                    if(rowList.contains(array[j][k])) {
                        row++;
                        break;
                    }
                    rowList.add(array[j][k]);
                }
            }

            for(int j=0; j<n; j++) {
                List<Integer> colList = new ArrayList<>();
                for(int k=0; k<n; k++) {
                    if(colList.contains(array[k][j])) {
                        col++;
                        break;
                    }
                    colList.add(array[k][j]);
                }
            }

            System.out.println("Case #" + i + ":" + " " + trace + " " + row + " " + col);
        }
    }
}