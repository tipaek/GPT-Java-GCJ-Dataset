import java.util.*;
class Vestigium
{
    public static void main()
    {
        int T=0,N=0,R=0,C=0;
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        int a[][]=new int[100][100];
        String res[]=new String[T];
        int s=0, c=0, count=0;
        
        
        for(int t=0;t<T;t++)
        {
            
            
            
            N=in.nextInt();
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    a[i][j]=in.nextInt();
                    if(i==j)
                    {
                        s=s+a[i][j];
                    }
                }
            }
            
            res[t]=="Case #"+String.valueOf(t+1)+": "+String.valueOf(s)+" ";
            s=0;
            
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    for(int k=j+1;k<N;k++)
                    {
                        if(a[i][j]==a[i][k])
                        {
                            c++;
                        }
                    }
                    if(c==1)
                    {
                        count++;
                    }
                    c=0;
                }
            }
            
            res[t]=res[t]+String.valueOf(count)+" ";
            count=0;
            
            for(int j=0;j<N;j++)
            {
                for(int i=0;i<N;i++)
                {
                    for(int k=i+1;k<N;k++)
                    {
                        if(a[i][j]==a[i][k])
                        {
                            c++;
                        }
                    }
                    if(c==1)
                    {
                        count++;
                    }
                    c=0;
                }
            }
            
            res[t]=res[t]+String.valueOf(count);
            count=0;
            
            
        }
        for(int i=0;i<T;i++)
        {
            System.out.println(res[i]);
        }
    }
}