import java.util.*;
public class Solution
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
while(t>0)
{
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
 int count=0;int row=0;
for(int i=0;i<n;i++)
{
Set<Integer> list=new HashSet<Integer>();
for(int j=0;j<n;j++)
{
if(list.contains(a[i][j]))
count++;
list.add(a[i][j]);
}
if(count>0)
row++;
}
int count1=0;int col=0;
for(int i=0;i<n;i++)
{
Set<Integer> list=new HashSet<Integer>();
for(int j=0;j<n;j++)
{
if(list.contains(a[j][i]))
count1++;
list.add(a[j][i]);
}
if(count1>0)
col++;
}
System.out.println("Case #"+t+": "+sum+" "+row+" "+col);
t--;
    
}
}
}




