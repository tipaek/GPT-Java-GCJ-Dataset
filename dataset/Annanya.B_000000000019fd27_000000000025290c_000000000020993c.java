import java.util.*;
class Solution{
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int cr=0,cm=0;
			HashSet<Integer> set=new HashSet<>();
			for(int j=0;j<n;j++) {
				set.clear();
				for(int k=0;k<n;k++) {
					arr[j][k]=sc.nextInt();
					set.add(arr[j][k]);
				}
				if(set.size()!=n) {
					cr++;
				}
			}
			for(int j=0;j<n;j++) {
				set.clear();
				for(int k=0;k<n;k++) {
					set.add(arr[k][j]);
				}
				if(set.size()!=n) {
					cm++;
				}
			}
			int j=0,k=0,trace=0;
			while(k<n && j<n) {
				trace+=arr[j][k];
				j++;
				k++;
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+cr+" "+cm+" ");
		}
	}
}