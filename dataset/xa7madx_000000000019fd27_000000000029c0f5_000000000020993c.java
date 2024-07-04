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
                boolean l = true;
                
                for(int g = 0;g<list.length;g++){
                    for(int u = 0;u<list[g].length;u++)
                if(x == list[g][u])
                l = false;
                    
                    if(l == false)
                        r++;
                }
                
                
            }
        
        //repeated elemnts in colums
        int c = 0;
        int m = 0;
        
         for(int j = 1;j<list.length;j++)
            for(int i = 1;i<list[0].length;i++){
                m = list[i][j];
                boolean l = true;
                
                 for(int u = 0;u<list.length;u++){
                     for(int g = 0;g<list.length;g++)
                if(m == list[g][u])
                l = false;
                     
                     if(l == false)
                         c++;
                }
                
           
            }
              
        
        
         System.out.println("The sum of the digonal is" +k);
         System.out.println("the number of repeated elements in rows is" +r);
         System.out.println("The number of repeated elements in colums is "+ c);
         
         T--;
        }
    }
 }
  