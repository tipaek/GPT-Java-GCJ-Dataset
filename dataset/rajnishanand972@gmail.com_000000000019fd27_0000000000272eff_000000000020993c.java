import java.util.*;
class Main
{
    public static int countIdenticalRows(int arr[][],int n) 
    { 
  
        int count = 0; 
        for(int i=0;i<n;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(j!=k)
                    {
                    if(arr[i][j]==arr[i][k])
                    {
                        count++;
                        c++;
                        break;
                    }
                    }
                }
                if(c!=0 || j==n-2)
                {
                    c=0;
                    break;
                }
            }
        }
        
        return count; 
    } 
    public static int countIdenticalColumn(int arr[][],int n) 
    { 
  
        int count = 0; 
  
        for (int i = 0; i < n; i++) 
        { 
            int c=0;
              for (int j = 0; j < n; j++) 
              { 
                  for(int k = 0;k<n;k++)
                  {
                      if(j!=k)
                      {
                          if(arr[j][i]==arr[k][i])
                          {
                              count++;
                              c++;
                              break;
                          }
                      }
                  }
                  if(c!=0 || j==n-2)
                  {
                      c=0;
                      break;
                  }
              }
        }
        return count; 
    } 
   public static void main(String [] args) 
    {
     Scanner kb = new Scanner(System.in);
     int t = kb.nextInt();
     for(int q=1;q<=t;q++)
       {
        int n = kb.nextInt();
        int arr[][] = new int[n][n];
        int sum=0;
        for(int j=0;j<n;j++)
         {
          for(int k=0;k<n;k++)
           {
             arr[j][k] = kb.nextInt();
            }
          }
        for(int j=0;j<n;j++)
         {
          for(int k=0;k<n;k++)
           {
             if(j==k)
              {
                sum = sum + arr[j][k];
               }
            }
          }
        int ans = countIdenticalRows(arr,n);
        int ans1 = countIdenticalColumn(arr,n);

    System.out.println("Case #"+q+":"+" "+sum+" "+ans+" "+ans1);

}
}
}