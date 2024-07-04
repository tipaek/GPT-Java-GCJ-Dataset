import java.io.*;
import java .util.*;
public class Solution {
    int t;
    int n;
    int arr[][];
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        for(int c=1;c<=t;c++ )
        {
            String s;
            StringTokenizer st;
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];

            for(int i=0;i<n;i++)
            {
                s=br.readLine();
                st=new StringTokenizer(s);
                for(int j=0;j<n;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
            display(c);
        }

    }
    void display(int c)
    {
        int cr=0,cc=0,s=0;

        int temp[][]=new int[n][n];
        int temp1[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                temp[i][arr[i][j]-1]++;
                temp1[arr[i][j]-1][j]++;
                if (i==j)
                {
                    s=s+arr[i][j];
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            int k=0;
            int k1=0;
            for(int j=0;j<n;j++)
            {
                if(temp[i][j]!=1&& k==0) {
                    cr++;
                    k=1;
                }
                if(temp1[j][i]!=1&&k1==0)
                {
                    cc++;
                    k1=1;
                }
            }
        }
        System.out.println("Case #"+c+": "+s+" "+cr+ " "+cc);
    }
    public static void main(String args[])throws IOException
    {
        Solution ob =new Solution();
        ob.input();

    }
}
