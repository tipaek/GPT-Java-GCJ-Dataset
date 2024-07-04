import java.util.*;

public class Solution {
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int t=s.nextInt();
       while(t-->0)
       {
           int n=s.nextInt();
           int arr[][]=new int[n][n];
           int sum=0;
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   arr[i][j]=s.nextInt();
                   if(i==j)
                   {
                       sum=sum+arr[i][j];
                   }
               }
           }
           HashMap<Integer,Integer>map=new HashMap<>();
            HashMap<Integer,Integer>map1=new HashMap<>();
           int countrow=0;
           int countcolumn=0;
            for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                  if(!map.containsKey(arr[i][j]))
                  {
                      map.put(arr[i][j],1);
                  }
                  else
                  {
                      countrow++;
                      break;
                  }
               }
               map.clear();
           }
            for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                  if(!map1.containsKey(arr[j][i]))
                  {
                      map1.put(arr[j][i],1);
                  }
                  else
                  {
                      countcolumn++;
                      break;
                  }
               }
               map1.clear();
           }
           System.out.println(sum+" "+countrow+" "+countcolumn);
       }
       
    }
}
