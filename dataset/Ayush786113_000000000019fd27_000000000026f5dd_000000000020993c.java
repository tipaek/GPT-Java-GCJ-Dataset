import java.util.*;
public class Vestigium
{
    int N, m[][], a[], sum, n1[], n2[];
    Vestigium() 
    {
        N = 0;
        sum = 0;
    }
    void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N:");
        N = sc.nextInt();
    }
    void process()
    {
        a = new int[N];
        for(int i = 0, j = 1; i<N; i++, j++)
        {
            a[i] = j;
        }
        m = new int[N][N];
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<N; j++)
            {
                int a1 = (int)(Math.random()*10);
                if(a1>=1&&a1<=N)
                {
                    m[i][j] = a1;
                }
            }
        }
        for(int i = 0; i<N; i++)
        {
            sum = sum + m[i][i];
        }
        n1 = new int[N];
        n2 = new int[N];
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<(N-1); j++)
            {
                if(m[i][j] == m[i][j+1])
                    n1[j] = i+1;
            }
        }
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<(N-1); j++)
            {
                if(m[j][i] == m[j+1][i])
                    n2[j] = j+1;
            }
        }
    }
    void output()
    {
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<N; j++)
            {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.print(sum+"\t");
        for(int i = 0; i<N; i++)
        {
            if(n1[i]!=0)
                System.out.print((n1[i]-1)+"\t");
            
        }
        for(int i = 0; i<N; i++)
        {
            if(n2[i]!=0)
                System.out.print((n2[i]-1)+"\t");
            
        }
    }
    public static void main(String [] args)
    {
        Vestigium v = new Vestigium();
        v.input();
        v.process();
        v.output();
    }
}