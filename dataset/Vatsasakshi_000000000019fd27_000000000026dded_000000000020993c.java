import java.util.*;
public class Solution{
public static void main(String[] args)
{
   Scanner s=new Scanner(System.in);
   int t=s.nextInt();
   int tst=1;
   while(t-->0)
   {
        int n=s.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=s.nextInt();
            }
        }
        long sum=0;
        int row=0;
        int col=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i][i];
        }
        for(int i=0;i<n;i++)
        {
            HashMap<Integer,Integer> h=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                if(!h.containsKey(arr[i][j]) && arr[i][j]>=1 && arr[i][j]<=n)
                {
                    h.put(arr[i][j],1);
                }
                else
                {
                    row++;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            HashMap<Integer,Integer> h=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                if(!h.containsKey(arr[j][i]) && arr[j][i]>=1 && arr[j][i]<=n)
                {
                    h.put(arr[j][i],1);
                }
                else
                {
                    col++;
                    break;
                }
            }
        }
        System.out.println("Case #"+tst+": "+sum+" "+row+" "+col);
        tst++;
   }    
   }
  } 