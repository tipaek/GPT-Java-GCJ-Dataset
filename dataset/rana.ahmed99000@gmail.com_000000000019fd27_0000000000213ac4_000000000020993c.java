import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int k = 1;k<= x; k++){
            int n = sc.nextInt();
            int[][] mat= new int[n][n];
            for (int i =0;i<n;i++){
                for(int j = 0 ; j< n ; j++)
                    mat[i][j] = sc.nextInt();
            }
            int t = findTrace(mat,n);
            int r = findRow(mat,n);
            int c = findCol(mat,n);
            System.out.println("Case #"+k+": "+t+" "+r+" "+c);
        }
    }

    public static int findTrace(int[][] matrix, int n){
        int sum =0;
        for(int i =0; i<n;i++){
            sum = sum + matrix[i][i];
        }
        return sum;
    }

    public static int findRow(int[][] matrix, int n){
        int[] temp;
        int count = 0;
        for(int i = 0;i<n;i++){
            temp = new int[n];
            for(int j =0;j<n;j++){
                if(temp[matrix[i][j]-1] != 5)
                    temp[matrix[i][j]-1] = 5;
                else {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
    public static int findCol(int[][] matrix, int n){
        int[] temp;
        int count = 0;
        for(int j = 0;j<n;j++){
            temp = new int[n];
            for(int i =0;i<n;i++){
                if(temp[matrix[i][j]-1] != 5)
                    temp[matrix[i][j]-1] = 5;
                else {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
}