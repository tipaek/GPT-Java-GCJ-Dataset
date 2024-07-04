import java.util.*;
class Solution
{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=0;t<T;t++)
    {
      int N=sc.nextInt();
      int arr[][]=new int[N][N];
      for(int i=0;i<N;i++)
      {
        for(int j=0;j<N;j++)
        {
          arr[i][j]=sc.nextInt();
        }
      }
      calc(arr,N,t+1);
    }
  }
  public static void calc(int arr[][],int N,int t)
  {

    int c=0,r=0,sum=0;
    for(int i=0;i<N;i++)
    {
      ArrayList<Integer> checkr=new ArrayList<Integer>();
      ArrayList<Integer> checkc=new ArrayList<Integer>();
      for(int j=0;j<N;j++)
      {
        if(!checkr.contains(arr[i][j]))
        {
          checkr.add(arr[i][j]);
        }
        if(!checkc.contains(arr[j][i]))
        {
          checkc.add(arr[j][i]);
        }
        if(i==j)
         sum=sum+arr[i][j];
      }
      if(checkc.size()!=N)
        c++;
      if(checkr.size()!=N)
          r++;
    }
    System.out.println("Case #"+t+": "+sum+" "+r+" "+c);
  }
}
