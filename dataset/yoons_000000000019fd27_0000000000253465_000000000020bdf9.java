/**
 * Parenting Partnering Returns
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	public static int caseNum, iN;
//	public static int[][] schedules;
	public static Activity[] activities;
	public static String[][] cache;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./src/cj2020/qualification03/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		caseNum = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = null;
		for (int cn = 1; cn <= caseNum; ++cn) {
			iN = Integer.parseInt(br.readLine().trim());
//			schedules = new int[iN][2];
			activities = new Activity[iN];
			cache = new String[iN][2];
			
			for (int i = 0; i < iN; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				
//				schedules[i][0] = Integer.parseInt(st.nextToken()); // start time
//				schedules[i][1] = Integer.parseInt(st.nextToken()); // end time
				
				activities[i] = new Activity(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
				cache[i][0] = null;
				cache[i][1] = null;
				
			}
			
			Arrays.sort(activities, new Comparator<Activity>(){
				@Override
				public int compare(Activity a1, Activity a2) {
					return a1.startTime - a2.startTime;
				}
			});
			
//			for (int i = 0; i < iN; ++i) {
//				System.out.println("start time : " + activities[i].startTime + " | end time : " + activities[i].endTime);
//			}
			
//			System.out.println("Case #" + cn + ": " + scheduling(0, 0, activities[0].endTime, 0));
			String tmpAnswer = scheduling(0, 0, activities[0].endTime, 0);
			
			String answer = "IMPOSSIBLE";
			
			if(!tmpAnswer.equals("IMPOSSIBLE")){
				answer = "";
				for (int i = 0; i < iN; ++i) {
					answer += tmpAnswer.substring(activities[i].idx, activities[i].idx+1);
				}
			}
				
			System.out.println("Case #" + cn + ": " + answer);
		}
	}
	
	//int jc : j = 0, c = 1
	public static String scheduling(int index, int jc, int endj, int endc) {
		if(index == iN - 1) return (jc == 0 ? "J" : "C");
		
		String ret = cache[index][jc];
		
		if(ret != null) return ret;
		
		String pre = "";

		ret = "";
		
		if(jc == 0) {
			pre = "J";
			if(activities[index].endTime <= activities[index+1].startTime) {
				ret = scheduling(index + 1, 0, activities[index+1].endTime, endc);
			} else if(endc <= activities[index+1].startTime){
				ret = scheduling(index + 1, 1, endj, activities[index+1].endTime);
			} else {
				ret = "IMPOSSIBLE";
			}
		} else if(jc == 1) {
			pre = "C";
			if(activities[index].endTime <= activities[index+1].startTime) {
				ret = scheduling(index + 1, 1, endj, activities[index+1].endTime);
			} else if(endj <= activities[index+1].startTime){
				ret = scheduling(index + 1, 0, activities[index+1].endTime, endc);
			} else {
				ret = "IMPOSSIBLE";
			}
		}
		
		if(!ret.equals("IMPOSSIBLE")) ret = pre + ret;
		
		return ret;
		
	}
	
	
	public static class Activity{
		int idx;
		int startTime;
		int endTime;
		
		public Activity(int idx, int startTime, int endTime) {
			this.idx = idx;
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

}
