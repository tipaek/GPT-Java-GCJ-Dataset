import java.io.*;
import java.util.*;
class Vestigium {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for(int z=1;z<=t;z++) {
			int N = Integer.parseInt(bf.readLine());
			int sum=0;
			int r=0;
			int c=0;
			int[][]matrix = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++) {
					matrix[i][j]=Integer.parseInt(st.nextToken());

				}
				sum+=matrix[i][i];
			}
			for(int i=0;i<N;i++) {
				if(!multiple(matrix[i])) {
					r++;
				}
			}
			for(int i=0;i<N;i++) {
				int[]check = new int[N];
				for(int j=0; j<N; j++){
					check[i] = matrix[j][i];
				}
				if(!multiple(check)) {
					c++;
				}
			}


			System.out.println("Case #"+z+": "+sum+" "+r+" "+c);
		}

	}

	public static boolean multiple(int[]check) {
		int[]check2 = Arrays.copyOf(check, check.length);
		Arrays.parallelSort(check2);
		for(int i=0;i<check2.length-1;i++) {
			if(check[i]==check[i+1]) {
				return false;
			}
		}
		return true;
	}

}
