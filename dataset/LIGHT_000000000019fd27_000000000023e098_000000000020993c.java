import java.util.*;
class test {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tt;
		
		for(tt=0;tt<t;++tt) {
			int n = scan.nextInt();
			boolean[] hash = new boolean[n+1]; 
			int[][] matrix = new int[n][n];
			int i,j,k;
			
			for(k=0;k<=n;++k)  hash[k]=false;
			
			for(i=0;i<n;++i) {
				for(j=0;j<n;++j) {
					matrix[i][j]=scan.nextInt();
				}
			}
		
			int trace = 0;
			
			for(i=0;i<n;++i) trace+=matrix[i][i];
			
			int countRow=0,countCol=0;
			
			for(i=0;i<n;++i) {
				for(k=0;k<=n;++k)  hash[k]=false;
				for(j=0;j<n;++j) {
					if(hash[matrix[i][j]]) {
						++countRow;
						break;
					}
					hash[matrix[i][j]]=true;
				}
			}
			
			for(j=0;j<n;++j) {
				for(k=0;k<=n;++k)  hash[k]=false;
				for(i=0;i<n;++i) {
					if(hash[matrix[i][j]]) {
						++countCol;
						break;
					}
					hash[matrix[i][j]]=true;
				}
			}
			
			System.out.printf("Case #%d: %d %d %d\n",tt,trace,countRow,countCol);
		}
		
	}
}
