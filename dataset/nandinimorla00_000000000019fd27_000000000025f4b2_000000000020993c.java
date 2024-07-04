import java.util.*;
public class Main{
    public static void main(String args[]) {
int t,n,i,j,s1,s2,s3;
Scanner sc=new Scanner(System.in);
t=sc.nextInt();
int x=1;
while(t-->0)
{
 n=sc.nextInt();
int a[][]=new int[n][n];
s1=0;
s2=0;
s3=0;
for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{
    a[i][j]=sc.nextInt();
if(i==j)
{
s1=s1+a[i][j];
}
}
}
HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();

for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{
    h.put(a[i][j],j);
}
if(h.size()!=n)
{
s2++;
h.clear();
}
h.clear();
}

for(i=0;i<n;i++)
{
    for(j=0;j<n;j++)
    {
       h1.put(a[j][i],j);
    }
//System.out.println(h1.keySet());
    if(h1.size()!=n)
    {
        s3++;
        h1.clear();
    }
      h1.clear();
}



System.out.println("Case #"+x+": "+s1+" "+s2+" "+s3);}

x++;
}
}








