import java.lang.*;
import java.util.*;
class Meenuu
{
public static void main (String args[])
{
Scanner s1=new Scanner(System.in);
int s=0,r=0,c=0;int p=0,k;
int T=s1.nextInt();
for(int n=1;n<=T;n++)
{
int N=s1.nextInt();
int M[][]=new int[N][N];
for(int m=0;m<N;m++)
{
for(k=0;k<N;k++)
{
M[m][k]=s1.nextInt();
}
}
s=0;
for(int i=0;i<N;i++)
s=s+M[i][i];
r=0;c=0;
Outerr:
for(int j=0;j<N;j++)
{
for(int l=0;l<N;l++)
{
p=M[j][l];
for(k=0;k<N;k++)
{
if(p==M[j][k])
++r;
if(p==M[k][j])
++c;
}
if(r>=2||c>=2)
break Outerr;
}
}
System.out.println("Case #"+n+": "+s+" "+r+" "+c);
}
}
}