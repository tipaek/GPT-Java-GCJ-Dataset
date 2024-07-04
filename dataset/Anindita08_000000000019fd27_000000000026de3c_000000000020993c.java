import java.lang.*;
import java.io.*;
import java.util.*;
class Solution{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader x= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(x.readLine());
		int T=Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(x.readLine());
			int N=Integer.parseInt(st.nextToken());
			int[][] mat=new int[N][N];
			int trace=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(x.readLine());
				for(int j=0;j<N;j++) {
					mat[i][j]=Integer.parseInt(st.nextToken());
					if(i==j) trace+= mat[i][j];
				}
			}
			int r=0, c=0;
			for(int i=0;i<N;i++) {
				int x1=0, x2=0;
				HashMap<Integer, Integer> ro  = new HashMap<>(); 
				HashMap<Integer, Integer> co = new HashMap<>(); 
				for(int j=0;j<N;j++) {
					if (ro.containsKey(mat[i][j])) 
						x1++;
					else ro.put(mat[i][j], 1);
					if (co.containsKey(mat[j][i])) 
						x2++;
					else co.put(mat[j][i], 1);
					
				}
				if(x1!=0)
					r++;
				if(x2!=0)
					c++;
			}
			System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
			
		}
	}
}
