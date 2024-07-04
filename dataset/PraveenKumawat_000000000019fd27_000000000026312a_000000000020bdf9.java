import java.io.BufferedReader;
import java.io.*;

public class Solution{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String TESTCASES = br.readLine();
		String[] t = TESTCASES.split(" ");
		int T = Integer.parseInt(t[0]);

		for (int i = 0; i < T; i++) {
			String ACTIVITIES = br.readLine();
			String[] n = ACTIVITIES.split(" ");
			int N = Integer.parseInt(n[0]);

			String str ="";
			int start_time=0, end_time=0;
			int c_end_time = 0;
			int j_end_time = 0;
			int c_start_time =0 ;
			int j_start_time = 0;
			
			int arr[] = new int[2];
			arr[0] = 1;
			arr[1] = 1;

			for (int j = 0; j < N; j++) {
				String timings = br.readLine();
				String[] start_end = timings.split(" ");

				start_time = Integer.parseInt(start_end[0]);
				end_time = Integer.parseInt(start_end[1]);

				if ((start_time >= c_end_time && end_time >= c_end_time)
						||(start_time <= c_start_time && end_time <= c_start_time))
					arr[0] = 1;

				if ((start_time >= j_end_time && end_time >= j_end_time)
					||(start_time <= j_start_time && end_time <= j_start_time))
					arr[1] = 1;

				if (arr[0] == 1 || arr[1] == 1) {

					
					if (arr[1] == 1) {
						str += 'J';
						arr[1] = 0;
						j_start_time = start_time;
						j_end_time = end_time;
						continue;
					}
					
					if (arr[0] == 1) {
						str +='C';
						arr[0] = 0;
						c_start_time = start_time;
						c_end_time = end_time;
						continue;
					}
					
				} else {
					str ="IMPOSSIBLE";
					break;
				}
				
			}
			System.out.println("Case #"+(i+1)+": "+str);
		}
	}
}