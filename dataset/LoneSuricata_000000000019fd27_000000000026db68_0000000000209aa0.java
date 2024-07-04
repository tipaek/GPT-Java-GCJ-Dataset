

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static Integer[][] generateBaseMatrix(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) numbers.add(i + 1);
        Integer[][] matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = numbers.toArray(new Integer[numbers.size()]);
            Integer lastElemen = numbers.get(numbers.size() - 1);
            numbers.remove(lastElemen);
            numbers.add(0,lastElemen);
        }
        return matrix;
    }

    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int numberOfCases = in.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            Integer[][] matrix = generateBaseMatrix(n);
            if (k % n == 0) {
                int sub = k / n;
                int diagonalValue = matrix[0][0];
                substituteInMatrix(sub,diagonalValue,matrix,n);
                substituteInMatrixNotDiagonal(diagonalValue,sub,matrix,n);
                results.add(formatPossibleResult(i+1,matrix,n));
            }else{
                    results.add(formatNotPossibleResult(i+1));
            }
        }
        for(String r:results){
            System.out.println(r);
        }
    }

    private static String formatNotPossibleResult(int i) {
        String r = "Case #"+i+": IMPOSSIBLE\n";
        return r;
    }

    private static String formatPossibleResult(int i, Integer[][] matrix, int n) {
        StringBuilder r = new StringBuilder("Case #" + i + ": POSSIBLE\n");
        for(int k = 0;k<n;k++){
            for(int j =0;j<n;j++){
                r.append(matrix[k][j]);
                if(j<n-1) r.append(" ");
            }
            r.append("\n");
        }
        return r.toString();
    }

    private static void substituteInMatrixNotDiagonal(int diagonalValue, int sub, Integer[][] integers, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(integers[i][j].equals(sub) && i!=j){
                    integers[i][j]= diagonalValue;
                }
            }
        }
    }

    private static void substituteInMatrix(int sub, Integer eToSub, Integer[][] integers,int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(integers[i][j].equals(eToSub)){
                    integers[i][j]= sub;
                }
            }
        }
    }
}
