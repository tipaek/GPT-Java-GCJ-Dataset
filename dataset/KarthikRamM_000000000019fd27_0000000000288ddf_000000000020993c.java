import java.util.*;
import java.lang.*;
public class Solution
{
public static void main(String[] args)
{
    int n,i,r,j,k,t=0,cr=0,cc=0,l,pr=0,pc=0;
    Scanner s=new Scanner(System.in);
    n=s.nextInt();
    for(i=0;i<n;i++)
    {
        r=s.nextInt();
        int a[][]=new int[r][r];
        for(j=0;j<r;j++)
            for(k=0;k<r;k++)
            {
                a[j][k]=s.nextInt();
                if(j==k)
                    t+=a[j][k];
            }
        for(j=0;j<r;j++)
            for(k=0;k<r;k++,pr=0,pc=0)
                for(l=k+1;l<r;l++)
        {
            if(pr==0 && a[j][k]==a[j][l])
            {
                cr++;
                pr=1;
            }
            if(pc==0 && a[k][j]==a[l][j])
            {
                cc++;
                pc=1;
            }
            if(pr==1 && pc==1)
                break;
        }
        /*for(j=0;j<r;j++)
            for(k=0;k<r;k++,pc=0)
                for(l=k+1;l<r;l++)
            {
                if(pc==0 && a[k][j]==a[l][j])
                {
                    cc++;
                    pc=1;
                }
            }*/
        System.out.println("Case #"+(i+1)+": "+t+" "+cr+" "+cc);
    }
}
}