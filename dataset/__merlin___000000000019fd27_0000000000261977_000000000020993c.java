import java.io.*;

class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine()),i;
        StringBuilder sb=new StringBuilder();
        for(i=1;i<=t;i++)
        {
            int n=Integer.parseInt(bu.readLine());
            int j,k,r=0,c=0,sum=0,a[][]=new int[n][n];
            for(j=0;j<n;j++)
            {
                String s[]=bu.readLine().split(" ");
                int count[]=new int[n+1],flag=0;
                for(k=0;k<n;k++)
                {
                    a[j][k]=Integer.parseInt(s[k]);
                    if(j==k) sum+=a[j][k];
                    count[a[j][k]]++;
                    if(count[a[j][k]]>1) flag=1;
                }
                if(flag==1) r++;
            }

            for(j=0;j<n;j++)
            {
                int count[]=new int[n+1],flag=0;
                for(k=0;k<n;k++)
                {
                    count[a[k][j]]++;
                    if(count[a[k][j]]>1) {flag=1; break;}
                }
                if(flag==1) c++;
            }
            sb.append("Case #"+i+": "+sum+" "+r+" "+c+"\n");
        }
        System.out.print(sb);
    }
}
