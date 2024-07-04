import java.util.*;
class Solution {
	public static void main(String[] args) {
	Scanner kb =new Scanner (System.in);
	int  t =kb.nextInt();
	for (int i = 1; i <= t; i++) {
		int n = kb.nextInt();
		int mat[][]=new int[n][n];
		for (int j = 0; j < mat.length; j++) {
			for (int j2 = 0; j2 < mat.length; j2++) {
				mat[j][j2]=kb.nextInt();
			}
		}
		int trace=0,rocount=0,cocount=0;
		for (int j = 0; j < mat.length; j++) {
			Set<Integer>rows =new HashSet<Integer>();
			Set<Integer>coloumn =new HashSet<Integer>();
			
			
				trace+=mat[j][j];
			
			for (int k = 0; k < mat.length; k++) {
				rows.add(mat[j][k]);
				coloumn.add(mat[k][j]);
				
			}
			if(rows.size()!=n)
			{
				rocount++;
			}
			if(coloumn.size()!=n)
			{
				cocount++;
			}
		}
		String a ="Case #"+i+": "+trace+" "+rocount+" "+cocount;
		System.out.println(a);
		
	}
	}

}
