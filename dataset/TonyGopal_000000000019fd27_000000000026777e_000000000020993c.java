import java.io.InputStream;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        int n, ts=0, miss_r=0, miss_c=0;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int iteration=0; iteration<T; iteration++){
        ts = miss_c = miss_r =0;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            boolean rowFound = false;
            boolean columnFound = false;
            for(int j=0; j<n; j++){
                if(i==j){
                    ts = ts + matrix[i][j];
                }
                for(int k=j+1; k<n; k++)
                {
                    if(matrix[i][k] == matrix[i][j] && !rowFound)
                    {
                        rowFound = true;
                    }
                    if(matrix[k][i] == matrix[j][i] && !columnFound)
                    {
                        columnFound = true;
                    }    
                } 
            }
            if(rowFound)
                miss_r++;
            if(columnFound)
                miss_c++;
        }
        System.out.println("Case #"+ (iteration+1) + ": " + ts + " " + miss_r + " " + miss_c);
    }
    sc.close();
    }
}
