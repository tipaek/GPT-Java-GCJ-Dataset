import java.util.*;
public class Solution
{
    static boolean imp=false;
    static int t,n,tt,a[][],count=0,k,c=0,j=0,cam[][],jam[][],nc=0,nj=0;
    static void check()
    {
        int p,q;
        for(p=0;p<nc-1 && !imp;p++)
        {
            for(q=p+1;q<=nc-1;q++)
            {
                if(cam[p][0]<cam[q][0]  && cam[p][1]>cam[q][0] || cam[p][0]==cam[q][0] || cam[p][1]==cam[q][1] || cam[p][1]>cam[q][1] && cam[p][0]<cam[q][1] || cam[p][0]>cam[q][0] && cam[p][1]<cam[q][1])
                {
                    imp=true;
                    break;
                }
            }
        }
        if(!imp)
        {
            for(p=0;p<nj-1 && !imp;p++)
            {
                for(q=p+1;q<=nj-1;q++)
                {
                    if(jam[p][0]<jam[q][0] && jam[p][1]>jam[q][0] || jam[p][0]==jam[q][0] || jam[p][1]==jam[q][1] || jam[p][1]>jam[q][1] && jam[p][0]<jam[q][1]  || jam[p][0]>jam[q][0] && jam[p][1]<jam[q][1])
                    {
                        imp=true;
                        break;
                    }
                }
            } 
        }
    }
    static void transfercam()
    {
        for(;j<nj;j++)
        {
            for(int x=0;x<n;x++)
            if(a[x][2]==0)
            if(jam[j][0]<a[x][0]  && jam[j][1]>a[x][0] || jam[j][0]==a[x][0] || jam[j][1]==a[x][1] || jam[j][1]>a[x][1] &&  jam[j][0]<a[x][1] || jam[j][0]>a[x][0] && jam[j][0]<a[j][1])
            {
                cam[nc][0]=a[x][0];
                cam[nc][1]=a[x][1];
                nc++;
                a[x][2]=1;
                count++;
                // System.out.println("aaafff");
            }
        }
        if(nc!=c)
        transferjam();
        else
        check();
    }
    static void transferjam()
    {
        for(;c<nc;c++)
        {
            for(int x=0;x<n ;x++)
            if(a[x][2]==0)
            if(cam[c][0]<a[x][0] && cam[c][1]>a[x][0] || cam[c][0]==a[x][0] || cam[c][1]==a[x][1] || cam[c][1]>a[x][1] && cam[c][0]<a[x][1] || cam[c][0]>a[x][0] && cam[c][1]<a[x][1])
            {
                jam[nj][0]=a[x][0];
                jam[nj][1]=a[x][1];
                nj++;
                a[x][2]=2;
                count++;
                //System.out.println("fff");
            }
        }
        
        if(nj!=j)
        transfercam();
        else
        check();
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        
        StringBuilder str=new StringBuilder("");
        t=sc.nextInt();
        for(tt=1;tt<=t;tt++,count=0,c=0,j=0,nj=0,nc=0)
        {
            n=sc.nextInt();
            a=new int[n][3];
            cam=new int[n][2];
            jam=new int[n][2];
            for(k=0;k<n;k++)
            {
                a[k][0]=sc.nextInt();
                a[k][1]=sc.nextInt();
                a[k][2]=0;
            }
            k=0;
            while(count<n && !imp)
            {
                
                if(a[k][2]==0)
                {
                    
                    a[k][2]=1;
                    cam[nc][0]=a[k][0];
                    cam[nc][1]=a[k][1];
                    nc++;
                    count++;
                    transferjam();
                }
                k++;
            }
            if(imp)
            System.out.println("Case #"+tt+": IMPOSSIBLE");
            else
            {
                for(int p=0;p<n;p++)
                {   
                    if(a[p][2]==1)
                    str.append("C");
                    else
                    str.append("J");
                }
                System.out.println("Case #"+tt+": "+str);
                str=str.delete(0,str.length());

            }
            imp=false;
        }
    }
}