import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution{

	static int n, m;

	public static long sum(int[][] x){
		long sum = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				sum += x[i][j];
			}
		} 
		return sum;
	}

	public static void print(int[][] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println("");
		}
		System.out.println("");
	}

	public static void print(boolean[][] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			String[] rc = br.readLine().split(" ");
			n = Integer.parseInt(rc[0]);
			m = Integer.parseInt(rc[1]);

			int[][] x = new int[n][m];
			for(int i = 0; i < n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++){
					x[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			BigInteger sum = BigInteger.valueOf(sum(x));
			while(true){
				// print(x);
				boolean changed = false;
				int[][] xcopy = new int[n][m];

				for(int i = 0; i < n; i++){
					xcopy[i] = Arrays.copyOf(x[i], m);
				}
				// print(xcopy);
				for(int i = 0; i < n; i++){
					for(int j = 0; j < m; j++){
						long left = 0;
						long right = 0;
						long top = 0;
						long bot = 0;
						int starti = i;
						int den = 0;

						if(x[i][j] == 0)
							continue;

						while(starti != 0){
							if(x[starti - 1][j] != 0){
								left = x[starti - 1][j];
								den++;
								break;
							}
							starti--;
						}
						starti = i;
						while(starti != n - 1){
							if(x[starti + 1][j] != 0){
								right = x[starti + 1][j];
								den++;
								break;
							}
							starti++;
						}
						int startj = j;
						while(startj != 0){
							if(x[i][startj - 1] != 0){
								top = x[i][startj - 1];
								den++;
								break;
							}
							startj--;
						}
						startj = j;
						while(startj != m - 1){
							if( x[i][startj + 1] != 0){
								bot = x[i][startj + 1];
								den++;
								break;
							}
							startj++;
						}
						// System.out.printf("%d %d\n", i, j);
						// System.out.printf("%d %d %d %d\n",left, right, top, bot);
						// System.out.println("den: " + den);
						if((left + right + top + bot) > den * x[i][j]){
							xcopy[i][j] = 0;
							changed = true;
						}

					}
				}
			// System.out.println("done");
				if(!changed)
					break;
				// System.out.println("sum(x): " + sum(x));
				sum = sum.add(BigInteger.valueOf(sum(xcopy)));
				x = xcopy;

			}


			System.out.printf("Case #%d: %d\n", numCases, sum);
		}



		br.close();
	}

}