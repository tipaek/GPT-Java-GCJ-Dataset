import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Vestigium {
	static int t, n,m, k,r,c;
	static boolean[] v=new boolean[101];
	static ArrayList<Integer> arr=new ArrayList<>();
	static int[][] d= new int[101][101];
	static StringTokenizer st=null;
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine());
		t=Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= t; tc++) {
			n=Integer.parseInt(br.readLine());
			k=0;r=0;c=0;
			
			for (int i = 1; i <= n; i++) {
				st= new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) 
					d[i][j]=Integer.parseInt(st.nextToken());
			}

			//r
			for (int i = 1; i <= n; i++) {
				Arrays.fill(v, false);
				for (int j = 1; j <= n; j++) {
					if(v[d[i][j]]) {
						r++;
						break;
					} else 
						v[d[i][j]]=true;
				}
			}

			//c
			for (int j = 1; j <= n; j++) {
				Arrays.fill(v, false);
				for (int i = 1; i <= n; i++) {
					if(v[d[i][j]]) {
						c++;
						break;
					} else 
						v[d[i][j]]=true;
				}
			}

			
			for (int i = 1; i <= n; i++)
				k+=d[i][i];
			
			bw.append("Case #"+tc+": "+k+" "+r+" "+c+"\n");
		}
			
		bw.flush();
		bw.close();
	}

}
