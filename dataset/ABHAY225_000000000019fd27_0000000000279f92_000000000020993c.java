import java.util.*;

  class Test {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

      
        
        int T=sc.nextInt();
         int Testcase=1; 
        
        
    for(int p=0;p<T;p++){
        
        
        
        
         int n, sum = 0;
        int row_count=0;
        int col_count=0;
         n=sc.nextInt();

        int[][] mat = new int[n][n];

    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        
        
        
        
        for (int i = 0; i < n; i++) {
            
                    sum = sum + mat[i][i];
                
            
        }

       for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int row1= row_count;
                
               for (int z =j+1; z < n; z++) {
                   if(mat[i][j] == mat[i][z])
                   {
                        row_count++;
                        break;
                   }
               }
             if(row1!=row_count)
             {
                 break;
             }
            }
            
            
       }
                
             for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int col1= col_count;
                
               for (int z =j+1; z < n; z++) {
                   if(mat[j][i] == mat[z][i])
                   {
                        col_count++;
                        break;
                   }
               }
              if(col1!=col_count)
             {
                 break;
             }
            }
            
            
       }
           
       
        
         
         System.out.println("Case #"+Testcase+": "+sum+" "+row_count+" "+col_count);
         ++Testcase;
    }
       
}}
