import java.util.*;
class one{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int it;
		for(it=0;it<t;it++){
			int n = s.nextInt();
			int[][] ar = new int[n][n];
			int i,j;
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					ar[i][j]=s.nextInt();
				}
			}
			int[][] h = new int[n][n+1];
			int r=0,c=0;
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					if(h[i][ar[i][j]]==1){
						r++;
						break;
					}
					h[i][ar[i][j]]=1;
				}
			}
			int[][] h2 = new int[n][n+1];
			for(j=0;j<n;j++){
				for(i=0;i<n;i++){
					if(h2[j][ar[i][j]]==1){
						c++;
						break;
					}
					h2[j][ar[i][j]]=1;
				}
			}
			int tr=0;
			for(i=0;i<n;i++){
				tr+=ar[i][i];
			}
			System.out.println(tr+" "+r+" "+c);
		}
	}
}