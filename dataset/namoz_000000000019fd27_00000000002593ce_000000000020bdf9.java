import java.util.*;
import java.io.*;

public class Solution{

    public static void solve(int test, int[][] matrix){
        if(matrix.length == 1){
            System.out.println("Case #" + test + ": C");
            return;
        }
        StringBuilder result = new StringBuilder();

        int firstAssignedFrom = matrix[0][0];
        int firstAssignedUntil = matrix[0][1];
        int secondAssignedFrom = matrix[1][0];
        int secondAssignedUntil = matrix[1][1];

        result.append('C');
        result.append('J');
        for(int i = 2; i < matrix.length; i++){
            if(firstAssignedUntil <= matrix[i][0] || matrix[i][1] <= firstAssignedFrom){
                result.append('C');
                firstAssignedUntil = Math.max(firstAssignedUntil, matrix[i][1]);
                firstAssignedFrom = Math.min(firstAssignedFrom, matrix[i][0]);
            }else if(secondAssignedUntil <= matrix[i][0] || matrix[i][1] <= secondAssignedFrom){
                result.append('J');
                secondAssignedUntil = Math.max(secondAssignedUntil, matrix[i][1]);
                secondAssignedFrom = Math.min(secondAssignedFrom, matrix[i][0]);
            }else{
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + test + ": " + result.toString());
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        
        for(int i = 0; i < t; i++){
            int size = in.nextInt();
            int[][] hours = new int[size][size];
            for(int j = 0; j < size; j++){
                for(int k = 0; k < 2; k++){
                    hours[j][k] = in.nextInt();
                }
            }
            
            solve(i + 1, hours);
        }
    }

}