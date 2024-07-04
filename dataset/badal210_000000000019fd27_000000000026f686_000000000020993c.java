import java.util.*;
class Main
{
public static void main(String gg[])
{
int t,n,nums;
int arr[][];
int r,c,sum,num;
Scanner sc=new Scanner(System.in);
t=sc.nextInt();
while(t>0)
{
sum=0;
r=0;
c=0;
n=sc.nextInt();
arr=new int[n][n];
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
num=sc.nextInt();
arr[i][j]=num;    
if(i==j) sum+=arr[i][j];
}
}
for(int p=0;p<n;p++)
{
num=arr[0][p];
nums=arr[p][0];
for(int q=p+1;q<n;q++)
{
if(num==arr[p][q]) {r++;break;}
if(nums==arr[q][p]) {c++;break;}
}
}
System.out.println("Case #"+t+":"+" "+sum+" "+r+" "+c);
t--;    
}
}
}