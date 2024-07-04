import java.util.Scanner;

/**
 * @author Mwansa Gee Phiri
 */
public class Solution
{

   public static void main(String args[])
   {
     Scanner input = new Scanner(System.in);
      int casenum = input.nextInt();
        int [][] ans;
        ans = new int[casenum][casenum];
      
      for (int n = 0; n < casenum; n++) 
      {
           int N = input.nextInt();
           int [][] matrix;
           matrix = new int[N][N];
           int track = 0;
           
             for (int i = 0; i < N ; i++)
             { 
                 for (int j = 0; j < N ; j++)
                 {
                 matrix[i][j]=input.nextInt();
 
                 }
             }
             
             
              for (int i = 0; i < N ; i++)
              {
                  
                  track = track + matrix[i][i];
                  
              }
              ans[casenum][0]= track;
              ans[casenum][1] = row(matrix,N);
              ans[casenum][2]= colum(matrix,N);
              
             
           
          
          
          
      }
       for (int n = 0; n < casenum; n++) 
       {
            for (int q = 0; q < casenum; q++) 
            {
             System.out.print("Case #" + ans[n][q] + ": " + ans[n][q+1] + " " + ans[n][q+2] + " "+ ans[n][q+3]);
            }
       }
    }
    
    
    public static int row(int a[][],int N)
    {
       int y = 0 ;
       for (int i = 0; i < N ; i++)
       {   
           for (int j = 0 ; j < N ; j++)
           {
               for (int k = j+1 ; k < N ; k++)
               {
                    if(a[i][j]==a[i][k])
                    {
                        y++;
                        break;
                    }
               }
             
           }
       }
      return y ;   
    }
    
     public static int colum(int a[][], int N)
    {
       int y = 0 ;
       for (int j = 0; j < N ; j++)
       {   
           for (int i = 0 ; i < N ; i++)
           {
               for (int k = j+1 ; k < N ; k++)
               {
                    if(a[j][i]==a[j][k])
                    {
                        y++;
                        break;
                    }
               }
             
           }
       }
      return y ;  
    }
    
    
    
   
    
}
