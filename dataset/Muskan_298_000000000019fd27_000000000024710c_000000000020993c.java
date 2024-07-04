import java.util.*;
import java.io.*;
class Solution
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
while(t>0)
{ int s=1;
int n=sc.nextInt();
int a[][]=new int[n][n];
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
a[i][j]=sc.nextInt();
}
}
int sum=0;
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
if(i==j)
sum=sum+a[i][j];
}
}
int row=0;
for(int i=0;i<n;i++)
{
Set<Integer> list=new HashSet<Integer>();
for(int j=0;j<n;j++)
{
    list.add(a[i][j]);
}
if(list.size()<n)
row++;
}
int col=0;
for(int i=0;i<n;i++)
{
Set<Integer> list=new HashSet<Integer>();
for(int j=0;j<n;j++)
{
list.add(a[j][i]);
}
if(list.size()<n)
col++;
}
System.out.println("Case #"+s+": "+sum+" "+row+" "+col);
s++;
t--;
    
}
}
}




