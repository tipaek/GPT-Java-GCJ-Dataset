import java.util.*;
import java.util.Arrays;

class CODEJAM1_2020
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        int n;
        
        int ans1trace[]=new int[t];
        int ans2[]=new int[t];
        int ans3[]=new int[t];
                    
        int trace,c;
        
        int rowsc=0,cc=0;
        
        for(int g=0;g<t;g++)
        {
              trace=0;
               n=sc.nextInt();
               int mat[][]=new int[n][n];
               
              rowsc=0;cc=0;
            
             
                for(int i=0;i<n;i++)
         {
                
              int rows[]=new int[n]; 
              c=0;
              
              
                 for(int j=0;j<n;j++)
               {   
                mat[i][j]=sc.nextInt();
                //trace
                  if(i==j)
                  {
                    trace=trace+mat[i][j];
                  }
               
                
                  rows[c]=mat[i][j];
                
                   if(c!=n){
                         c++;}
                
                
                
           
              }
              
              //rows in outer loop end
              Arrays.sort(rows);
              for(int z=0;z<n-1;z++)
              {
                  if(rows[z]==rows[z+1])
                  {
                      rowsc++;
                      break;
                    }
                }
              
            
             }
             
             
             for(int i=0;i<n;i++)
             {
                 int columns[] =new int[n]; 
                 
                 for(int j=0;j<n;j++)
                 {
                     columns[j]=mat[j][i];
                     
                    }
                    
                    Arrays.sort(columns);
                  for(int z=0;z<n-1;z++)
                 {
                  if(columns[z]==columns[z+1])
                  {
                      cc++;
                      break;
                    }
                }
                    
                }
          
                    ans1trace[g]=trace;
                    ans2[g]=rowsc;
                    ans3[g]=cc;
        
        
        
        }
       
        int x;
        for(int i=0;i<t;i++)
        {   x=i+1;
            System.out.println("Case #"+x+": "+ans1trace[i]+" "+ans2[i]+" "+ans3[i]);
        }   
        
   }
}
