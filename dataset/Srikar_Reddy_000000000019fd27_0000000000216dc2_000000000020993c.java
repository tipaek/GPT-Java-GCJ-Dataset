
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trace= 0;
        int rep_rows=0;
        int rep_cols = 0;
        boolean row_flag = false;
        boolean col_flag = false;
        int testc = sc.nextInt();
        int[] traceArray = new int[testc];
        int[] rowArray = new int[testc];
        int[] colArray = new int[testc];

        for(int i=0;i<testc;i++){
            rep_cols = 0;
            rep_rows = 0;
            trace = 0;
            int sqr = sc.nextInt();
            int matrix[][] = new int[sqr][sqr];

            ArrayList<Integer> colz = new ArrayList<Integer>();
            for(int s=0;s<sqr;s++){
                ArrayList<Integer> rowz = new ArrayList<Integer>();

                row_flag = false;
                col_flag = false;
                for(int k=0;k<sqr;k++){


                    int n = sc.nextInt();

                    if(s==k){
                        trace=trace+n;
                    }


                    if(colz.contains(n) && !col_flag){
                        rep_cols++;
                        col_flag = true;
                    }else{
                        colz.add(n);
                    }

                    if(rowz.contains(n) && !row_flag){
                        rep_rows++;
                        row_flag = true;
                    }else {
                        rowz.add(n);
                    }
                }
            }


           traceArray[i] = trace;
            rowArray[i] = rep_rows;
            colArray[i] = rep_cols;

        }

        for(int h=0;h<testc;h++) {
            System.out.println("Case#" + h + ": " + traceArray[h] + " " + rowArray[h] + " " + colArray[h]);
        }

    }
}
