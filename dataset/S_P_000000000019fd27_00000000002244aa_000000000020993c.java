import java.util.*;

class Solution{
    static int findTrace(int mat[][], int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
                sum += mat[i][i];
        }
        return sum;
    }
    static int hasDuplicatesInRows(int mat[][], int n)
    {
        int duplicateRow = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int num = mat[i][j];
                for(int k = j + 1; k < mat[i].length; k++){
                    if(num == mat[i][k]){
                        duplicateRow += 1;
                    }
                }
            }
        }
        return duplicateRow;
    }
    static int hasDuplicatesInColumns(int mat[][], int n)
    {
        int duplicateCol = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int num = mat[i][j];
                for(int k = i + 1; k < n; k++){
                    if(num == mat[k][j]){
                        duplicateCol += 1;
                    }
                }
            }
        }
        return duplicateCol;
    }
    public static void main(String args[]){
        int x = 1;
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        while(T!=0){
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(scan.nextLine());
            }
        }
        int k = findTrace(matrix, n);
        int r = hasDuplicatesInRows(matrix, n);
        int c = hasDuplicatesInColumns(matrix, n);
        System.out.println("Case #" + x + ":" + " " + k + " " + r + " " + c);
        T -= 1;
        x += 1;
        }
    }
}