import java.util.*;

 class Test {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

      
        
        int T=sc.nextInt();
        
        
    for(int p=0;p<T;p++){
        
       int Testcase=1; 
        
        
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
           
       
        
         
        if(p == 0)
        {
            p++;
            System.out.println("Case #"+p+": "+sum+" "+row_count+" "+col_count);
            p--;
        }else if(p == 1){
            p++;
            System.out.println("Case #"+p+": "+sum+" "+row_count+" "+col_count);
            p--;
        }
        else if(p == 2){
            p++;
            System.out.println("Case #"+p+": "+sum+" "+row_count+" "+col_count);
            p--;
            
        }
    }
       
}}
