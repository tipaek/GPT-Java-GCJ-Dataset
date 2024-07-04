import java.io.*;
import java.util.*;
class vestigium
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
int b[]=new int[n];
for(int z=1;z<=n;z++)
{
b[z-1]=z;
}
int c[]=new int[n];
int d[]=new int[n];
for(int x=0;x<n;x++)
{
int k=0;int p=0;
for(int y=0;y<n;y++)
{
c[y]=a[x][y];
}
Arrays.sort(c);
for(int u=0;u<n;u++)
{
if(c[u]!=b[u])
k++;
}
for(int v=0;v<n;v++)
{
d[v]=a[v][x];
}
Arrays.sort(d);
for(int w=0;w<n;w++)
{
if(d[w]!=b[w])
p++;
}
if(k>0)
rs++;
if(p>0)
cs++;
}
System.out.println("Case #"+q+": "+ps+" "+rs+" "+cs);
}
}}



