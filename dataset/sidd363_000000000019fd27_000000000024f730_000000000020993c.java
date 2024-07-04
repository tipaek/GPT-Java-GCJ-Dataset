import java.util.*;
public class Solution {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(" hi w");
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int test = 1;
		while(t-- >0) {
			
			int n = sc.nextInt();
			int [][] mat = new int[n][n];
			
			for(int  i =0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					int ele = sc.nextInt();
					mat[i][j] = ele;
				}
			}
			compute(mat, n, test);
			test++;
		}
		
	}

	private static void compute(int[][] mat, int n, int caseno) {
		// TODO Auto-generated method stub
		
		int trace = 0;
		int faultyrows =0;
		int faultycols=0;
		
		for(int  i =0;i<n;i++) {
			HashSet<Integer> hr = new HashSet<Integer>();
			HashSet<Integer> hc = new HashSet<Integer>();
			for(int j = 0;j<n;j++) {
				hr.add(mat[i][j]);
				hc.add(mat[j][i]);
				if(i==j) {
					trace+= mat[i][j];
				}
			}
			if(hr.size()!=n) {
				faultyrows++;
			}
			if(hc.size()!=n) {
				faultycols++;
			}
		}
		
		//Case #1: 4 0 0

		System.out.println("Case #"+caseno+": "+trace+ " "+ faultyrows + " "+ faultycols+"");
	}

}
