import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while(c<=t){
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            int trace = 0;
            int rowCounter = 0;
            int colCounter = 0;
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = sc.nextInt();
                    if(i==j){
                        trace+=matrix[i][j];
                    }
                }
            }
            
            
            for(int i=0;i<n;i++){
                HashSet<Integer> set = new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    if(set.contains(matrix[i][j])){
                        rowCounter++;
                        break;
                    }else{
                        set.add(matrix[i][j]);
                    }
                }
            }
            
            
            for(int j=0;j<n;j++){
                HashSet<Integer> set = new HashSet<Integer>();
                for(int i=0;i<n;i++){
                    if(set.contains(matrix[i][j])){
                        colCounter++;
                        break;
                    }else{
                        set.add(matrix[i][j]);
                    }
                }
            }
            
            System.out.println("Case #"+c+": "+trace+" "+rowCounter+" "+colCounter);
            c++;
        }
    }
}