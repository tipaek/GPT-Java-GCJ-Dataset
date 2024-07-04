import java.util.*;
import java.io.*;
 class Solution{
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=in.nextInt();
		for(int te=0;te<t;te++){
			int n=in.nextInt();
			int k=in.nextInt();
			if(k%n==0&&k/n<=n)
			System.out.println("Case #"+(te+1)+": POSSIBLE");
			else {
		System.out.println("Case #"+(te+1)+": IMPOSSIBLE");
		continue;}
	int[][] a=new int[n][n];
int prev=k/n;
for(int i=0;i<n;i++)
a[i][i]=prev;
int j=0;
for(int i=0;i<n;i++){
	j=(i+1)%n;
	prev=a[i][i];
	while(j!=i){
		if(++prev>n)
		prev=prev%n;
		a[j][i]=prev;
		
		j=(++j)%n;
		
		}
		
		
			}
		for(int i=0;i<n;i++){
			for( j=0;j<n;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.print("\n");}
	}
}}