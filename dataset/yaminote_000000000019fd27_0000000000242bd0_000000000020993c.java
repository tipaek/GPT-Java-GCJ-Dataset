import java.util.*;
public class Solution {
    public static void main(String[] args) {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      int f=1;
      while(t-->0)
      {
        int n=in.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
          {
            arr[i][j]=in.nextInt();
          }
        }
        int r=0;
        for(int i=0;i<n;i++)
        {
          HashSet<Integer> set=new HashSet<>();
          for(int j=0;j<n;j++)
          {
            set.add(arr[i][j]);
          }
          if(set.size()<n)
          r++;
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
          HashSet<Integer> set=new HashSet<>();
          for(int j=0;j<n;j++)
          {
            set.add(arr[j][i]);
          }
          if(set.size()<n)
          c++;
        }
        int s=0;
        for(int i=0;i<n;i++)
        s+=arr[i][i];
        System.out.println("Case #"+f+": "+s+" "+r+" "+c);
        f++;
      }
    }
  }
