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
            int task_c[][]=new int[n][2];
            int task_j[][]=new int[n][2];
            int fc,fj,cc=0,cj=0;
            String order="";
         outer:   for(int i=0;i<n;i++)
            {
                fc=1;fj=1;
                for(int j=0;j<cc;j++)
                {
                    if(!(arr[i][0]>=task_c[j][1]||arr[i][1]<=task_c[j][0]))
                    {
                        fc=0;break;
                    }
                }
                if(fc==0){
                for(int j=0;j<cj;j++)
                {
                    if(!(arr[i][0]>=task_j[j][1]||arr[i][1]<=task_j[j][0]))
                    {
                        fj=0;break;
                    }
                }
                }
                if(fc==1)
                {
                    task_c[cc][0]=arr[i][0];
                    task_c[cc][1]=arr[i][1];
                    cc+=1;
                    order+="C";
                }
                else if(fj==1)
                {
                    task_j[cj][0]=arr[i][0];
                    task_j[cj][1]=arr[i][1];
                    cj+=1;
                    order+="J";
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