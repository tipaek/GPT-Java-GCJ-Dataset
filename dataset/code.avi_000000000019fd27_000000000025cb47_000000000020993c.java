import java.io.*;
import java.util.*;
import java.lang.*;
class vestigium
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int t,i,testc,j,n,trsum,nrow,ncol;
        t=sc.nextInt();
        if(t>100&&t<1)
        {
            System.exit(0);
        }
        for(testc=0;testc<t;testc++)
        {
            n=sc.nextInt();
            if(n>100&&n<2)
           {
            System.exit(0);
            }
            int [][]arr=new int[n][n];
         for(i=0;i<n;i++)
         {
            for(j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]>n&&arr[i][j]<1)
               {
                System.exit(0);
               }
            }
         }
    
        trsum=trace(arr,n);
        nrow=repeatedr(arr,n);
        ncol=repeatedc(arr,n);
        System.out.println("Case #"+testc+": "+trsum+" "+nrow+" "+ncol);
       }
    }
    public static int trace(int [][]arr,int t)
    {
        int temp=0,i,j;
        for(i=0;i<t;i++)
        {
            temp=temp+arr[i][i];
        }
        return temp;
    }
    public static int repeatedr(int [][]arr,int t)
    {
        int i,c,j,p,repe=0;
        int []k=new int[t];
        
        for(i=0;i<t;i++)
         {
             for(c=0;c<t;c++)
            {
              k[c]=0;
            }
            for(j=0;j<t;j++)
            {
                p=arr[i][j];
                k[p-1]++;
                if(k[p-1]>1)
                {
                    repe++;
                    break;
                }
            }
            
         }
         return repe;
    }
    public static int repeatedc(int [][]arr,int t)
    {
        int i,c,j,p,repe=0;
        int []k=new int[t];
        
        for(i=0;i<t;i++)
         {
             for(c=0;c<t;c++)
            {
              k[c]=0;
            }
            for(j=0;j<t;j++)
            {
                p=arr[j][i];
                k[p-1]++;
                if(k[p-1]>1)
                {
                    repe++;
                    break;
                }
            }
            
         }
         return repe;
    }
    
}