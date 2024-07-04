
import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input= scanner.nextLine();
        int T = Integer.parseInt(input);
        for(int i=0;i< T; i++){
            input= scanner.nextLine();
            int N = Integer.parseInt(input);
            int [][] matrix = new int[N][N];
            int row = 0;
            int col;
            for(int j=0; j<N; j++){
                String[] inputRow = scanner.nextLine().split(" ");
                for(int k=0;k<N;k++){
                    matrix[j][k]= Integer.parseInt(inputRow[k]);
                }
            }

            for(int j=0;j<matrix.length;j++){
                if(!isRowLatin(matrix[j])){
                    row++;
                }
            }
            col = numberOfNonLatinColumns(matrix);
            int trace = computeTrace(matrix);
            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);

        }

    }
    

    private static int computeTrace(int[][] matrix){
        int trace=0;
        for(int i=0;i<matrix.length;i++){
                trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean isRowLatin(int[] row){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<row.length;i++){
            if(!set.add(row[i])){
                return false;
            }

        }
        return true;

    }

    private static int numberOfNonLatinColumns(int[][] matrix){
        int col=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(!set.add(matrix[j][i])){
                    col++;
                    break;
                }
            }
            set.clear();
        }
        return col;
    }
    
}