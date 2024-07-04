
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i =1;i<=T;i++){
			int N = s.nextInt();
			
			int mat[][] = new int[N][N];
			int d = 0,r=0,c=0,flag=0;
			
			for(int j=0;j<N;j++){
				int vis[] = new int[N];
				Arrays.fill(vis, -1);
				flag=0;
				for(int k=0;k<N;k++){
					
					mat[j][k] = s.nextInt();
					if(vis[mat[j][k]-1] == 1){
						if(flag==0){
							r++;
						}
						flag=1;
					}
					vis[mat[j][k]-1] = 1;
					if(j==k && mat[j][k]>0 && mat[j][k]<=N) d+=mat[j][k];
				}
			}
			
			for(int j=0;j<N;j++){
				int vis[] = new int[N];
				Arrays.fill(vis, -1);
				flag=0;
				for(int k=0;k<N;k++){

					if(vis[mat[k][j]-1] == 1){
						if(flag==0){
							c++;
						}
						flag=1;
					}
					vis[mat[k][j]-1] = 1;
				}
			}
			
			System.out.println("Case #"+i+": "+ d + " "+ r +" " + c);
		}
	}

}
