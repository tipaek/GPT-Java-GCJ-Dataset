import java.util.*;
class Solution
{
public static void main(String Args[])
{
  int n=2;
  int c=0;
   int z=0;
  char t[] = new char[n];
  int a[][] = new int[n][2];
  Scanner sc=new Scanner(System.in);
  int T=sc.nextInt();
  for(int l=0;l<T;l++)
  {
  for(int i=0;i<n;i++)
  {
      for(int j=0;j<2;j++)
      {
          a[i][j]=sc.nextInt();
          t[i]='a';
      }
  }
  t[0]='J';
    for(int i=0;i<1;i++)
  {
       for(int j=i+1;j<n;j++)
       {
        
        if(a[j][0]>=a[i][1])
        {
            t[j]='J';
           
        }
        if(a[i][0]>=a[j][1])
        {
            t[j]='J';
        }
        else if(c==0)
        {
            t[j]='C';
            c++;
        }
        else{
            for(int k=0;k<n;k++)
            {
                if(t[k]=='C')
                {
                    if(a[j][0]>=a[k][1] && t[j]=='a')
                    {
                        t[j]='C';
                        c++;
                    }
                    else if(a[k][0]>=a[j][1] && t[j]=='a')
                    {
                        t[j]='C';
                        c++;
                    }
                }
            }
        }
       }}
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
      }}
      else{
          System.out.print("IMPOSSIBLE");
      }
  }
}}