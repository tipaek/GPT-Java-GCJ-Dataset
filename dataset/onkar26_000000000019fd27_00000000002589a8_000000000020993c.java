import java.util.*;
class matrix
{
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        int i,j,k,l,s=0,p=0,z=0,q=0,x=0;
        int b[][]=new int[4][4];
        int N=in.nextInt();
        int a[]=new int[N];
        for(i=1;i<=N;i++)
        {
             a[i]=in.nextInt();
            for(j=0;j<a[i];j++)
            {
                for(k=0;k<a[i];k++)
                 b[j][k]=in.nextInt();
                 
            }
        }
        for(i=1;i<=N;i++)
        {
            for(j=0;j<a[i];j++)
            {
                for(k=0;k<a[i];k++)
                {
                   if(i==j)
                    s=s+b[j][k];
                    for(l=k+1;l<a[i];l++)
                    {
                        if(b[j][k]==b[j][l])
                         q=1;
                        if(b[k][j]==b[l][j])
                        x=1;
                    }
                }
                    
                    if(q==1)
                    p++;
                    if(x==1)
                    z++;
                    q=0;
                    x=0; 
                }
            
            System.out.println("Case #"+""+i+":"+s+""+p+""+z);
            
        }
        
        
        
    }
}