import java.io.*;
import java.util.*;
class gcj {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];
			for (int i=0;i <N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0;j<N; j++) {
					int bobbyjoe = Integer.parseInt(st.nextToken());
					matrix[i][j]=bobbyjoe;
				}
			}
			System.out.print("Case #"+asdfasdf+": ");
			int counter=0;
			for(int i=0; i<N;i++) {
				counter+=matrix[i][i];
			}
			System.out.print(counter+" ");
			int columncounter = 0;
			for (int i=0; i<N; i++) {
				HashSet<Integer> columnset = new HashSet();
				for (int j=0;j <N; j++) {
					if (columnset.contains(matrix[j][i])){
						columncounter++;
						break;
					}
					else columnset.add(matrix[j][i]);
				}
			}
			int rowcounter = 0;
			for (int i=0; i<N; i++) {
				HashSet<Integer> rowset = new HashSet();
				for (int j=0;j <N; j++) {
					if (rowset.contains(matrix[i][j])){
						rowcounter++;
						break;
					}
					else rowset.add(matrix[i][j]);
				}
			}
			System.out.println(rowcounter+" "+columncounter);
		}
	}
}
