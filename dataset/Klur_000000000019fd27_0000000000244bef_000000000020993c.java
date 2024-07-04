import java.util.*;
import java.io.*;
public class Solution {


    public static void scanTest(Scanner sc){
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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        scanTest(new Scanner(new FileInputStream("D:/03_Temp/google-code-jam/src/codeJam2020/qualification/vestigium/test_data.txt")));
    }
}