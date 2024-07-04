import java.util.*;
class Main
{
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
int n,i,j,k,t=0,r=0,c=0;
n=sc.nextInt();

for(i=0;i<n;i++)
{
    int m;
    m=sc.nextInt();
    int a[][]=new int[m][m];
    for(j=0;j<m;j++)
    {
        for(k=0;k<m;k++)
        a[j][k]=sc.nextInt();
    }
    for(j=0;j<m;j++)
    {
        for(k=0;k<m;k++)
        {
            if(j==k)
            t+=a[j][k];
        
        }
    }
    for(j=0;j<m-1;j++)
    {
        for(k=0;k<m-1;k++)
        {
            if(a[j][k]==a[j][k+1])
            r+=1;
            if(a[j][k]==a[j+1][k])
            c+=1;
        }
    }
    System.out.println(t+" "+r+" "+c);
}
}
}
