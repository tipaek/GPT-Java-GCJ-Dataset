import java.util.*;
class Solution{
    private static void  displayResult(List<Integer> res) {
		for(int i=0;i<res.size();i=i+4)
			System.out.println("Case #"+res.get(i)+": "+res.get(i+1)+" "+res.get(i+2)+" "+res.get(i+3));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Integer> res = new ArrayList<>();
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int[][] mat = new int[n][n];
			for(int j=0;j<n;j++)
				for(int k=0;k<n;k++)
					mat[j][k] = sc.nextInt();
			int trace =0;
			int r=0;
			int c=0;
			int rfound =0;
			int cfound =0;
			for(int l=0;l<n;l++) {
				HashSet<Integer> hash = new HashSet<>();
				rfound =0;
				HashSet<Integer> hashCol = new HashSet<>();
				for(int m=0;m<n;m++) {
					if(l==m)
						trace+=mat[l][m];
					if(!hash.contains(mat[l][m]))
					{ hash.add(mat[l][m]);}
					else
						rfound =1;
				}
				if(rfound ==1)
					r++;
			}
			
			for(int q=0;q<n;q++) {
				HashSet<Integer> hashCol = new HashSet<>();
				cfound = 0;
				for(int p=0;p<n;p++) {
					if(!hashCol.contains(mat[p][q]))
					{ hashCol.add(mat[p][q]);}
					else
						cfound =1;
				}
				if(cfound ==1)
					c++;
			}
			
			
			res.add(i);res.add(trace);res.add(r);res.add(c);
			
		}
		displayResult(res);
		sc.close();

	}
}