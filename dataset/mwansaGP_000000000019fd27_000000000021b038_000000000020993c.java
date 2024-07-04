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
        ans = new int[casenum][4];
      
      for (int n = 0; n < casenum; n++) 
      {
           int N = input.nextInt();
           int [][] matrix;
           matrix = new int[N][N];
           int track = 0;
           
         for (int[] matrix1 : matrix) 
         {
             for (int column = 0; column < matrix1.length; column++)
             {
                 matrix1[column] = input.nextInt();
             }
         }
             
             
              for (int i = 0; i < N ; i++)
              {
                  
                  track = track + matrix[i][i];
                  
              }
              ans[n][0]= n+1;
              ans[n][1]= track;
              ans[n][2]= row(matrix,N);
              ans[n][3]= colum(matrix,N);
              
             
           
          
          
          
      }
       
         for (int n = 0; n < casenum; n++) 
       {
            
            
            System.out.println("Case #" + ans[n][0] + ": " + ans[n][1] + " " + ans[n][2] + " "+ ans[n][3]);
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

    