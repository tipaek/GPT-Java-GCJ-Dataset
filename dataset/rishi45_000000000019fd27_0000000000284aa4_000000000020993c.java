import java.util.*;
class Vestigium
{
    public static int findTrace(int [][]M,int N)
    {
        int k=0;
        for(int i=0;i<N;i++)
            k+=M[i][i];
        return k;
    }
    public static int noOfRepeatedRows(int [][]M,int N)
    {
        int r=0;
        HashSet<Integer> s=new HashSet<Integer>();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(s.contains(M[i][j]))
                {
                    r++;
                    break;
                }
                else
                 s.add(M[i][j]);
            }
            s.clear();
        }
        return r;
    }
    public static int noOfRepeatedCols(int [][]M,int N)
    {
        int c=0;
        HashSet<Integer> s=new HashSet<Integer>();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(s.contains(M[j][i]))
                {
                    c++;
                    break;
                }
                else
                 s.add(M[j][i]);
            }
            s.clear();
        }
        
        return c;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N=sc.nextInt();
            int M[][]=new int[N][N];
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    M[i][j]=sc.nextInt();
            int k=findTrace(M,N);
            int r=noOfRepeatedRows(M,N);
            int c=noOfRepeatedCols(M,N);
            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
  
        }
    }
}