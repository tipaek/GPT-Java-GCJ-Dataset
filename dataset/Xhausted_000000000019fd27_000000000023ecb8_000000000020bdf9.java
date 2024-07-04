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
            int[]task_c=new int[2];
            task_c[0]=-1;
            task_c[1]=-1;
            int[]task_j=new int[2];
            task_j[0]=-1;task_j[1]=-1;
            String order="";
            for(int i=0;i<n;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            
  outer:    for(int i=0;i<n;i++)
            {
                if(arr[i][0]>=task_c[1]||arr[i][1]<=task_c[0])
                    {
                       task_c[0]=arr[i][0];
                       task_c[1]=arr[i][1];
                       order+="C";
                    }
                    else if(arr[i][0]>=task_j[1]||arr[i][1]<=task_j[0])
                    {
                        task_j[0]=arr[i][0];
                        task_j[1]=arr[i][1];
                        order+="J"; 
                    }
                    else
                    {
                        order="IMPOSSIBLE";
                        break outer;
                    }
                /*if(task_c[0]==-1&&task_j[0]==-1)
                {
                    task_c[0]=arr[i][0];
                    task_c[1]=arr[i][1];
                    order+="C";
                }
                else if(task_j[0]==-1)
                {
                    task_j[0]=arr[i][0];
                    task_j[1]=arr[i][1];
                    order+="J"; 
                }
                else
                {
                    if(arr[i][0]>=task_c[1])
                    {
                       task_c[0]=arr[i][0];
                       task_c[1]=arr[i][1];
                       order+="C";
                    }
                    else if(arr[i][0]>=task_j[1])
                    {
                        task_j[0]=arr[i][0];
                        task_j[1]=arr[i][1];
                        order+="J"; 
                    }
                    else
                    {
                        order="IMPOSSIBLE";
                        break outer;
                    }
                }*/
            }
            System.out.println("Case #"+l+": "+order);
        }
        
    }
}