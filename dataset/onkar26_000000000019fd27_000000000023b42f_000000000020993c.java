import java.util.*;
class matrix
{
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        int i,j,k,l,s=0,p=0,z=0,q,x,a;
        int b[][]=new int[50][50];
        int N=in.nextInt();
        for(i=1;i<=N;i++)
        {
             a=in.nextInt();
            for(i=0;i<a;i++)
            {
                for(j=0;j<a;j++)
                 b[i][j]=in.nextInt();
            }
          a=0;  
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
                }
            }
            System.out.println("Case #"+""+N+":"+s+""+p+""+z);
            
        }
        
        
        
    }
}