 import java.util.Scanner;

 public class Solution  {
 
 public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        
        int T,N;
        
        T= input.nextInt();
        
        while(T>0){
        N = input.nextInt();
        
        int[][] list = new int[N][N];
        
        for(int i = 0;i<list.length;i++)
            for(int j = 0;j<list[0].length;j++)
                list[i][j]=input.nextInt();
        
        // the trace
        int k = 0;
        for(int i = 0;i<list.length;i++)
            k+=list[i][i];
        
        // repeated elments in rows
        int r = 0;
        int x = 0;
        
        for(int i = 1;i<list.length;i++)
            for(int j = 1;j<list[0].length;j++){
                x = list[i][j];
                 int  l = 0;
                
                for(int g = 0,u = 0;g<list.length;g++,u++)
                if(x == list[g][u] && list[g][u] != x){
                l++;
                
                }
                    
                    if(l >= 2)
                        r++;
                
                
                
            }
        
        //repeated elemnts in colums
        int c = 0;
        int m = 0;
        
         for(int j = 1;j<list.length;j++)
            for(int i = 1;i<list[0].length;i++){
                m = list[i][j];
                int l = 0;
                
                 for(int u = 0,g = 0;u<list.length;u++,g++){
                if(m == list[g][u] && list[g][u] != x)
                l++;
                     
                }
                if(l >= 2)
                         c++;
           
            }
              
        
         int q = 1;
         System.out.println("Case #"+q+" "+k+" "+r+" "+c);
      
         T--;
        }
    }
 }
  