/**
 * Created by cmueh on 04.04.2020.
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int k = 0; k < N; k++){
            int m = sc.nextInt();
            int[][] matrix = new int[m][m];
            for(int i = 0; i< m; i++){
                for(int j = 0 ; j < m; j++){
                    int v = sc.nextInt();
                    matrix[i][j] = v;
                }
            }
            int rows = 0;
            for(int i = 0; i< m; i++){
                boolean[] v= new boolean[m];
                boolean right = true;
                for(int j = 0 ; j < m; j++){
                   if(v[matrix[i][j]-1]){
                       right = false;
                       break;
                   }
                    v[matrix[i][j]-1] = true;
                }

                if(right){
                    rows++;
                }


            }
            int cols = 0;
            for(int i = 0; i< m; i++){
                boolean[] v= new boolean[m];
                boolean right = true;
                for(int j = 0 ; j < m; j++){
                    if(v[matrix[j][i]-1]){
                        right = false;
                        break;
                    }
                    v[matrix[j][i]-1] = true;
                }

                if(right){
                    cols++;
                }


            }

            int trace = 0;
            for(int i = 0; i< m; i++){
                trace += matrix[i][i];
            }

            System.out.println("Case #" + (k+1) + ": " + trace + " " + (m - rows)+ " " +(m - cols));
        }

    }

}
