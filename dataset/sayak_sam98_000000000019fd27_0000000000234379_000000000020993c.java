import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t=1; t<=test; t++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int countRow = 0;
            int countCol = 0;
            int trace = 0;
            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            
            System.out.println("N = "+n);
            //for row
            for(int i=0; i<n; i++){
                Set<Integer> row = new HashSet<Integer>();
                for(int j=0; j<n; j++)
                    if(row.add(arr[i][j]) == false){
                        countRow++;
                        break;
                    }
            }
            
            //for column
            for(int i=0; i<n; i++){
                Set<Integer> col = new HashSet<Integer>();
                for(int j=0; j<n; j++)
                    if(col.add(arr[j][i]) == false){
                        countCol++;
                        break;
                    }
            }
            
            //for trace
            for(int i=0; i<n; i++){
                trace += arr[i][i];
            }
            
            System.out.println("Case #"+t+": "+trace+" "+countRow+" "+countCol);
        }
    }
}