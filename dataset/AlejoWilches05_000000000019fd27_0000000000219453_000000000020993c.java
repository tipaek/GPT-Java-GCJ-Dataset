import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(bf.readLine());
		while(T-- > 0) 
		{
			
			int N = Integer.parseInt(bf.readLine());
			int mat[][] = new int [N][N];
			int rr = 0;
			int rc = 0;
			int diag = 0;
			int c = 1;
			int rep[] = new int[N];
			for(int i = 0; i < mat.length; i++) {
				int j=0;
				boolean v = false;
				StringTokenizer tk = new StringTokenizer(bf.readLine());
				while(tk.hasMoreTokens()) 
				{	
					int num = Integer.parseInt(tk.nextToken());
					if(j>0 && !v) 
					{
						if(Arrays.binarySearch(mat[i], num) > -1) {
								rr =rr+=1;
								v=true;
						}
					}
					mat[i][j] = num;
					if(i>0 && rep[j] == 0) 
					{
						int k = i;
						while( k-- > 0) {
							if(mat[k][j] == mat[i][j]) {
								rep[j] = 1;
								rc+=1;
							}
						}
					}
					if(i==j) {
						diag+=mat[i][j];
					}
					j++;
				}
			}
			pw.println("Case #"+c+": "+diag+" "+rr+" "+rc);
		}
		bf.close();
		pw.flush();
		pw.close();
	}

}
