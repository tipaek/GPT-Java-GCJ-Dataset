import java.util.*;
public class main
{
public static void main (String args[])
{
Scanner s1=new Scanner(System.in);
int s=0,r=0,c=0;int p=0,k;
int T=s1.nextInt();//to Input the number of test case
for(int n=1;n<=T;n++)
{
int N=s1.nextInt();//to input the size of the matrix
int M[][]=new int[N][N];//Array
for(int m=0;m<N;m++)//taking input of the elements from the user
{
for(k=0;k<N;k++)
{
M[m][k]=s1.nextInt();
}//end of mth loop
}//end of kth loop
s=0;
for(int i=0;i<N;i++)//taking the sum of the diagonal of the matrix
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
}//end of jth loop
System.out.println("Case #"+n+": "+s+" "+r+" "+c);
}//end of nth loop for test condition
}//end of main function
}//end of classimport java.util.*;
public class main
{
public static void main (String args[])
{
Scanner s1=new Scanner(System.in);
int s=0,r=0,c=0;int p=0,k;
int T=s1.nextInt();//to Input the number of test case
for(int n=1;n<=T;n++)
{
int N=s1.nextInt();//to input the size of the matrix
int M[][]=new int[N][N];//Array
for(int m=0;m<N;m++)//taking input of the elements from the user
{
for(k=0;k<N;k++)
{
M[m][k]=s1.nextInt();
}//end of mth loop
}//end of kth loop
s=0;
for(int i=0;i<N;i++)//taking the sum of the diagonal of the matrix
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
}//end of jth loop
System.out.println("Case #"+n+": "+s+" "+r+" "+c);
}//end of nth loop for test condition
}//end of main function
}//end of class