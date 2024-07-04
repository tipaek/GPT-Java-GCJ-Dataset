import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
public static void main(String[] args)
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int n=0,i=0,j=0,cases=0,k=0,r=0,c=0;
int arr[][];
String s=" ";
String ss[]=null;

try
{

cases=Integer.parseInt(br.readLine().trim());
StringBuffer sb=new StringBuffer();
for(c=0;c<cases;c++)
{

int []row;
int []col;
int rr=0,cc=0;
int g=0;
int maxrowIndex=-1;
int maxrow=0;
int maxcolIndex=-1,maxcol=0;
int x=0;
n=Integer.parseInt(br.readLine().trim());
arr=new int[n][n];
for(i=0;i<n;i++)
{
x=0;
s=br.readLine().trim();
ss=s.split(" ");
row=new int[n];
for(j=0;j<n;j++)
{
x=arr[i][j]=Integer.parseInt(ss[j]);

row[x-1]++;
if(row[x-1]>=2)
{
g=1;

}

}
if(g==1) rr++;
g=0;
}

k=0;
g=0;
for(j=0;j<n;j++)
{
k+=arr[j][j];
col=new int[n];
for(i=0;i<n;i++)
{
x=arr[i][j];
col[x-1]++;
if(col[x-1]>=2)
{
g=1;
}

}
if(g==1) cc++;
g=0;
}

sb.append("Case #"+(c+1)+": "+k+" "+rr+" "+cc+"\n");

}//caseEnd
System.out.print(sb.toString());
}catch(IOException e)
{
e.printStackTrace();
}

}
}

