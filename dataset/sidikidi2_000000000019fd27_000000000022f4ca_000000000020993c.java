
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();


                int [][] mat = new int [n][n];
                for(int i1 =0 ;i1 < n; i1++){
                    for(int j =0 ; j< n;j++){
                        mat[i1][j]= in.nextInt();
                    }
                }

                int rowMax =0;
                int colMax =0;
                long trace =0;
                for(int i1 =0 ;i1 < n; i1++){

                    int [] row = new int [n+1];
                    int col [] = new int [n+1];

                    for(int j =0 ; j< n;j++){
                        row[mat[i1][j]]++;
                        col[mat[j][i1]]++;
                        rowMax = Math.max(row[mat[i1][j]],rowMax);

                        colMax = Math.max(col[mat[j][i1]],colMax);
                        if(i1 ==j){
                            trace+= mat[i1][j];
                        }

                    }
                }
                System.out.println("Case #" + i + ": "+ trace+ " "+(rowMax==1?0:rowMax)+" "+(colMax==1?0:colMax));
            }
        }
    }