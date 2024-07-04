import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            if(n==2)
            {
                if(k==3)
                pw.println("Case #"+(x+1)+": IMPOSSIBLE");
                else
                {
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    if(k==4)
                    {
                        pw.println("2 1");
                        pw.println("1 2");
                    }
                    if(k==2)
                    {
                        pw.println("1 2");
                        pw.println("2 1");
                    }
                }
            }
            else
            {
                if((k%n!=0&&k!=n*(n+1)/2))
                pw.println("Case #"+(x+1)+": IMPOSSIBLE");
                else if(k%n==0)
                {
                    int arr[][]=new int[n+1][n+1];
                    for(int i=1;i<=n;i++)
                    arr[i][i]=k/n;
                    for(int i=1;i<=n;i++)
                    {
                        for(int j=i+1;j<=n;j++)
                        {
                            if(arr[i][j-1]==n)
                            arr[i][j]=1;
                            else
                            arr[i][j]=arr[i][j-1]+1;
                        }
                        for(int j=1;j<=i-1;j++)
                        {
                            if(j==1)
                            {
                                if(arr[i][n]==n)
                                arr[i][1]=1;
                                else
                                arr[i][1]=arr[i][n]+1;
                            }
                            else
                            {
                                if(arr[i][j-1]==n)
                                arr[i][j]=1;
                                else
                                arr[i][j]=arr[i][j-1]+1;
                            }   
                        }
                    }
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    for(int i=1;i<=n;i++)
                    {
                        for(int j=1;j<=n;j++)
                        pw.print(arr[i][j]+" ");
                        pw.println();
                    }
                }
                else
                {
                    int arr[][]=new int[n+1][n+1];
                    for(int i=1;i<n;i++)
                    {
                        arr[1][i]=i+1;
                    }
                    arr[1][n]=1;
                    for(int i=2;i<=n;i++)
                    {
                        for(int j=1;j<=n;j++)
                        {
                            if(arr[i-1][j]==n)
                            arr[i][j]=1;
                            else
                            arr[i][j]=arr[i-1][j]+1;
                        }
                    }
                    pw.println("Case #"+(x+1)+": POSSIBLE");
                    for(int i=1;i<=n;i++)
                    {
                        for(int j=1;j<=n;j++)
                        pw.print(arr[i][j]+" ");
                        pw.println();
                    }
                }
            }
        }
        pw.flush();
        pw.close();
    }
}