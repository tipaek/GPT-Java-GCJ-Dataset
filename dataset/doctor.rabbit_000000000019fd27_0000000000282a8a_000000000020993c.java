import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = 0;

        while(in.hasNextInt()) {
            int numOfCases = in.nextInt();

            // 1 ~ 3
            for(int c =1 ; c <= numOfCases ; c++ ){

                N = in.nextInt(); //4
                int[][] inputArray = new int[N][N];
                int[][] rotatedArray = new int [N][N];
                int outputRows = 0;
                int outputColumns = 0;
                int sumOfDiag= 0;

                //Read incoming N rows
                for ( int i=0; i< N ; i++) {
                    Set<Integer> tmpSetForRow = new HashSet<>();
                    boolean alreadyCounted_Row = false;

                    for ( int j=0; j< N; j++) {
                        int n = in.nextInt();

                        if (i == j) {
                            sumOfDiag += n;
                        }

                        inputArray[i][j] = n;
                        rotatedArray[j][N-1-i] = n;

                        if (tmpSetForRow.add(n) == false && alreadyCounted_Row == false){
                            outputRows ++;
                            alreadyCounted_Row = true;
                        }
                    }
                }


                for (int i= 0 ; i < N ; i++) {
                    Set<Integer> tmpSetForCol = new HashSet<>();
                    boolean alreadyCounted_col = false;
                    for (int j =0; j <N ; j++ ) {
                        if (tmpSetForCol.add(rotatedArray[i][j]) == false && alreadyCounted_col == false){
                            outputColumns++;
                            alreadyCounted_col = true;
                        }
                    }

                }

                System.out.println("Case #" + c + ": " + sumOfDiag + " " + outputRows + " " + outputColumns);

            }
        }

    }

}
