
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int k = 1; k <= t;k++){
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n;i++){
                for(int j = 0; j < n;j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            sb.append("Case #"+k+":");
            int sum = mainDiagonal(matrix,n);
            sb.append(" " + sum);
            int r = findR(matrix,n);
            sb.append(" " + r);
            int c = findC(matrix,n);
            sb.append(" " + c + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int findC(int[][] matrix, int n) {
        int result = 0;
        for(int k = 0; k < n;k++){
            int res = 1;
            for(int i = 1; i < n;i++){
                int j = 0;
                for(j = 0; j < i;j++){
                    if(matrix[i][k] == matrix[j][k]){
                        break;
                    }
                }
                if(i == j)
                    res++;
            }
            if(res < n){
                result+=1;
            }
        }
        return result;
    }


    public static int findR(int[][] matrix,int n){
        int result = 0;
        for(int k = 0; k < n;k++){
            int res = 1;
            for(int i = 1; i < n;i++){
                int j = 0;
                for(j = 0; j < i;j++){
                    if(matrix[k][i] == matrix[k][j]){
                        break;
                    }
                }
                if(i == j)
                    res++;
            }
            if(res < n)
                result+=1;
        }
        return result;
    }

    public static int mainDiagonal(int[][] matrix,int n) {
        int sum = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                if(i == j){
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
