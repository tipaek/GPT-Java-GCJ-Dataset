import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		test: for(int tt=1 ; tt<=t ; tt++) {
			int n = Integer.parseInt(br.readLine());

			int[][] schedule = new int[n][2];

			for(int i=0 ; i<n ; i++) {
				String[] input = br.readLine().split(" ");
				schedule[i][0] = Integer.parseInt(input[0]);
				schedule[i][1] = Integer.parseInt(input[1]);
			}

			Arrays.parallelSort(schedule, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}				
			});

			int cameron = 0;
			int jamie = 0;
			StringBuilder sb = new StringBuilder();

			for(int i=0 ; i<n ; i++) {
				int from = schedule[i][0];
				int to = schedule[i][1];

				if(cameron>jamie) {
					if(jamie<=from) {
						sb.append('J');
						jamie = to;
					}
					else {
						bw.write("Case #"+tt+": "+"IMPOSSIBLE"+"\n");
						continue test;
					}
				}
				else {
					if(cameron<=from) {
						sb.append('C');
						cameron = to;
					}
					else {
						bw.write("Case #"+tt+": "+"IMPOSSIBLE"+"\n");
						continue test;
					}
				}
			}			

			bw.write("Case #"+tt+": "+sb.toString()+"\n");
		}

		bw.flush();
	}
}
