import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Round0Problem1 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(bf.readLine());
			
			for (int i=0; i<T; i++) {
				
				int k = 0;
				int r = 0;
				int c = 0;
				
				int N = Integer.parseInt(bf.readLine());
				boolean[][] rows = new boolean[N][N];
				boolean[][] columns = new boolean[N][N];
				
				for (int x=0; x<N; x++) {
					
					String[] M = bf.readLine().split(" ");
					for (int y=0; y<N; y++) {
						int m = Integer.parseInt(M[y]);
						if (x==y) k = k + m;
						rows[x][m-1] = true;
						columns[y][m-1]=true;
					}
				}
				
				for (int  x=0; x<N; x++) {
					boolean found = false;
					for (int y=0; !found && y<N; y++) {
						if (!rows[x][y]) {
							r++;
							found = true;
						}
					}
				}
				
				for (int  x=0; x<N; x++) {
					boolean found = false;
					for (int y=0; !found && y<N; y++) {
						if (!columns[x][y]) {
							c++;
							found = true;
						}
					}
				}
				
				System.out.println("Case #" + (i+1) + ": " + k + " " + r + " " + c);
			}
			
			
		} catch (Exception e) {
			
		}
		
	}
	
}
