import java.util.Scanner;
class Solution
{
 public static void main(String ar[])
 {
   Scanner sc=new Scanner(System.in);
   int t=0,n=0,k=0,temp=0,q=0,t1=0;
   String out="";
   t=sc.nextInt();
   while(t--!=0)
   {
     n=sc.nextInt();
     k=sc.nextInt();
     out="IMPOSSIBLE";
     temp=0;
     if(n!=2)
     {
        t1=t1+1;
       for(int x=1;x<=n;x=x+1)
       {
         temp=temp+x;
       }
       if(temp==k)
       {
        out="POSSIBLE";
        q=1;
       }
       if(q!=1)
       {
        for(int x=1;x<=n;x=x+1)
        { 
         if(x*n==k)
         {
          out="POSSIBLE";
          q=1;
         }
        }
       }
       if(q!=1&&n!=3)
       {
         for(int x=1;x<=n;x=x+1)
         {
            temp=0;
           for(int y=1;y<=n;y=y+1)
           {
              if(y==x)
              {
                  continue;
              }
              temp=(n-2)*x+2*y;
              if(temp==k)
              {
                  q=1;
                  out="POSSIBLE";
                  break;
              }
           }
           if(q==1)
           {
               break;
           }
         }
       }
     }
     else
     {
        if(k==4||k==2)
        {
            out="POSSIBLE";
        }
     }
     System.out.println("Case #"+t1+" "+out);
     out="";
   }
 }
}