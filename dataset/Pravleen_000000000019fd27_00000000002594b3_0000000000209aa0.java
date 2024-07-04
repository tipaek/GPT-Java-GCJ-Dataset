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
	for(int i=0;i<r;i++)
	{
		for(int j=0;j<r;j++)
		{
			if(i==j){
			matrix[i][j]=m;}
		
		if(i!=j){
			int k=r+1;
			for (int b=1;b<=r;b++){
				int temp=k;
				while (temp<=r){
					System.out.print(temp + " ");
					temp++;
				}
				
			for (int a=1;a<k;a++){
				System.out.print(a+" ");
			}
			k--;
			i++;
			j++;
			System.out.println();}
			}	
		}
			
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