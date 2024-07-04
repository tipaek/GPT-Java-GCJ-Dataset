import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        int nTest;

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        nTest = in.nextInt();

        for (int i = 0; i < nTest; i++) {// for each latin matrix
            int size = in.nextInt();
            int k = 0 ,r = 0, c = 0;
            List<Set<Integer>> colsSet = new ArrayList<>();
            boolean checkRepInCols[] = new boolean[size];
            for (int i1 = 0; i1 < size; i1++) { //initialize
                colsSet.add(new HashSet<Integer>());
                checkRepInCols[i1] = true;
            }

            for (int row = 0; row < size; row++) { //for each row
                Set<Integer> rowSet = new HashSet<>();
                boolean checkRepInRow = true;
                int[] rowArr = new int[size];



                for (int col = 0; col < size; col++) { // for each column
                    rowArr[col] = in.nextInt(); //read an int
                    if (checkRepInRow && !rowSet.add(rowArr[col])) {// if the number is already present
                        r++;
                        checkRepInRow = false;  //dont check the row again
                    }

                    if (checkRepInCols[col] && !colsSet.get(col).add(rowArr[col])) {
                        c++;
                        checkRepInCols[col] = false;
                    }
                } //end each column
                k += rowArr[row];
            } //end each row
            System.out.println("Case #"+ (i+1) + " " + k + " " + r+ " " + c);
            System.out.flush();
        } //end each matrix
    }


}


