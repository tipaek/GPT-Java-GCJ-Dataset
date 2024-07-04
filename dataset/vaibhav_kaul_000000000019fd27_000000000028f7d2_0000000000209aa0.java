
import java.util.*;

 public class indicium
{
    public static void main(String args[])
    {
        int test_case;
        Scanner scan=new Scanner(System.in);
        test_case=scan.nextInt();
        
        int N,K,t=0;
        while(test_case!=0)
        {
            
            N=scan.nextInt();
            K=scan.nextInt();
            
            if(N<=K && K<=N*N)
            {
               t++;
                int sum=0;
                int[][] squareMatrix=new int[N][N];
                 
                 squareMatrix=makeMatrix(N).clone();
                 
                    for(int row=0;row<N;row++)
                    {
                        sum+=squareMatrix[row][row];
                    }
                    
                
                    if(sum==K)
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
                        for(int row=0;row<N;row++)
                        {
                            System.out.print('\n');
                            for(int col=0;col<N;col++)
                            {
                                System.out.print(squareMatrix[row][col]);
                            }
                        }
                    }
                 System.out.print('\n');
            } 
            else 
            {
                System.out.println("Case #"+t+":"+"IMPOSSIBLE");
            }
            
            test_case--;
        } 
    }

    private static int[][] makeMatrix(int sizeMatrix) 
    {
        int R=0,C=0;
        int[][] newArray=new int[sizeMatrix][sizeMatrix];
        for(int row=0;row<sizeMatrix;row++)
        {
            for(int col=0;col<sizeMatrix;col++)
            {
                newArray[row][col]=(int)(Math.random()*sizeMatrix)+1;
            }
        }
        for(int i=0;i<sizeMatrix;i++)
                    {
                        int array[]=new int[sizeMatrix +1];
                        for(int j=0;j<sizeMatrix;j++)
                        {
                            if(array[newArray[i][j]]==1)
                            {
                                R++;
                                break;
                            }
                            else{
                                array[newArray[i][j]]=1;
                            }
                        }
                    }
                for(int i=0;i<sizeMatrix;i++)
                {
                    int array[]=new int[sizeMatrix +1];
                    for(int j=0;j<sizeMatrix;j++)
                    {
                        if(array[newArray[j][i]]==1){
                            C++;
                            break;
                        }
                        else{
                            array[newArray[j][i]]=1;
                        }
                    }
                }
                return newArray;
     }

 }
