import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      for(int l=1;l<=t;l++)
      {
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        int tr=0,nr=0,nc=0;
        for(int i=0;i<n;i++)
        {
        for(int j=0;j<n;j++)
           { a[i][j]=sc.nextInt();
           if(i==j)
           tr+=a[i][j];
           }
           if(isRepeated(a[i]))
           nr++;
        }
        for(int i=0;i<n;i++)
        {
            int column[]=new int[n];
            for(int k=0;k<n;k++)
            column[k]=a[k][i];
            if(isRepeated(column))
            nc++;
        }
        print(l,tr,nr,nc);
      }
    }
    static boolean isRepeated(int a[])
    {
        int n=a.length;
        int freq[]=new int[n+1];
      for(int i=0;i<n;i++)
      {
         freq[a[i]]++;
         if(freq[a[i]]>1)
         return true;
      }
    return false;
    }
    static void print(int i,int a,int b,int c)
    {
        System.out.println("Case #"+i+": "+a+" "+b+" "+c);
    }
}
