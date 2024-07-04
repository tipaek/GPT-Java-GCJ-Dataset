import java.util.*;
public class Main
{
public static void main(String Args[])
{
int T , N , t=0 , c=0 , r=0;
Scanner sc = new Scanner(System.in);
T=sc.nextInt();
for(int i=0;i<T;i++)
{
c=0; r=0 ; t=0;
N=sc.nextInt();
int a[][]=new int[N][N];
for(int j=0;j<N;j++)
{
for(int k=0;k<N;k++)
{
a[j][k]=sc.nextInt();
if(j==k)
{
t=a[j][k] + t ;
}
}
}
for(int j=0;j<N;j++)
{
for(int k=0;k<N;k++)
{
for(int l=k+1;l<N;l++)
{
if(a[j][k]==a[j][l])
{
    c++;
}
else if(a[k][j]==a[l][j])
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
else if(r>N)
{
    r=N;
}
System.out.println();
System.out.print("case# " + (i+1) + " " + t =" ");
System.out.print(" "+c);
System.out.print(" "+r);
}}}