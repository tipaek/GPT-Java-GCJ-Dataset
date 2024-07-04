import java.util.*;
class a
{
public static void main(String args[])
{
	int r=0,c=0,r1=0,k=0,i,j,c1=0;
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
	for(int l=0;l<t;l++)
	{
int n=sc.nextInt();
String s="",s1="";
int arr[][]=new int[n][n];
for( i=0;i<n;i++)
{
for( j=0;j<n;j++)
{
arr[i][j]=sc.nextInt();
s+=String.valueOf(arr[i][j]);
	//System.out.println(s);
if(s.indexOf(String.valueOf(arr[i][j]))!= s.lastIndexOf(String.valueOf(arr[i][j])))
{
r++;	
}
	if(i==j)
	{
	k+=arr[i][j];	
	}
}
	if(r>0)
		r1++;
s="";
	r=0;
	
}
	String p="";
	for( i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			p+=String.valueOf(arr[j][i]);
			if(p.indexOf(String.valueOf(arr[j][i]))!= p.lastIndexOf(String.valueOf(arr[j][i])))
			   {
				   c++;
			   }
		}
			   if(c>0)
			   c1++;
			   c=0;
		p="";
	}
	System.out.println("Case #"+t+": "+ k+"  "+r1+" "+c1);
	}
}
}