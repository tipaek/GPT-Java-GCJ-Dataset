import java.util.Scanner;

public class Solution {
    public static void main(String [] argv){
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for(int i = 0; i< numberOfTestCases; i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
           
            if(k%n == 0){
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                printMatrix(n,k/n);
            }
            else{
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
        }
    }
    private static void printMatrix(int n, int k){
        int m = n+1;
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++){
            int t = m;
            int diffrence = t - n;
            while(t<=n){
                matrix[i][t-m] = t;
                t++;
            }
            for(int j = 1; j<m; j++){
                
                matrix[i][j-diffrence] = j;
            }
            m--;
            
        }
        for(int i=0; i<n; i++){
            for(int j =0; j<n;j++){
                int l = matrix[i][j];
                if(((l+1)%(n+1)) == 0)
                    matrix[i][j] = 1;
                else 
                    matrix[i][j] = (l+1);
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}