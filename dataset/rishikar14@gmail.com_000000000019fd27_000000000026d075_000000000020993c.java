import java.util.*;
class Solution
{
    public static void main(String []args)
    {
      Scanner s=new Scanner(System.in);
      int t=s.nextInt();
      int []sum=new int[t];
      int []r=new int[t];
      int []c=new int[t];
      for(int i=0;i<t;i++)
      {sum[i]=0;
      r[i]=0;c[i]=0;
          int n=s.nextInt();
          int [][]a=new int[n][n];
          int []b=new int[n+1];
          for(int x=0;x<n;x++)
          {
              for(int y=0;y<n;y++)
              {
                  a[x][y]=s.nextInt();
                  if(x==y)
                  sum[i]+=a[x][y];
              }
          }
         
          for(int x=0;x<n;x++)
          {
              for(int y=0;y<n;y++)
              {
                  if(b[a[x][y]]==1)
                  {
                    r[i]++;
                    break;
                  }
                  b[a[x][y]]=1;
              }
            for(int z=0;z<n+1;z++)
          {
              b[z]=0;
          }
          }
          for(int x=0;x<n;x++)
          {
              for(int y=0;y<n;y++)
              {
                  if(b[a[y][x]]==1)
                  {
                    c[i]++;
                    break;
                  }
                  b[a[y][x]]=1;
              }
              for(int z=0;z<n+1;z++)
          {
              b[z]=0;
          }
          }
          
      }
      for(int x=0;x<t;x++)
          {
              System.out.println("Case #"+(x+1)+": "+sum[x]+" "+r[x]+" "+c[x]);
          }
      
    }
}
