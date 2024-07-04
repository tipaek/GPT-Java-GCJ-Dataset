import java.util.*; 

public class Solution{
    
    public static void main(String args[]){
        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for(int k = 0; k < t; k++){
            int rows = 0, columns = 0;
            int n = scanner.nextInt();
            
         
            int arr[][] = new int[n][n];
            int traces = 0;
            
            for(int i = 0; i < n; i++){
                int rowSum = 0;
                boolean rowCheck = false;
                Set<Integer> rowSet = new HashSet<>();
                for(int j = 0; j < n; j++){
                    arr[i][j] = scanner.nextInt();
                    if (rowSet.add(arr[i][j]) == false && !rowCheck) {
                        rows++;
                        rowCheck = true;
                    }
                    
                    if(i == j){
                        traces += arr[i][j];
                    }
                }
            }
            
            int[][] rotated = rotateClockWise(arr);
            
            for(int i = 0; i < n; i++){
                int rowSum = 0;
                boolean rowCheck = false;
                Set<Integer> rowSet = new HashSet<>();
                for(int j = 0; j < n; j++){
                    if (rowSet.add(rotated[i][j]) == false && !rowCheck) {
                        columns++;
                        rowCheck = true;
                    }
                   
                }
            }
            
            System.out.println("Case #" + (k + 1) + ": " + traces+" "+rows+" "+columns);
        }
        
    }
    
    private static int[][] rotateClockWise(int[][] matrix) {
 int size = matrix.length;
 int[][] ret = new int[size][size];

 for (int i = 0; i < size; ++i) 
  for (int j = 0; j < size; ++j) 
   ret[i][j] = matrix[size - j - 1][i]; //***

 return ret;
}
    
    

}