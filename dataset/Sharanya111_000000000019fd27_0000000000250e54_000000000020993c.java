import java.util.*;
class Solution
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int i,j;
    for(i=0;i<t;i++)
    {
      int n =sc.nextInt();
      int[][] a=new int[n][n];
      for(j=0;j<n;j++)
      {
          for(k=0;k<n;k++)
            a[j][k]=sc.nextInt();
      }
      
     
     int countr=0,countc=0;
      for(j=0;j<n;j++)
      {
          ArrayList<Integer> r=new ArrayList<Integer>();
          for(k=0;k<n;k++)
          {
              if(r.contains(a[j][k]))
              {
                  countr++;
                  break;
              }
              else
              r.add(a[j][k]);
          }
      }
    for(j=0;j<n;j++)
      {
          ArrayList<Integer> r=new ArrayList<Integer>();
          for(k=0;k<n;k++)
          {
              if(r.contains(a[k][j]))
              {
                  countc++;
                  break;
              }
              else
              r.add(a[k][j]);
          }

      }
      for(j=0;j<n;j++)
        sum=sum+a[j][j];
        System.out.println("Case #"+i+": "+sum+" "+countr+" "+countc);
    }
    } 
}