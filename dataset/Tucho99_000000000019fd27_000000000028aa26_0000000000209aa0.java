import java.util.*;
public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int T= Integer.parseInt(scanner.nextLine());
        for(int t=0;t<T;t++){
            String[] values = scanner.nextLine().split(" ");
            int N = Integer.parseInt(values[0]);
            int K = Integer.parseInt(values[1]);
            if(isMatrixPossible(N, K,t)){

            }
        }

    }

    private static boolean isMatrixPossible(int n, int k, int t){
        int[][] matrix = new int[n][n];
        boolean [] success = new boolean[1];
        success[0]=false;
        boolean resul = auxBacktracking(n,k, matrix, success,0,0,1);
       if(resul) {
           System.out.println("Case #"+ (t+1)+": POSSIBLE");
           printMatrix(matrix);
       }
       else{
           System.out.println("Case #"+ (t+1)+": IMPOSSIBLE");

       }
       return resul;

    }

    private static boolean auxBacktracking(int n, int k, int[][] matrix, boolean[] success, int row, int col, int candidato){
        if(isFull(matrix) && computeTrace(matrix)==k){
            success[0]=true;
            //printMatrix(matrix);

        }
        else{

            while(!success[0] && candidato<=n && row<n && col<n){
                matrix[row][col]= candidato;
                int[] aux= new int[n];
                for(int i=0;i<n;i++){
                   aux[i]= matrix[i][col];
                }
                if(isRowLatin(matrix[row]) && isRowLatin(aux) && computeTrace(matrix)<= k){
                    if(col==n-1){
                        row++;
                        col=0;
                    }
                    else{
                        col++;
                    }
                    auxBacktracking(n, k, matrix, success, row,col,1);
                    if(!success[0]){

                        if(col==0){
                            col= n-1;
                            row--;
                        }
                        else{
                            col--;
                        }
                        if(candidato==n){
                            matrix[row][col]=0;
                        }
                        candidato++;
                    }
                } else{
                    candidato++;
                    matrix[row][col]=0;
                }


            }
        }
        return success[0];
    }

    private static boolean isFull(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==0)
                    return false;

            }
        }
        return true;
    }
    private static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
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
            if(row[i]!= 0 && !set.add(row[i])){
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
