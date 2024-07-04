import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static Integer[] getColumn(Integer[][] matrix,Integer index,Integer length){

        Integer[] col = new Integer[length];
        for(int i = 0; i < length; i++){
            col[i] = matrix[i][index];
        }
        return col;
    }
    public static <T> Set<T> convertArrayToSet(T array[]){
        Set<T> set  = new HashSet<>();
        for(T t:array){
            set.add(t);
        }
        return set;
    }

    private static int colRepeats(Integer[][] matrix,Integer length){
        int colRepeatSum = 0;
        Integer[] col = new Integer[length];
        Set<Integer> colSet = new HashSet<>();
        for(int k = 0; k < length; k++){
            col = getColumn(matrix,k,length);
            colSet = convertArrayToSet(col);
            if(colSet.size() < length)
                colRepeatSum += 1;
        }
        return colRepeatSum;
    }

    private static int rowRepeats(Integer[][] matrix,Integer length){
        int rowRepeatSum = 0;
        Integer[] row = new Integer[length];
        Set<Integer> rowSet = new HashSet<>();
        for(int j = 0; j < length; j++){
            row = matrix[j];
            rowSet = convertArrayToSet(row);
            if(rowSet.size() < length)
                rowRepeatSum += 1;
        }
        return rowRepeatSum;
    }

    private static int trace(Integer[][] matrix,Integer length){
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer cases = in.nextInt();
        Integer[][] matrix ;

        for(int i = 0; i < cases ; i++){
            Integer squareMatrixLength = in.nextInt();
          //  System.out.println("Display squareMatrixLength:"+squareMatrixLength);
            matrix = new Integer[squareMatrixLength][squareMatrixLength];
            for(int j = 0; j < squareMatrixLength; j++){
                for(int k = 0; k < squareMatrixLength; k++){
                    matrix[j][k] = in.nextInt();
                  //  System.out.println("Display:"+matrix[j][k]);
                   // System.out.println("Display:"+in.nextInt());
                }
            }

            System.out.println("Case #"+(i+1)+": "+trace(matrix,squareMatrixLength)+" "+rowRepeats(matrix,squareMatrixLength)+" "+colRepeats(matrix,squareMatrixLength));


        }




    }
}
