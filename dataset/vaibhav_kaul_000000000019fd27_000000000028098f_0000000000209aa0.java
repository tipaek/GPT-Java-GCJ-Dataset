
import java.util.*;

 public class Solution
{
    public static void main(String args[])
    {
        int test_case;
        Scanner scan=new Scanner(System.in);
        test_case=scan.nextInt();
        
        int N,K,t=0,R=0,C=0;
        while(test_case!=0)
        {
            t++;
            N=scan.nextInt();
            K=scan.nextInt();
            
            if(N<=K && K<=N*N)
            {
               
                int sum=0;
                int[][] squareMatrix=new int[N][N];
                
                for(int row=0;row<N;row++)
                {
                    for(int col=0;col<N;col++)
                    {
                        squareMatrix[row][col]=scan.nextInt();
                    }
                }
                    for(int row=0;row<N;row++)
                    {
                        sum+=squareMatrix[row][row];
                    }
                    for(int i=0;i<N;i++)
                {
                    int array[]=new int[N +1];
                    for(int j=0;j<N;j++)
                    {
                        if(array[squareMatrix[i][j]]==1)
                        {
                            R++;
                            break;
                        }
                        else{
                            array[squareMatrix[i][j]]=1;
                        }
                    }
                }
                for(int i=0;i<N;i++)
                {
                    int array[]=new int[N +1];
                    for(int j=0;j<N;j++)
                    {
                        if(array[squareMatrix[j][i]]==1){
                            C++;
                            break;
                        }
                        else{
                            array[squareMatrix[j][i]]=1;
                        }
                    }
                }
                    if(sum==K && R==0 && C==0)
                    {
                        System.out.println("Case #"+t+": "+"POSSIBLE");
                       for(int row=0;row<N;row++)
                        {
                            System.out.print('\n');
                            for(int col=0;col<N;col++)
                            {
                                System.out.print(squareMatrix[row][col]);
                                System.out.print('\t');
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Case #"+t+": "+"IMPOSSIBLE");
                    }
                 System.out.print('\n');
            } 
            else 
            {
                System.out.println("Case #"+test_case+":"+"IMPOSSIBLE");
            }
            
            test_case--;
        } 
    }
    
    
}
