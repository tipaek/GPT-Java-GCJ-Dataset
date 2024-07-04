import java.util.*;

public class Solution{

     public static void main(String []args){
        
        Scanner sc=new Scanner(System.in);
        
       int test=sc.nextInt();
       for(int i=0;i<test;i++)
       {
           
           int n=sc.nextInt();
           
           int[][] table=new int[n][n];
            int[] row_table=new int[n];
              int[] col_table=new int[n];
           int row_count=0,  col_count=0;
           int row=0,col=0;
           int diag=0;
           for(int j=0;j<n;j++) //row
           {
               for(int k=0;k<n;k++) //col
               {
                   
                   
                    
                    table[j][k]= sc.nextInt();
                    row_table[table[j][k]-1]=1;
                 
                  
                    if(j==k)
                      diag+=table[j][k];
                   
               }
               int check=1;
              for(int p=0;p<n;p++)
                    {check&=row_table[p];
                    row_table[p]=0;
                    }
               if(check==0)
                  ++row;
                  
              
             
           }
           
           
         int total=0;
           
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                     col_table[table[k][j]-1]=1;
                   
               }
               int check=1;
              for(int p=0;p<n;p++)
                    {check&=col_table[p];
                    col_table[p]=0;
                    }
               if(check==0)
                  ++col;
               
           }
           System.out.println("Case #"+(i+1)+": "+diag+" "+row+" "+col);
           
       }
        
     }
}