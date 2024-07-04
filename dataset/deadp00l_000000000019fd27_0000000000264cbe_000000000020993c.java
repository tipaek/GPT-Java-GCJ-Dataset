import java.io.*;
import java.util.*;
class aa
{
public static void main(String args[])throws IOException
{
BufferedReader hp =new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(hp.readLine());
for(int q=1;q<=t;q++)
{
int n=Integer.parseInt(hp.readLine());
int a[][]=new int[n][n];
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
a[i][j]=Integer.parseInt(hp.readLine());
}
}
int ps=0,rs=0,cs=0;
for(int w=0;w<n;w++)
{
ps=ps+a[w][w];
}
for(int x=1;x<=n;x++)
{
for(int y=0;y<n;y++)
{int c=0;
for(int z=0;z<n;z++)
{
if(a[y][z]==x)
c++;
}
if(c!=1&& c>rs)
rs=c;
}
}
for(int x1=1;x1<=n;x1++)
{
for(int y1=0;y1<n;y1++)
{int c1=0;
for(int z1=0;z1<n;z1++)
{
if(a[z1][y1]==x1)
c1++;
}
if(c1!=1&& c1>cs)
cs=c1;
}
}

System.out.println("Case #"+q+": "+ps+" "+rs+" "+cs);
}
}}