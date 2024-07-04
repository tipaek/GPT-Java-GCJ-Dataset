

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int trace = 0;
        int rep_rows = 0;
        int rep_cols = 0;
        boolean row_flag = false;
        boolean col_flag = false;
        int testc = sc.nextInt();

        for (int i = 0; i < testc; i++) {
            rep_cols = 0;
            rep_rows = 0;
            trace = 0;
            int sqr = sc.nextInt();
           int mat[][] = new int[sqr][sqr];
            for (int s = 0; s < sqr; s++) {
                int[] inputNumbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < inputNumbers.length; k++) {

                    int n = inputNumbers[k];

                    mat[s][k] = n;

                }
            }

            for(int a =0;a<sqr;a++){
                ArrayList<Integer> rowz = new ArrayList<Integer>();
                row_flag = false;
                for(int b=0;b<sqr;b++){
                   if(a == b){
                       trace = trace + mat[a][b];
                   }
                    if (rowz.contains(mat[a][b]) && !row_flag) {
                        rep_rows++;
                        row_flag = true;
                    } else {
                        rowz.add(mat[a][b]);
                    }

                }
            }

            for(int b =0;b<sqr;b++){
                ArrayList<Integer> colz = new ArrayList<Integer>();
                col_flag = false;
                for(int a=0;a<sqr;a++){
                    if (colz.contains(mat[a][b]) && !col_flag) {
                        rep_cols++;
                        col_flag = true;
                    } else {
                        colz.add(mat[a][b]);
                    }

                }
            }

            System.out.println("Case #" + (i+1) + ": " + trace + " " + rep_rows + " " + rep_cols);

        }


    }
}

