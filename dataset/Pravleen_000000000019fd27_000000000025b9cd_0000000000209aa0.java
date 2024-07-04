import java.util.*;
class Solution{

static boolean trace(int r,int c){
for(int i=1;i<=r;i++)
{
	if((i*r)==c)
		return true;
			
}
return false;
}
static void makeMatrix(int r,int c)
{
	int matrix[][]=new int[r][r];
	int m=c/r;
	System.out.println(m);
	for(int i=0;i<r;i++)
	{
		for(int j=0;j<r;j++)
		{
			if(i==j){
			matrix[i][j]=m;
			}
		
		}
	}
		matrix[0][1]=1;
		matrix[0][2]=3;
		matrix[1][0]=1;
		matrix[1][2]=3;
		matrix[2][0]=1;
		matrix[2][1]=3;
		for(int a=0;a<r;a++)
	{
		for(int b=0;b<r;b++)
		{
			System.out.print(matrix[a][b]+" ");
		}
		System.out.println();
	}

		
	}
	
public static void main(String args[]) {
Scanner s = new Scanner(System.in);
int t;
int ar[]=new int[2];
t=s.nextInt();
for (int a=0;a<t;a++)
{
	for(int j=0;j<=1;j++)
		ar[j]=s.nextInt();
	if(trace(ar[0],ar[1]))
	{
		System.out.println("Case #"+(a+1)+": POSSIBLE");
		makeMatrix(ar[0],ar[1]);
	}
	else
	{
		System.out.println("Case #"+(a+1)+": IMPOSSIBLE");
	}
	
}
}
}
