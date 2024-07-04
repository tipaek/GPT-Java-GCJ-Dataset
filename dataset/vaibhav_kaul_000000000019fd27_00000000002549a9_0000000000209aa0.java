import java.lang.*;
import java.util.*;

public class main 
{
    public static void main(String args[])
    {
        int test_case;
        Scanner scan=new Scanner(System.in);
        test_case=scan.nextInt();
        
        int N,K;
        while(test_case!=0)
        {
            N=scan.nextInt();
            K=scan.nextInt();
            if(N<=K && K<=N*N)
            {
                makeLatinMatrix(N,K,test_case);
            } 
            else 
            {
                System.out.println("Case #"+test_case+":"+"IMPOSSIBLE");
            }
            
            test_case--;
        } 
    }
    public static void makeLatinMatrix(int matrixSize, int trace,int test_case)
    {
        Scanner input=new Scanner(System.in);
        int min=1;
        int sum=0;
        int[][] squareMatrix=new int[matrixSize][matrixSize];
        for(int row=0;row<matrixSize;row++)
        {
            for(int col=0;col<matrixSize;col++)
            {
                squareMatrix[row][col]=(int)(Math.random()*trace-1)+min;
            }
        }
        for(int row=0;row<matrixSize;row++)
        {
            System.out.print('\n');
            for(int col=0;col<matrixSize;col++)
            {
                 System.out.print(squareMatrix[row][col]);
                   System.out.print('\t');
            }
        }
            for(int row=0;row<matrixSize;row++)
            {
                sum+=squareMatrix[row][row];
            }
            if(sum==trace)
            {
                System.out.println("Case #"+test_case+":"+"POSSIBLE");
            }
            else
            {
                System.out.println("Case #"+test_case+":"+"IMPOSSIBLE");
            }
         System.out.print('\n');
        }
}
