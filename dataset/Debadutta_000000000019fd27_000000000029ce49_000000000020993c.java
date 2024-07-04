import java.util.*;
class Matrix
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int testcase=sc.nextInt();
while(testcase>0)
{
int n=sc.nextInt();
int []a[]=new int[n][n];
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
a[i][j]=sc.nextInt();
}
}
int c=0;
int m=0;
int con=0;
int h=0;
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
for(int k=j+1;k<n;k++)
{
if(a[j][i]==a[k][i])
{
c++;
}
else if(a[i][j]==a[i][k])
{
con++;
}
}
}
if(c>n)
{
m++;
c=0;
}
else if(c!=0 && c<n){
	m++;
	c=0;
if(con>n){h++;con=0;}
else if(con!=0 && con<n){
	h++;
	con=0;
}
}
}
int t=0;
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
if(i==j)
{
t=t+a[i][j];
}
}
}
System.out.println("case"+" "+"#"+testcase+":"+" "+t+" "+h+" "+m);
testcase--;
}
}
}






