import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String str[]) {
        /*int[][]  A  = {
                {1,2,3,4},
                {3,1,2,4},
                {2,4,1,3},
                {4,1,1,1},
        };*/

        try {
            System.out.print("Enter number of Test Cases T : ");
            Scanner sc = new Scanner(System.in);
            int testCases = sc.nextInt();
            if (testCases < 1 || testCases > 100) {
                System.out.print("Invalid value. Value of T should be Greater than Zero and less than 100 ");
                System.exit(0);
            }

            List<String> mylist = new ArrayList<>(testCases);
            int g = 0;
            while (g < testCases) {
                System.out.print("Enter Matrix size N : ");
                //Scanner sc=new Scanner(System.in);
                int msize = sc.nextInt();
                //int columns=sc.nextInt();

                if (msize < 2 || msize > 100) {
                    System.out.println("Invalid Input. Value of N must be Greater than 1 and less than 100");
                    System.exit(0);
                }

                System.out.println("Enter array elements : ");

                int A[][] = new int[msize][msize];

                for (int r = 0; r < msize; r++) {
                    for (int c = 0; c < msize; c++) {
                        int val = sc.nextInt();
                        if (val < 1 || val > msize) {
                            System.out.println("Invalid input. Value of Mij must be Greater than Zero and Less than N");
                            System.exit(0);
                        }
                        A[r][c] = val;
                    }
                }

                String st1 = "Case #" + (g+1) + ": " + calculateResult(A);
                mylist.add(st1);
                g++;
            }

            for(String s : mylist)
                System.out.println(s);
        }
        // System.out.println(trace + "," +rowsContainingRepeatedElements + "," + colsContainingRepeatedElements);

        catch (InputMismatchException inputmismatch) {
            System.out.println("Invalid value. Value of T and N and matrix elements must be Numeric");
        }

    }

    private static String calculateResult(int[][] A) {
        int trace = 0;
        int rowsContainingRepeatedElements = 0;
        int colsContainingRepeatedElements = 0;
        for (int i = 0; i < A.length; i++) {
            int numOfDupElementsInCurrentCol = 0;
            int numOfDupElementsInCurentRow = 0;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    trace = trace + A[i][j];
                }

                for (int k = j + 1; k < A.length; k++) {
                    if (A[i][j] == A[i][k]) {
                        //System.out.println("Duplicate Found : " + A[i][j]);
                        numOfDupElementsInCurentRow++;
                    }

                    if (A[j][i] == A[k][i]) {
                        //System.out.println("Duplicate value in col Found - Col  " + i + "value=" + A[][i]);
                        numOfDupElementsInCurrentCol++;
                    }

                }

            }
            if (numOfDupElementsInCurentRow > 0)
                rowsContainingRepeatedElements++;

            if (numOfDupElementsInCurrentCol > 0)
                colsContainingRepeatedElements++;

        }
        String str = trace +"," + rowsContainingRepeatedElements + "," +  colsContainingRepeatedElements;
        return str;
    }

}