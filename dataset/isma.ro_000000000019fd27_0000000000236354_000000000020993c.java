import java.util.*;


public class problemQ1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a = 0; a < T; a++) {
			int N = in.nextInt();
			int [][] m = new int[N][N];
			int t=0;
			
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					m[i][j]= in.nextInt();
					if(i==j){
						t=t+m[i][i];
					}
				}
			}
			
			
			int r =0;
			
			
			for (int i = 0; i < m.length; i++) {
				boolean [] app= new boolean [N];
				for (int j = 0; j < m.length; j++) {
					int v = m[i][j];
					if(app[v-1]){
						r++;
						j=N;
					}else{
						app[v-1]=true;
					}
					
				}
			}
			
			int c =0;
			
			
			for (int j = 0; j < m.length; j++) {
				boolean [] app= new boolean [N];
				for (int i = 0; i < m.length; i++) {
					int v = m[i][j];
					if(app[v-1]){
						c++;
						i=N;
					}else{
						app[v-1]=true;
					}
					
				}
			}
			
			System.out.println("Case #"+(a+1)+": "+t+" "+r+" "+c);
			
			
			
		}

	}

}