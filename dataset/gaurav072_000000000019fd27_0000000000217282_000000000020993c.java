import java.util.Scanner;

class Solution {
    public static void main() {
        Scanner read = new Scanner(System.in);
        int t = read.nextInt();
        int temp = t;
        while(t-- != 0){

            int n = read.nextInt();
            int a[][] = new int[n][n];

            for (int i = 0; i < n; i++ ){
                for (int j = 0; j < n; j++){
                    a[i][j] = read.nextInt();
                }
            }

            long trace = 0;
            for (int i = 0; i < n; i++ ){
                trace += a[i][i];
            }

            long repeatedRows = 0;
            int[] rowFreq = new int[n+1];
            for (int i = 0; i < n; i++){

                for (int j = 0; j < n+1; j++)
                    rowFreq[j] = 0;

                for (int j = 0; j < n; j++)
                    rowFreq[a[i][j]]++;

                for (int j = 0; j < n+1; j++) {
                    if (rowFreq[j] > 1){
                        repeatedRows++;
                        break;
                    }
                }
            }

            long repeatedCols = 0;
            int[] colFreq = new int[n+1];
            for (int i = 0; i < n; i++){

                for (int j = 0; j < n+1; j++)
                    colFreq[j] = 0;

                for (int j = 0; j < n; j++)
                    colFreq[a[j][i]]++;

                for (int j = 0; j < n+1; j++) {
                    if (colFreq[j] > 1){
                        repeatedCols++;
                        break;
                    }
                }
            }

            int caseNo = temp - t;
            System.out.println("Case #"+caseNo+": " + trace + " " + repeatedRows + " " +repeatedCols);
        }
    }
}
