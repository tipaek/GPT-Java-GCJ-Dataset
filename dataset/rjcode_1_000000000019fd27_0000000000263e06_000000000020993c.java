import java.io.*;
import java.util.*;
class Solution
{
public static void main(String[] args) 
{
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
        int n=sc.nextInt();

        int arr[][]=new int[n][n];
        for(int j=0;j<n;j++)
            for(int k=0;k<n;k++)
            arr[j][k]=sc.nextInt();
            int r=0;
            int trace=0;
            for(int j=0;j<n;j++)
                trace+=arr[j][j];
            for(int j=0;j<n;j++)
            {
                HashMap<Integer,Integer>hm=new HashMap<Integer, Integer>();

                for(int k=0;k<n;k++)
                {
                    if(hm.get(arr[j][k])!=null)
                    {
                        r++;
                        break;
                    }
                    else
                        hm.put(arr[j][k],1);
                }
               }

            int c=0;
            for(int j=0;j<n;j++)
            {
                HashMap<Integer,Integer>hm=new HashMap<Integer, Integer>();
                for(int k=0;k<n;k++)
                {
                    if(hm.get(arr[k][j])!=null)
                    {
                        c++;
                        break;
                    }
                    else
                        hm.put(arr[k][j],1);
                }
            }

            StringBuilder sb=new StringBuilder("");
            sb.append("Case #"+(i+1)+": "+trace+" "+r+" "+c);
            System.out.println(sb);


    }
}
}