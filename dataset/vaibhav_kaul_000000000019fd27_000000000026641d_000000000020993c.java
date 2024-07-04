
import java.lang.*;
import java.util.*;

 
public class vestigium 
{
    public static void main(String args[])
    {
        int test_case;
        Scanner scan=new Scanner(System.in);
        test_case=scan.nextInt();
        
        int N,t=0;
        while(test_case!=0)
        {
            N=scan.nextInt();
            t++;
            calRepeatRowCol(N,t);
            test_case--;
        } 
    }
    
    public static void calRepeatRowCol(int matrixSize,int test_case)
    {
        Scanner input=new Scanner(System.in);
        int R=0,C=0,sum=0;
        int[][] squareMatrix=new int[matrixSize][matrixSize];
        
        for(int row=0;row<matrixSize;row++)
        {
            for(int col=0;col<matrixSize;col++)
            {
                squareMatrix[row][col]=input.nextInt();
            }
        }
       for(int i = 0; i < matrixSize; i++)
       {  
        for(int j = i + 1; j < matrixSize; j++) 
            {  
                if(squareMatrix[i][0] == squareMatrix[0][j])  
                {
                    R++;
                    break;
                }
            }  
       }  
       for(int i = 0; i < matrixSize; i++)
       {  
        for(int j = i + 1; j < matrixSize; j++) 
            {  
                if(squareMatrix[j][0] == squareMatrix[i][0])  
                {
                    C++;
                    break;
                }
            }  
       }  
       for(int i=0;i<matrixSize;i++)
       {
           sum+=squareMatrix[i][i];
       }
            System.out.println("Case #"+test_case+":"+sum+(R+1)+(C+1));
        }
    
}
