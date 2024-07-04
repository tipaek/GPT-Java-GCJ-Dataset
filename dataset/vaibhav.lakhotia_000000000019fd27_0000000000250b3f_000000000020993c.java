import java.util.*;
class Solution
{
public static void main(String Args[])
{
int T , N , t=0 , c=0 , r=0;
Scanner sc = new Scanner(System.in);
T=sc.nextInt();
if(T>=1 && T<=100)
{
for(int i=0;i<T;i++)
{
c=0; r=0 ; t=0;
N=sc.nextInt();
if(N>=2 && N<=100)
{
int M[][]=new int[N][N];
for(int j=0;j<N;j++)
{
for(int k=0;k<N;k++)
{
M[j][k]=sc.nextInt();
if(j==k)
{
t=M[j][k] + t ;
}
}
}
for(int j=0;j<N;j++)
{
for(int k=0;k<N;k++)
{
for(int l=k+1;l<N;l++)
{
if(M[j][k]==M[j][l])
{
    c++;
}
if(M[k][j]==M[l][j])
{
r++;
}
}
}
}
if(c>N)
{
    c=N;
}
if(r>N)
{
    r=N;
}
System.out.println();
System.out.print("Case #" + (i+1) + ": " + t);
System.out.print(" "+c);
System.out.print(" "+r);
}
}}}
}