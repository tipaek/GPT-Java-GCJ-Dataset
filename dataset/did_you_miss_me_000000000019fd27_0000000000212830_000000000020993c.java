import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution{

    public static void main(String[] args) {
        PrintWriter w = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int temp = t;
        while(t-- != 0){

            int n = in.nextInt();
            int a[][] = new int[n][n];

            for (int i = 0; i < n; i++ ){
                for (int j = 0; j < n; j++){
                    a[i][j] = in.nextInt();
                }
            }

            long trace = 0;
            for (int i = 0; i < n; i++ ){
                trace += a[i][i];
            }

            long repeatedRows = 0;
            int[] rowFreq = new int[n+1];
            for (int i = 0; i < n; i++){

                for (int j = 0; j < rowFreq.length; j++) {
                    rowFreq[j] = 0;
                }


                for (int j = 0; j < n; j++) {
                    rowFreq[a[i][j]]++;
                }

                for (int j = 0; j < rowFreq.length; j++) {
                    if (rowFreq[j] > 1){
                        repeatedRows++;
                        break;
                    }
                }

//                for (int j = 0; j < rowFreq.length; j++) {
//                    w.println(j + " " + rowFreq[j]);
//                }
            }

            long repeatedCols = 0;
            int[] colFreq = new int[n+1];
            for (int i = 0; i < n; i++){

                for (int j = 0; j < colFreq.length; j++) {
                    colFreq[j] = 0;
                }


                for (int j = 0; j < n; j++) {
                    colFreq[a[j][i]]++;
                }

                for (int j = 0; j < colFreq.length; j++) {
                    if (colFreq[j] > 1){
                        repeatedCols++;
                        break;
                    }
                }

//                for (int j = 0; j < colFreq.length; j++) {
//                    w.println(j + " " + colFreq[j]);
//                }
            }


            int caseNo = temp - t;
            w.println("Case #"+caseNo+": " + trace + " " + repeatedRows + " " +repeatedCols);
        }

        w.flush();
        w.close();
    }

}