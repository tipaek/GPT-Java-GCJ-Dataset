import java.util.*;
class Main
{
    public static void main(String[] args)
    {
       Scanner s=new Scanner(System.in);
       int t=s.nextInt();
       for(int i=0;i<t;i++)
       {
           int sum=0,r=0,c=0;
           int n=s.nextInt();
           int[][] a=new int[n][n];
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   a[j][k]=s.nextInt();
               }
           }
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   if(j==k)
                   {
                       sum=sum+a[j][k];
                   }
               }
           }
           int count=0,count1=0;
           for(int j=0;j<n;j++)
           {
               HashSet<Integer> hs=new HashSet<>();
               HashSet<Integer> hsa=new HashSet<>();
               for(int k=0;k<n;k++)
               {
                   hs.add(a[j][k]);
                   hsa.add(a[k][j]);
               }
               if(hs.size()<n)
                   count++;
               if(hsa.size()<n)
                   count1++;
           }
           System.out.println(sum+" "+count+" "+count1);
       }
    }
}