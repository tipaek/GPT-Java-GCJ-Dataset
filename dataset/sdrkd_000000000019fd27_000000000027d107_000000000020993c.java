import java.util.Scanner;
class Vestigium
{public static int ap(int n)
{
    return (n*(n+1))/2;
}
    public static void main(String args[])throws Exception
{int t,n,i,j,k,tr=0,r=0,c=0,s=0;
Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    k=1;
    while(k++<=t)
    {tr=0;
       n=sc.nextInt(); 
       int m[][]=new int[n][n];
       for(i=0;i<n;i++)
       {s=0;
           for(j=0;j<n;j++)
           {
               m[i][j]=sc.nextInt();
               s+=m[i][j];
             if(i==j)
               tr+=m[i][j];
           }
           if(s!=ap(n))
           r++;
           
       }
       for(i=0;i<n;i++)
       {s=0;
           for(j=0;j<n;j++)
           {
           
               s+=m[j][i];
         
           }
           if(s!=ap(n))
           c++;
           
       }
       System.out.println("Case #"+k+" "+tr+" "+r+" "+c);
       
    }
}
}