import java.util.*;
class Arrays
{
public static void main (String args[])
{
Scanner s1=new Scanner(System.in);
int s=0,r=0,c=0;boolean e=true,f=false;
int T=s1.nextInt();//to Input the number of test cases
if(T>=1&&T<=100)//checking the validity of test cases
{
Outer:
for(int n=1;n<=T;n++)
{
int N=s1.nextInt();//to input the size of the matrix
int M[][]=new int[N+1][N+1];//Array
if(N>=2&&N<=100)//checking condition for size
{
for(int m=1;m<=N;m++)//taking input of the elements from the user
{
for(int k=1;k<=N;k++)
{
M[m][k]=s1.nextInt();
}//end of mth loop
}//end of kth loop
s=0;
for(int i=1;i<=N;i++)//taking the sum of the diagonal of the matrix
s=s+M[i][i];
r=0;
for(int j=1;j<=N;j++)
{f=true;
for(int l=1;l<N;l++)
{
if(M[j][l]==M[j][l+1]&&f==true)//checking for repeated elements
r=r+2; 
if(r>2)
f=false;
}//end of lth loop
if(r!=0)//checking the printing condition of the number of rows in the array
break;
}//end of jth loop
/*The counting of repeated elements in rows and columns are possible with just 
two for loop but I choose to take both rows and columns seperately to avoid 
any kind of confusion...**/
c=0;
for(int a=1;a<=N;a++)
{e=true;
for(int b=1;b<N;b++)
{
if(M[b][a]==M[b+1][a]&&e==true)
c=c+2;
if(c>2)
e=false;
}//end of bth loop
if(c!=0) 
break;
}//end of ath loop
System.out.println(s+" "+r+" "+c);
}//end of size condition if statement
else
break Outer;
}//end of nth loop for test condition
}//end of if statement
}//end of main function
}//end of class