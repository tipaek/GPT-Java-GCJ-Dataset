import java.util.*;
import java.io.*;
class Check
{
    public static void main(String []args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        int sum=0,r=0,c=0,s;
        for(int i=0;i<T;i++)
        {
            int N=Integer.parseInt(br.readLine());
            int A[][]=new int[N][N];
            for(int j=0;j<N;j++)
            {
                
                for(int k=0;k<N;k++)
                {
                    A[j][k]=Integer.parseInt(br.readLine());   
                    if(j==k)
                    sum+=A[j][k];
                }
                
                
                
            }
            c=col(A,N);
            r=row(A,N);
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
        
    }
   public static int col(int m[][],int n)
   {
    int r=0,i,j;
    for(i=0;i<n;i++)
    {
        HashSet<Integer> h=new HashSet<Integer>(n);
        for(j=0;j<n;j++)
        {
            h.add(m[j][i]);
        }
        int size=h.size();
                if(size!=n&&(size==1||size==2))
                {
                    r=Math.max(r,n-size+1);
                }
               if(size!=n&&size>2)
               {
                    r=Math.max(r,n-size);
                }
    }
    return r;
    }
    public static int row(int m[][],int n)
   {
    int r=0,i,j;
    for(i=0;i<n;i++)
    {
        HashSet<Integer> h=new HashSet<Integer>(n);
        for(j=0;j<n;j++)
        {
            h.add(m[i][j]);
        }
        int size=h.size();
                if(size!=n&&(size==1||size==2))
                {
                    r=Math.max(r,n-size+1);
                }
               if(size!=n&&size>2)
               {
                    r=Math.max(r,n-size);
                }
    }
    return r;
    }
}