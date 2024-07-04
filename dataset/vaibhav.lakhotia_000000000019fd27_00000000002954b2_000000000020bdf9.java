import java.util.*;
class Solution
{
public static void main(String Args[])
{
  int c=0 , n;
   int z=0;
  
 
  Scanner sc=new Scanner(System.in);
  int T=sc.nextInt();
  for(int l=0;l<T;l++)
  {
      n=sc.nextInt();
      c=0;
      z=0;
       int a[][] = new int[n][2];
      char t[] = new char[n];
  for(int i=0;i<n;i++)
  {
      for(int j=0;j<2;j++)
      {
          a[i][j]=sc.nextInt();
          t[i]='a';
      }
  }
  t[0]='J';
       for(int j=1;j<n;j++)
       {
        
        if(a[j][0]>=a[0][1])
        {
            t[j]='J';
           
        }
        else if(a[0][0]>=a[j][1])
        {
            t[j]='J';
        }
       }
     for(int k=0;k<n;k++)
          {
            if(t[k]=='a' )
            {
                if(c==0)
                 {
                    t[k]='C';
                     c=k;
                 }
                    else if(a[k][0]>=a[c][1] )
                    {
                        t[k]='C';
                        c=k;
                    }
                     else if(a[k][1]<=a[c][0] )
                    {
                        t[k]='C';
                        c=k;
                    }
                    
                }
            }
        
  for(int i=0;i<n;i++)
  {
      if(t[i]=='a')
      {
          z++;
      }
  }
  
   System.out.print("Case #" + (l+1) + ": " );
      if(z==0)
      { 
          for(int i=0;i<n;i++)
        {
      System.out.print(t[i]);
      }
           System.out.println();
      }
      else{
          System.out.print("IMPOSSIBLE");
          System.out.println();
      }
  }
}}