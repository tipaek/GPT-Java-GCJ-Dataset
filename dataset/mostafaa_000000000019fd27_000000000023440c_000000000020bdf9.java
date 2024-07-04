import java.io.*;
import java.util.*;



public class Solution {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String result = "";
			ActivityTime[] timings = new ActivityTime[N*2];
			for(int i = 0; i < N; i++){
				int j = i*2;
				st = new StringTokenizer(br.readLine());
				int time = Integer.parseInt(st.nextToken());
				timings[j++] = new ActivityTime(i, time, true);
				time = Integer.parseInt(st.nextToken());
				timings[j++] = new ActivityTime(i, time, false);
			}
			Arrays.sort(timings);
			int[] cameronFree = new int[]{1,-1};
			int[] jamesFree = new int[]{1,-1};
			for(int i = 0; i < N*2; i++){
				ActivityTime at = timings[i];
				if(at.type == true){
					if(cameronFree[0] == 1){
						cameronFree[0] = 0;
						cameronFree[1] = at.order;
						at.setAssignee(true);
					}
					else
						if(jamesFree[0] == 1){
							jamesFree[0] = 0;
							jamesFree[1] = at.order;
							at.setAssignee(false);
						}
						else{//check next typrone if eq
							result = "IMPOSSIBLE";
							break;
						}
				}
				else{
					if(cameronFree[1] == at.order){
						cameronFree[0] = 1;
						cameronFree[1] = -1;
					}
					else{
						jamesFree[0] = 1;
						jamesFree[1] = -1;
					}
				}
			}
			if(result.equals(""))
			{	int l = -1;
				char[] arr = new char[N];
				while(l++<(N*2-1))
					if( timings[l].type == true)
						arr[timings[l].order] = timings[l].assignee == true ? 'C':'J';
				result = new String(arr);
			}

			if(t==T-1)
			pw.print(String.format("Case #%d: %s", t+1, result));
			else
			pw.println(String.format("Case #%d: %s", t+1, result));
		}
		

		pw.flush();
		pw.close();
	}

	static class ActivityTime implements Comparable<ActivityTime>{
		int order;
		int time;
		Boolean type;//true: start, false: end
		Boolean assignee;//true: cameron, false: james

		ActivityTime(int order, int time, Boolean type){
			this.order = order;			
			this.time = time;
			this.type = type;			
		}
		/**
		 * @param assignee the assignee to set
		 */
		public void setAssignee(Boolean assignee) {
			this.assignee = assignee;
		}


		public int compareTo(ActivityTime compareActivityTime){

			if(this.time != compareActivityTime.time)
				return this.time - compareActivityTime.time;
			if(this.type == false)
				return -1;
			return 1; 
		}

	}
}