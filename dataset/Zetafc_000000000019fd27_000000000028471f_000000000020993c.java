import java.util.*;

 class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        int C = T;
        
        //cases 
        while(T-->0){
            int N = scan.nextInt();
            //declare matrix
            int[][] matrix = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    matrix[i][j]= scan.nextInt();
                 }
            }
            //transpose 
            int[][] matrix2 = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    matrix2[j][i]= matrix[i][j];
                 }
            }
            //sum
            int sum = 0;
            for(int i=0; i<N; i++){
                sum+=matrix[i][i];
            }
            //rows 
            int rows = 0;
            for(int i=0; i<N; i++){
                Arrays.sort(matrix[i]);
                for(int j=0; j<N-1; j++){
                    if(matrix[i][j]==matrix[i][j+1]){
                        rows++;
                        break;
                    }
                }
            }
            //columns
            int columns = 0;
            for(int i=0; i<N; i++){
                Arrays.sort(matrix2[i]);
                 for(int j=0; j<N-1; j++){
                    if(matrix2[i][j]==matrix2[i][j+1]){
                        columns++;
                        break;
                    }
                 }
            }
    
            System.out.println("Case #"+(C-T)+": "+sum+" "+rows+" "+columns);
            
            
            //Case #1: 4 0 0
            //Case #2: 4 0 0
            
            
            
            
        }
        
        
    }
}