import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T,N,matrix[][],dupCheck[];
        int i,j,k,r,c,Sum;
        String inMat[];
        dupCheck=new int[100];
        T=Integer.parseInt(sc.nextLine());
        for(k=1;k<=T;k++)
        {
            //N=Integer.parseInt(sc.nextLine());
            /*matrix=new int[N][N];
            for(i=0,r=0;i<N;i++)
            {
                Arrays.fill(dupCheck,0);
                for(j=0;j<N;j++)
                {
                    matrix[i][j]=sc.nextInt();
                    dupCheck[matrix[i][j]]++;
                }
                for(j=0;j<100;j++)
                {
                    if(dupCheck[j]>1)
                    {
                        r++;
                        break;
                    }
                }
            }
            
            for(i=0,Sum=0;i<N;i++) Sum+=matrix[i][i];
            
            for(i=0,c=0;i<N;i++)
            {
                Arrays.fill(dupCheck,0);
                for(j=0;j<N;j++)
                {
                    dupCheck[matrix[j][i]]++;
                }
                for(j=0;j<100;j++)
                {
                    if(dupCheck[j]>1)
                    {
                        c++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #"+k+": "+Sum+" "+r+" "+c);*/
        }
    }
}