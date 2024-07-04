import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner in=new Scanner (System.in);
		int t=in.nextInt();
		int test=0;
		while(--t>=0) {
			int n=in.nextInt();
			int arr[][]=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=in.nextInt();
				}
			}
			int ctr1=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> hset=new HashSet<>();
				for(int j=0;j<n;j++) {
					if(hset.contains(arr[i][j])) {
						ctr1++;
						break;
					}
					else {
						hset.add(arr[i][j]);
					}
				}
			}
			int ctr2=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> hset=new HashSet<>();
				for(int j=0;j<n;j++) {
					if(hset.contains(arr[j][i])) {
						ctr2++;
						break;
					}
					else {
						hset.add(arr[j][i]);
					}
				}
			}
			int sum=0;
			for(int i=0;i<n;i++) {
				sum=sum+arr[i][i];
			}
			System.out.println("Case #"+(++test)+": "+sum+" "+ctr1+" "+ctr2);
		}
	}
}
