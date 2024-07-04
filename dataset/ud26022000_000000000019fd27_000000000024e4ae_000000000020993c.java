import java.util.*;

public class Main
{
    static Scanner sc=new Scanner(System.in);
    
    private int O[][];
    
    private void input()
    {
        int t=sc.nextInt();
        O=new int[t][3];
    
        for(int i=1;i<=t;++i)
        {
            int n=sc.nextInt();
            int[][]A=new int[n][n];
            int h=0,s=n+1;
            for(int j=0;j<n;++j)
            {
                for(int k=0;k<n;++k)
                {
                    A[j][k]=sc.nextInt();
                    if(A[j][k]>=1 && A[j][k]<=n);
                    else
                        System.exit(0);
                        
                    if(A[j][k]>h)
                        h=A[j][k];
                    else if(A[j][k]<s)
                        s=A[j][k];
                }
            }
            
            calculation(i,n,A,h,s);
        }
        for(int i=1;i<=t;++i)
            display(i,O);
    }
    
    private void calculation(int t1, int n, int A[][], int h, int s)
    {
        int countr=0,countc=0,trace=0;
        
        outer:for(int i=0;i<n;++i)
        {
            for(int j=s;j<=h;++j)
            {
                int c=0;
                for(int k=0;k<n;++k)
                {
                    if(A[i][k]==j)
                    {
                        ++c;
                        if(c==2)
                        {
                            ++countr;
                            continue outer;
                        }
                    }
                }
            }
        }
        
        outer:for(int i=0;i<n;++i)
        {
            for(int j=s;j<=h;++j)
            {
                int c=0;
                for(int k=0;k<n;++k)
                {
                    if(A[k][i]==j)
                    {
                        ++c;
                        if(c==2)
                        {
                            ++countc;
                            continue outer;
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(i==j)
                    trace+=A[i][j];
            }
        }
        
        O[t1-1][0]=trace;
        O[t1-1][1]=countr;
        O[t1-1][2]=countc;
    }
    
    private void display(int t1, int O[][])
    {
        System.out.println("Case #"+t1+": "+O[t1-1][0]+" "+O[t1-1][1]+" "+O[t1-1][2]);
    }
    
    public static void main(String[]args)
    {
        Main obj=new Main();
        obj.input();
    }
}