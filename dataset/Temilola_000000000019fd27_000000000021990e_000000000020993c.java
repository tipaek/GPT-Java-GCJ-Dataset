import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int matrixLength, testCases = in.nextInt();
        String line;

        for(int testCase = 0; testCase < testCases; testCase++){
            matrixLength = in.nextInt();
            Integer matrix[][] = new Integer[matrixLength][matrixLength];
            in.nextLine();

            for (int i = 0; i < matrixLength; i++){
                line = in.nextLine();
                Integer[] row = convertInt(line.split("\\s+"));
                matrix[i] = row;
            }

            int trace = calculateTrace(matrix);
            int rowRepeated = repeated(matrix, "row");
            int colRepeated = repeated(matrix, "col");
            System.out.println("Case #"+(testCase+1)+": "+trace+" "+rowRepeated+" "+colRepeated);
        }
    }

    private static int calculateTrace(Integer[][] matrix){
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }

    private static int repeated(Integer matrix[][], String rc) {
        int totalRepeated = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (rc.equals("row")) {
                if (!repeatedOne(matrix[i])) {
                    totalRepeated++;
                }
            } else {
                if (!repeatedOne(getColumn(matrix,i))) {
                    totalRepeated++;
                }
            }
        }
        return totalRepeated;
    }

    private static boolean repeatedOne(Integer arr[]){
        Set<Integer> arrSet = new HashSet<>(Arrays.asList(arr));
        return (arr.length == arrSet.size());
    }

    public static Integer[] getColumn(Integer matrix[][], int index){
        Integer column[] = new Integer[matrix[0].length];
        for(int i=0; i<column.length; i++){
            column[i] = matrix[i][index];
        }
        return column;
    }

    private static Integer[] convertInt(String[] stringArray) {
        Integer[] intArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            String numberAsString = stringArray[i];
            intArray[i] = Integer.parseInt(numberAsString);
        }
        return intArray;
    }

    private static void print2D(Integer[][] matrix) {
        System.out.println();
        // Loop through all rows
        for (Integer[] ints : matrix) {

            // Loop through all elements of current row
            for (int j = 0; j < ints.length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }
}
