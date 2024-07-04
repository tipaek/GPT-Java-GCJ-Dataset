import java.util.*;

class codejam1{
  public static void main(String[] args)
  {
    Scanner in=new Scanner(System.in);
    int t,n,x,y,z,i,c,flag,flag1;
    int sum1,sum2,sum3;
    int arr[][];
    String res="";
    t=in.nextInt();
    for(i=1;i<=t;i++)
    {
      n=in.nextInt();
      arr=new int[n][n];
      for (y = 0; y < n; y++) 
      {
        for(z=0;z<n;z++)
        {
          arr[y][z]=in.nextInt();
        }  
      }
      sum1=0;
      sum2=0;
      sum3=0;
      flag=0;
      flag1=0;
      for(x=0;x<n;x++)
      {
        sum1+=arr[x][x];
      }
      for(x=0;x<n;x++)
      {
        flag=0;
        for(y=0;y<n-1;y++)
        {
          c=arr[x][y];
          for(z=y+1;z<n;z++)
          { 
            if(c == arr[x][z])
            {
              flag++;
              break;
            }
          }
        }
        if(flag!=0)
        {
          sum2++;
        }
      }
      
      for(x=0;x<n;x++)
      {
        flag1=0;
        for(y=0;y<n-1;y++)
        {
          c=arr[y][x];
          for(z=y+1;z<n;z++)
          { 
            if(c == arr[z][x])
            {
              flag1++;
              break;
            }
          }
        }
        if(flag1!=0)
        {
          sum3++;
        }
      }

      System.out.println("Case #"+i+": "+sum1+" "+sum2+" "+sum3);
    }
  }
}