import java.util.Scanner;
class Solution
{
  public static void main(String ar[])
  {
    int t=0,k=0,r=0,c=0,n=0,t1=0,q=0;
    int mn[][];
    Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    while(t--!=0)
    {
      t1=t1+1;
      n=sc.nextInt();
      mn=new int[n][n];
      for(int x=0;x<n;x=x+1)
      {
        for(int y=0;y<n;y=y+1)
        {
           mn[x][y]=sc.nextInt();        
        }
      }
      for(int x=0;x<n;x=x+1)
      {
        k=k+mn[x][x];
      }
      for(int x=0;x<n;x=x+1)
      {
        for(int y=0;y<n-1;y=y+1)
        {
         for(int z=y+1;z<n;z=z+1)
         {
            if(mn[x][y]==mn[x][z])
            {
               r=r+1;
               q=1;
               break;
            }
         }
         if(q==1)
         {
             q=0;
             break;
         }
        }
      }
      for(int x=0;x<n;x=x+1)
      {
        for(int y=0;y<n-1;y=y+1)
        {
         for(int z=y+1;z<n;z=z+1)
         {
            if(mn[y][x]==mn[z][x])
            {
               c=c+1;
               q=1;
               break;
            }
         }
         if(q==1)
         {
             q=0;
             break;
         }
        }
      }
      System.out.println("Case #"+t1+": "+k+" "+r+" "+c);
      k=0;
      r=0;
      c=0;
    }
  }
}