import java.io.*;
import java.util.*;

public class Solution{
public static int getTrace(List<List<Integer>> matrix){
        int principleDiagonalTrace = 0;
        for(int i = 0; i < matrix.size(); i++){
            principleDiagonalTrace += matrix.get(i).get(i);
        }
        return principleDiagonalTrace;
    }

    public static int getNumberOfRowsWithDuplicates(List<List<Integer>> matrix){
        int result = 0;
        for (List<Integer> integers : matrix) {
            result += hasDuplicates(integers);
        }
        return result;
    }

    public static int hasDuplicates(List<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        for(int i : list){
            if(!set.add(i)) return 1;
        }
        return 0;
    }

    public static List<List<Integer>> createColumnMatrix(List<List<Integer>> rowMatrix){
        List<List<Integer>> columnMatrix = new ArrayList<>();
        for (int i = 0; i < rowMatrix.get(0).size(); i++){
            columnMatrix.add(new ArrayList<>());
            for(int j = 0; j < rowMatrix.size(); j++){
                columnMatrix.get(i).add(rowMatrix.get(j).get(i));
            }
        }
        return columnMatrix;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= tests; i++) {
            int n = in.nextInt(); // size of the matrix
            List<List<Integer>> matrix = new ArrayList<>();
            int k = 0, r = 0, c = 0;
            for(int j = 1; j <= n; j++){
                List<Integer> tempArray = new ArrayList<>();
                for(int a = 1; a <= n; a++){
                    tempArray.add(in.nextInt());
                }
                matrix.add(new ArrayList<>(tempArray));
                tempArray.clear();
            }
            k = getTrace(matrix);
            r = getNumberOfRowsWithDuplicates(matrix);
            matrix = createColumnMatrix(matrix);
            c = getNumberOfRowsWithDuplicates(matrix);
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}