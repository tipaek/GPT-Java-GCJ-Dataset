
    import java.util .*;
    import java.io .*;

    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            //number of test cases
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int [][] matrix = new int[n][n];
                for(int j = 0; j < n; j++){
                    for(int z = 0; z < n; z++){
                        matrix[j][z] = in.nextInt();
                    }
                }
                int trace = trace(matrix);
                int cols = repeatCols(matrix);
                int rows = repeatRows(matrix);
                System.out.print("Case #" + i + ": " + trace + rows + cols);

            }
        }

        public static int trace(int [][] matrix){
            int total = 0;
            for(int i = 0; i < matrix.length; i++){
                total += matrix[i][i];
            }
            return total;
        }

        public static int repeatRows(int [][] matrix){
            int repeatedRows = 0;
            for(int i = 0; i < matrix.length; i++){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                boolean repeat = false;
                for(int j = 0; j < matrix[i].length; j++){
                    if(temp.contains(matrix[i][j])){
                        repeat = true;
                    }
                    else {
                        temp.add(matrix[i][j]);
                    }
                }
                if(repeat){
                    repeatedRows++;
                }
            }
            return repeatedRows;
        }

        public static int repeatCols(int [][] matrix){
            int repeatedCols = 0;
            for(int i = 0; i < matrix[0].length; i++){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                boolean repeat = false;
                for(int j = 0; j < matrix.length; j++){
                    if(temp.contains(matrix[i][j])){
                        repeat = true;
                    }
                    else {
                        temp.add(matrix[i][j]);
                    }
                }
                if(repeat){
                    repeatedRows++;
                }
            }
            return repeatedRows;
        }




    }