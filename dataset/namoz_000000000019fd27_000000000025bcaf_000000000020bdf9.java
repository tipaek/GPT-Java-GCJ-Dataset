import java.util.*;
import java.io.*;

public class Solution{

    public static void solve(int test, int[][] matrix){
        if(matrix.length == 0){
            System.out.println("Case #" + test + ": ");
            return;
        }
        if(matrix.length == 1){
            System.out.println("Case #" + test + ": C");
            return;
        }
        
        Arrays.sort(matrix, (a, b) ->{
          return a[0] - b[0];  
        });
        
        char[] result = new char[matrix.length];
        int endFirst = matrix[0][1];
        int endSecond = matrix[1][1];

        result[matrix[0][2]] = 'C';
        result[matrix[1][2]] = 'J';
        
        for(int i = 2; i < matrix.length; i++){
            if(matrix[i][0] >= endFirst){
                endFirst = matrix[i][1];
                result[matrix[i][2]] = 'C';
            }
            else if(matrix[i][0] >= endSecond){
                endSecond = matrix[i][1];
                result[matrix[i][2]] = 'J';
            }else{
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + test + ": " + new String(result));
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        
        for(int i = 0; i < t; i++){
            int size = in.nextInt();
            int[][] hours = new int[size][3];
            for(int j = 0; j < size; j++){
                for(int k = 0; k < 2; k++){
                    hours[j][k] = in.nextInt();
                }
                hours[j][2] = j;
            }
            
            solve(i + 1, hours);
        }
    }

}