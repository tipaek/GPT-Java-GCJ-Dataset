import java.util.*;
public class Solution
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
                    int R=0,C=0,sum=0;
                int[][] squareMatrix=new int[N][N];
                for(int row=0;row<N;row++)
                {
                    for(int col=0;col<N;col++)
                    {
                        squareMatrix[row][col]=scan.nextInt();
                    }
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
               
               
               for(int i=0;i<N;i++)
               {
                   sum+=squareMatrix[i][i];
               }
                    System.out.println("Case #"+t+": "+sum+" "+R+" "+C);
            test_case--;
        }
    }
    
    
  }