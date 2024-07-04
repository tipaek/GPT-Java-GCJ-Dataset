import java.util.*;
class Solution {
	public static void main(String asdf[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		if(t>=1 && t<=100) {
			x:for(int z=1;z<=t;z++) {
				int n = in.nextInt();
				if(n>=2 && n<=100) {
					int a[][] = new int[n][n];
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							a[i][j] = in.nextInt();
							if(a[i][j]<1 || a[i][j]>n) continue x;
						}
					}
					int sum=0,row=0,col=0;
					for(int i=0;i<n;i++) {
						LinkedHashSet<Integer> r = new LinkedHashSet<>();
						for(int j=0;j<n;j++) {
							r.add(a[i][j]);
							if(i==j) sum+=a[i][j];
						}
						if(r.size()!=n) row++;
						r.clear();
					}
					for(int j=0;j<n;j++) {
						LinkedHashSet<Integer> c = new LinkedHashSet<>();
						for(int i=0;i<n;i++) {
							c.add(a[i][j]);
						}
						if(c.size()!=n) col++;
					}
					System.out.printf("Case #%d: %d %d %d\n",z,sum,row,col);
				}
			}
		}
	}
}
							
							