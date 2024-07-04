import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		ArrayList<String> results = new ArrayList<String>(test_cases);
		for (int i=0 ; i<test_cases; i++) {
			
			results.add(activity_sel(sc.nextInt(), sc));
		}
		
		test_cases = 1;
		for(String result : results) {
			StringBuilder sb = new StringBuilder();
			sb.append("Case #");
			sb.append(test_cases);
			sb.append(": ");
			sb.append(result);
			System.out.println(sb.toString());
			test_cases++;
		}
	}
	
	public static String activity_sel(int act, Scanner sc) {
		
		Integer[] C_flag =  new Integer[3];
		Integer[] J_flag =  new Integer[3];
		
		char[] result = new char[act];
		
		ArrayList<Integer[]> act_time = new ArrayList<Integer[]>(act);
		for(int i=0; i<act; i++) {
			Integer[] entry = {sc.nextInt(),sc.nextInt(),i};
			if(entry[0] < 0 || entry[1] <0)
				return "IMPOSSIBLE";
			act_time.add(entry);			
		}
		
		Collections.sort(act_time, ((a1,a2) -> a1[1] - a2[1]));
		
		int index = 0;
		for(int i =0; i<act; i++) {
			if (i == 0){
				C_flag = act_time.get(i);
				index = C_flag[2];
				result[index] = 'C';
				Integer[] init_entry = {0,0,0};
				J_flag = init_entry;
				continue;
			}
			
			if(act_time.get(i)[0] >= C_flag[1]) {
				C_flag = act_time.get(i);
				index = C_flag[2];
				result[index] = 'C';
			}
			else if(act_time.get(i)[0] >= J_flag[1]) {
				J_flag = act_time.get(i);
				index = J_flag[2];
				result[index] = 'J';
			}
			else
				return "IMPOSSIBLE";
			
		}
		
		return String.valueOf(result);
	}

}
