import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Stack;
import java.util.Arrays;
public class codeforces
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out); 
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++)
        {
            int n=Integer.parseInt(br.readLine());
            boolean loc[][]=new boolean[n+1][n+1];
            boolean loc1[][]=new boolean[n+1][n+1];
            boolean row[]=new boolean[n+1];
            boolean col[]=new boolean[n+1];
            int a[][]=new int[n+1][n+1];
            //Arrays.fill(a,0);Arrays.fill(row,false);Arrays.fill(col,false);Arrays.fill(loc,false);
            for(int i=1;i<=n;i++)
            {
                String s[]=(br.readLine()).split(" ");
                for(int j=1;j<=n;j++)
                    a[i][j]=Integer.parseInt(s[j-1]);
            }
            int k=0,r=0,c=0;
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(row[i]==false)
                    {
                        if(loc[i][a[i][j]]==true)
                        {    r++;row[i]=true;}
                        else
                        {    loc[i][a[i][j]]=true;}
                    }
                    if(col[j]==false)
                    {
                        if(loc1[j][a[i][j]]==true)
                        {    c++;col[j]=true;}
                        else
                        {    loc1[j][a[i][j]]=true;}
                    }
                    if(i==j)
                        k+=a[i][j];
                }
            }
            pw.println("Case #"+tc+": "+k+" "+r+" "+c);
        }
        pw.flush();
    }
}

