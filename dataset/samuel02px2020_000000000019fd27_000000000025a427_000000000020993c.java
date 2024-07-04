public class Solution {
    
    public static void main(String[] args) {
        vestagium(matrix);
    }
    
    public static void vestagium(int[][] matrix){
    int trace = 0;
    for (int i=0;i<matrix.length;i++){
            trace += matrix[i][i];
    }
    
    int repeatedRows = 0;
    int repeatedColumns = 0;
    
    for (int i = 0 ; i < matrix.length ; i++){
        outerloop:
            for (int j = 0 ; j < matrix[i].length ; j++){
                for (int count = j+1 ; count < matrix[i].length - 1 ; count++){
                    if (matrix[i][j] == matrix[i][count]){
                        repeatedRows++;
                        break outerloop;
                    }
                }
            }
    }
    
    for (int j = 0 ; j < matrix[0].length ; j++){
        outerloop:
            for (int i = 0 ; i < matrix.length ; i++){
                for (int count = i+1 ; count < matrix.length - 1 ; count++){
                    if (matrix[i][j] == matrix[count][j]){
                        repeatedColumns++;
                        break outerloop;
                    }
                }
            }
    }
    
    System.out.print(Integer.toString(trace) + " " + Integer.toString(repeatedRows) + " " + Integer.toString(repeatedColumns));
}
}
