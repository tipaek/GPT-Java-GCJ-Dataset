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
            int[][]task_c=new int[n][2];
            int[][]task_j=new int[n][2];
            int ctr_j=0,ctr_c=0,flag_j=1,flag_c=1;
            String order="";
            for(int i=0;i<n;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            
  outer:    for(int i=0;i<n;i++)
            {   flag_j=1;flag_c=1;
                for(int j=0;j<ctr_c;j++){
                    if(!(arr[i][0]>=task_c[j][1]||arr[i][1]<=task_c[j][0]))
                    {
                        flag_c=0;break;
                    }
                }
                for(int j=0;j<ctr_j;j++){
                    if(!(arr[i][0]>=task_j[j][1]||arr[i][1]<=task_j[j][0]))
                    {
                        flag_j=0;break;
                    }
                }
                    if(flag_c==1)
                    {
                       task_c[ctr_c][0]=arr[i][0];
                       task_c[ctr_c][1]=arr[i][1];
                       order+="C";
                       ctr_c++;
                    }
                    else if(flag_j==1)
                    {
                        task_j[ctr_j][0]=arr[i][0];
                        task_j[ctr_j][1]=arr[i][1];
                        order+="J";
                        ctr_j++;
                    }
                    else
                    {
                        order="IMPOSSIBLE";
                        break outer;
                    }
                
            }
            System.out.println("Case #"+l+": "+order);
        }
        
    }
}