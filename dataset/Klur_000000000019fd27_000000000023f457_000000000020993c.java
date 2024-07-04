
import java.util.*;
import java.io.*;

/**
 * In
 * 3
 * 4
 * 1 2 3 4
 * 2 1 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 4
 * 2 2 2 2
 * 2 3 2 3
 * 2 2 2 3
 * 2 2 2 2
 * 3
 * 2 1 3
 * 1 3 2
 * 1 2 3
 *
 * Out
 * Case #1: 4 0 0
 * Case #2: 9 4 4
 * Case #3: 8 0 2
 */

public class Solution {

    public void scanTest(InputStream is){
        try(Scanner sc = new Scanner(is)){
            int testCount = sc.nextInt();
            for (int t = 1; t<= testCount; t++){
                System.out.print("Case #" + t + ":");

                int matrixSize = sc.nextInt();
                int k = 0;
                int r = 0;
                int c = 0;

                // k + r + c
                ArrayList<Set<Integer>> colDataList = new ArrayList<>();
                Set<Integer> matachedCol = new HashSet<>();
                for(int col = 1; col <= matrixSize; col++){
                    colDataList.add(new HashSet<Integer>());
                }

                for( int row = 1; row <= matrixSize; row++){
                    Set<Integer> rowData = new HashSet<Integer>();
                    boolean isRowDup = false;
                    for( int col = 1; col <= matrixSize; col++){
                        int value = sc.nextInt();
                        if(row == col){
                            k = k + value;
                        }
                        if(rowData.add(value) == false && !isRowDup){
                            r++;
                            isRowDup=true;
                        }
                        if (colDataList.get(col-1).add(value) == false){
                            if(matachedCol.add(col) == false){
                            } else {
                                c++;
                                matachedCol.add(col);
                            }
                        }
                    }
                }
                System.out.print(" " + k);
                System.out.print(" " + r);
                System.out.println(" " + c);

            }
        }

    }

    public static void main(String[] agrs) throws FileNotFoundException {
        long time = System.nanoTime();
        Solution vestigium = new Solution();
        vestigium.scanTest(new BufferedReader(new InputStreamReader(System.in)));

    }
}