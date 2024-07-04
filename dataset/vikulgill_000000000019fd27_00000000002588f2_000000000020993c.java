import java.util.*;
import java.lang.*;
public class Solution {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int k=s.nextInt();
		int x=1;
		while (k>0)  {
		int n=s.nextInt();
		int arr[][]=new int[n][n];
		for(int i=0;i<n;i++)  {
			for( int j=0;j<n;j++) {
				arr[i][j]=s.nextInt();
			}
		}
	
	 int trace=0;
	 int row=0;
	 int coloumn=0;
	 HashSet<Integer> set1=new HashSet();
		HashSet<Integer> set2=new HashSet();
	 for(int i=0;i<n;i++)  {
		trace+=arr[i][i];
	 }
	
	
	for(int i=0;i<n;i++)  {
		set1.clear();set2.clear();
		for(int j=0;j<n;j++)  {
			set1.add(arr[i][j]);
			set2.add(arr[j][i]);
		}
		if(set1.size()!=n) {
			row++;
		}
		if(set2.size()!=n) {
			coloumn++;
		}
	}
	System.out.println("Case #"+x+":"+" "+trace+" "+row+" "+coloumn);
	k--;
	x++;
	}
}
}