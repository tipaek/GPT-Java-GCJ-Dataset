import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        List<Integer[][]> inputs = new ArrayList<Integer[][]>();
        for (int i = 0; i < testcases; i++) {
            int rows = sc.nextInt();

            Integer input[][] = new Integer[rows][rows];
            for (int j = 0; j < rows; j++) {
                //String singleRow = sc.next();
                for (int k = 0; k < rows; k++) {
                    int value = sc.nextInt();
                    input[j][k] = value;
                }
            }
            inputs.add(input);
        }
        sc.close();
        int count = 1;
        for (Integer[][] input : inputs) {
            System.out.println("Case #" + count++ + ": " + solve(input));
        }
    }

    public static String solve(Integer[][] arr) {
        int arrLength = arr.length;
        Set<Integer> rowValues = null;
        Set<Integer> columnValues = null;
        int rowDuplicateCount = 0;
        int colDuplicateCount = 0;
        boolean rowHasDuplicate = false;
        boolean columnHasDuplicate = false;
        int diagonalSum = 0;
        for(int i = 0; i < arrLength; i++){
            //reseting values
            rowValues = new HashSet<Integer>();
            columnValues = new HashSet<Integer>();
            rowHasDuplicate = false;
            columnHasDuplicate = false;
            for(int j=0; j < arrLength ; j++ ){
                int rowValue = arr[i][j];
                int colValue = arr[j][i];
                if(!columnHasDuplicate) {
                    if (columnValues.contains(colValue)) {
                        columnHasDuplicate = true;
                    } else {
                        columnValues.add(colValue);
                    }
                }
                if(!rowHasDuplicate) {
                    if (rowValues.contains(rowValue)) {
                        rowHasDuplicate = true;
                    } else {
                        rowValues.add(rowValue);
                    }
                }
                if(i == j){
                    diagonalSum+=arr[i][j];
                }
            }
            if(columnHasDuplicate){
                colDuplicateCount++;
            }
            if(rowHasDuplicate){
                rowDuplicateCount++;
            }
        }
        return diagonalSum + " " + rowDuplicateCount + " " + colDuplicateCount;
    }

}

