import java.lang.*;
import java.util.*;
import java.io.*;

class Main
{
  
  public static void main(String[] args) throws Exception
  {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
       int testCases=Integer.parseInt(br.readLine());
       //System.out.println(testCases);
        int testNum=1;
        while(testCases!=0)
        {
          int trace=0;
          int row=0;
          int column=0;
      
            int N=Integer.parseInt(br.readLine());
            int[][] matrix=new int[N][N];
            for(int i=0;i<N;i++)
            {
              String[] input;
              input=br.readLine().split(" ");
              for(int j=0;j<N;j++)
              {
                matrix[i][j]=Integer.parseInt(input[j]);
              }
            }
            
            for(int i=0;i<N;i++)
            {
              trace=trace+matrix[i][i];
            }
            
            
            for(int i=0;i<N;i++)
            {
              int[] rowHash=new int[N];
              int flag=0;
              for(int j=0;j<N;j++)
              {
                int num=matrix[i][j];
                if(rowHash[num-1]>=1)
                { 
                  if(flag==0)
                  {
                     row++;
                     flag=1;
                  }
                }
                rowHash[num-1]=matrix[i][j];
                //System.out.print(matrix[i][j]+" ");
              }
              //System.out.println();
            }
            
            
             for(int i=0;i<N;i++)
            {
              int[] rowCol=new int[N];
              int flag=0;
              for(int j=0;j<N;j++)
              {
                int num=matrix[j][i];
                if(rowCol[num-1]>=1)
                { 
                  if(flag==0)
                  {
                     column++;
                     flag=1;
                  }
                }
                rowCol[num-1]=matrix[j][i];
                //System.out.print(matrix[i][j]+" ");
              }
              //System.out.println();
            }
             
             System.out.println("#"+testNum+": "+trace+" "+row+" "+column);
            testCases--;
            testNum++;
        }
  }
}