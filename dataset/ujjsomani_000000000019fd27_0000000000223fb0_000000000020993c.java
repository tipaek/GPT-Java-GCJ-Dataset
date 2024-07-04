import java.util.*;
public class Solution{
	
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		int t=in.nextInt();
		int ind=1;
		while(t-->0) {
		
			int n=in.nextInt();
			int a[][]=new int[n][n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=in.nextInt();
			
			
			int r=0;int c=0;int tr=0;
			
		for(int i=0;i<n;i++)
		{tr=tr+a[i][i];
			HashSet<Integer>hs=new HashSet<>();
			
			for(int j=0;j<n;j++) {
				
				if(hs.contains(a[i][j]))
				{
					r++;
					break;
				}
				
				hs.add(a[i][j]);
			}
			
			
			
			
			
		}
		
		for(int i=0;i<n;i++)
		{
			HashSet<Integer>hs=new HashSet<>();
			
			for(int j=0;j<n;j++) {
				
				if(hs.contains(a[j][i]))
				{
					c++;
					break;
				}
				
				hs.add(a[j][i]);
			}
			
			
			
			
			
		}
		
		
		
		
		System.out.println("Case"+" "+"#"+ind+":"+" "+tr+" "+r+" "+c);
		ind++;
		
	}
	
	
	}
}