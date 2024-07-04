import java.util.*;

class Solution{
    
    // public static long getSumOfNo(int n){
    //     return (n*(n+1))/2;
    // }
    
    public static int getDuplicateRows(int [][] matrix){
        int countDup = 0;
        for(int i=0;i<matrix.length;i++){
            HashSet<Integer> set = new HashSet();
            for(int j=0;j<matrix.length;j++){
                if(set.contains(matrix[i][j])){
                    countDup++;
                    break;
                }
                    
                else
                    set.add(matrix[i][j]);
            }
           
        }
           return countDup;
            
    }
    
    public static int getDuplicateColumns(int [][] matrix){
        int countDup = 0;
        for(int i=0;i<matrix.length;i++){
            HashSet<Integer> set = new HashSet();
            for(int j=0;j<matrix.length;j++){
                if(set.contains(matrix[j][i])){
                    countDup++;
                    break;
                }
                    
                else
                    set.add(matrix[j][i]);
            }

        }
           return countDup;
        
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int k=1;k<=testCase;k++){
            int n = sc.nextInt();
        
            int traces = 0;
            int [][] matrix = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    matrix[i][j] = sc.nextInt();
                    
                    if(i==j)
                        traces+=matrix[i][j];
                }
                
            // Get duplicates in the row
            int dupRows = getDuplicateRows(matrix);
            int dupCols = getDuplicateColumns(matrix);
            
            System.out.println("Case #"+k+": "+traces+" "+dupRows+" "+dupCols);
            
            
        }
        
    }
}