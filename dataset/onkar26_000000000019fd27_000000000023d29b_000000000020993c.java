import java.util.*;
class matrix
{
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        int i,j,k,l,s=0,p=0,z=0,q=0,x=0,a=0;
        int b[][]=new int[4][4];
        int N=in.nextInt();
        for(i=1;i<=N;i++)
        {
             a=in.nextInt();
            for(j=0;j<a;j++)
            {
                for(k=0;k<a;k++)
                 b[j][k]=in.nextInt();
            }
        }
        for(i=1;i<=N;i++)
        {
            for(j=0;j<a;j++)
            {
                for(k=0;k<a;k++)
                {
                    if(i==j)
                    s=s+b[j][k];
                    for(l=k+1;l<a;l++)
                    {
                        if(b[j][k]==b[j][l])
                         q=1;
                        if(b[k][j]==b[l][j])
                        x=1;
                    }
                    
                    if(q==1)
                    p++;
                    if(x==1)
                    z++;
                    q=0;
                    x=0;
                }
            }
            System.out.println("Case #"+""+N+":"+s+""+p+""+z);
            
        }
        
        
        
    }
}