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
	public static int[][] schedules;
	public static String[][] cache;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/cj2020/qualification03/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		caseNum = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = null;
		for (int cn = 1; cn <= caseNum; ++cn) {
			iN = Integer.parseInt(br.readLine().trim());
			schedules = new int[iN][2];
			cache = new String[iN][2];
			
			for (int i = 0; i < iN; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				
				schedules[i][0] = Integer.parseInt(st.nextToken()); // start time
				schedules[i][1] = Integer.parseInt(st.nextToken()); // end time
				cache[i][0] = null;
				cache[i][1] = null;
				
			}
			
			Arrays.sort(schedules, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
//			for (int i = 0; i < iN; ++i) {
//				System.out.println("start time : " + schedules[i][0] + " | end time : " + schedules[i][1]);
//			}
			
			System.out.println("Case #" + cn + ": " + scheduling(0, 0, schedules[0][1], 0));
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
			if(schedules[index][1] < schedules[index+1][0]) {
				ret = scheduling(index + 1, 0, schedules[index+1][1], endc);
			} else if(endc <= schedules[index+1][0]){
				ret = scheduling(index + 1, 1, endj, schedules[index+1][1]);
			} else {
				ret = "IMPOSSIBLE";
			}
		} else if(jc == 1) {
			pre = "C";
			if(schedules[index][1] < schedules[index+1][0]) {
				ret = scheduling(index + 1, 1, endj, schedules[index+1][1]);
			} else if(endj <= schedules[index+1][0]){
				ret = scheduling(index + 1, 0, schedules[index+1][1], endc);
			} else {
				ret = "IMPOSSIBLE";
			}
		}
		
		if(!ret.equals("IMPOSSIBLE")) ret = pre + ret;
		
		return ret;
		
	}

}
