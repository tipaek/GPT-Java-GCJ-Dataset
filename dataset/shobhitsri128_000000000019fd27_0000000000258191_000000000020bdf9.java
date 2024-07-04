import java.util.*;
class Parenting
{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    for(int t=0;t<T;t++)
    {
      int N=sc.nextInt();
      int arr[][]=new int[N][2];
      for(int i=0;i<N;i++)
      {
         arr[i][0]=sc.nextInt();
         arr[i][1]=sc.nextInt();
      }
      System.out.println("Case #"+(t+1)+": "+getSchedule(arr,N));
    }
  }
  public static String getSchedule(int arr[][],int N)
  {
    char c[]=new char[N];
    int maxC=arr[0][1];
    int minC=arr[0][0];
    c[0]='C';
    int flag=0;
    for(int i=1;i<N;i++)
    {
      if(arr[i][0]>=maxC||arr[i][1]<=minC)
      {
        c[i]='C';
        if(arr[i][1]>maxC)
          maxC=arr[i][1];
        if(arr[i][0]<minC)
          minC=arr[i][0];
        
      }
      else if(flag==0)
      {
        flag=i;
      }

    }
    if(flag!=0)
    {
      int maxJ=arr[flag][1];
      int minJ=arr[flag][0];
      c[flag]='J';
      for(int i=flag+1;i<N;i++)
      {
        if(c[i]!='C')
        {
          if(arr[i][0]>=maxJ||arr[i][1]<=minJ)
          {
            c[i]='J';
            if(arr[i][1]>maxJ)
              maxJ=arr[i][1];
            if(arr[i][0]<minJ)
              minJ=arr[i][0];
          }
        }
      }
  }
    String result="";
    for(int i=0;i<N;i++)
    {
      if((int)c[i]==0)
      {
        return "IMPOSSIBLE";
      }
    }
    return new String(c);
  }
}
