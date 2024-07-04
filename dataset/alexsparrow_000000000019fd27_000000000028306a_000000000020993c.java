import java.util.Scanner;

public class Solution {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int k = 0; k < t; ++k){
            int ro = 0, co = 0, dia = 0;
            int n = scan.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; ++i){
                for (int j = 0; j < n; ++j) {
                    arr[i][j] = scan.nextInt();
                }
                dia += arr[i][i];
            }

            for (int i = 0; i < n; ++i){
                int[] row = new int[100];
                for (int j = 0; j < n; ++j) {
                    if(++row[arr[i][j]] > 1){
                        ++ro;
                        break;
                    }
                }

                int[] col = new int[100];
                for (int j = 0; j < n; ++j) {
                    if(++col[arr[j][i]] > 1){
                        ++co;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(k+1)+": "+dia + " " + ro + " " + co);
        }
    }
}
    