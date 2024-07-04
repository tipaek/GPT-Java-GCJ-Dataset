import java.util.*;
public class Solution
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=1;l<=t;l++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            int b[][]=new int[n][2];
            
            for(int i=0;i<n;i++)
            {
                b[i][0]=arr[i][0];
                b[i][1]=arr[i][1];
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-i-1;j++)
                {
                    if(arr[j][0]>arr[j+1][0])
                    {
                        int tmp=arr[j][0];
                        arr[j][0]=arr[j+1][0];
                        arr[j+1][0]=tmp;
                        tmp=arr[j][1];
                        arr[j][1]=arr[j+1][1];
                        arr[j+1][1]=tmp;
                    }
                }
            }
            
            int task_c[]=new int[2];
            int task_j[]=new int[2];
            String order="";
            for(int i=0;i<n;i++)
            {order+=" ";}
         outer:   for(int i=0;i<n;i++)
            {
                int j;
                for(j=0;j<n;j++)
                {
                    if(b[j][0]==arr[i][0]&&b[j][1]==arr[i][1])
                    {
                        
                        break;
                    }
                }
                if(arr[i][0]>=task_c[1])
                {
                    task_c[0]=arr[i][0];
                    task_c[1]=arr[i][1];
                    order=order.substring(0,j)+"C"+order.substring(j+1);
                }
                else if(arr[i][0]>=task_j[1])
                {
                    task_j[0]=arr[i][0];
                    task_j[1]=arr[i][1];
                    order=order.substring(0,j)+"J"+order.substring(j+1);
                }
                else
                {
                    order="IMPOSSIBLE";
                    break outer;
                }
            }
            if(l==t)
            System.out.print("Case #"+l+": "+order);
            else
            System.out.println("Case #"+l+": "+order);
        }
    }
}