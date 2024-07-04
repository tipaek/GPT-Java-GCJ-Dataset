import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int caseCount = in.nextInt();
		in.nextLine();
		
		for(int c = 1; c <= caseCount; c++) {
						
			int activityCount = in.nextInt();
			in.nextLine();
			
			ArrayList<int[]> intervals = new ArrayList<int[]>();
			char[] ans = new char[activityCount];
			
			for(int i = 0; i < activityCount; i++) {
				int[] current = new int[4];
				current[0] = i;				//original pos
				current[1] = 0;				//valid for cameron
				current[2] = in.nextInt();
				current[3] = in.nextInt();
				
				intervals.add(current);
				
				in.nextLine();
			}
			
			intervals.sort((a, b) -> Integer.compare(a[2], b[2]));
			
			// find intervals
			int last_c_end = -1;
			int last_j_end = -1;
			boolean impossible = false;
			for(int i = 0; i < activityCount; i++) {
				int[] current = intervals.get(i);
				
				if(i == 0 || current[2] >= last_c_end) {
					current[1] = (int) 'C';
					last_c_end = current[3];
				
				} else if (current[2] >= last_j_end){
					current[1] = (int) 'J';
					last_j_end = current[3];
					
				} else {
					impossible = true;
					break;
				}
			}
			
			if(impossible) {
				System.out.println("Case #" + c + ": IMPOSSIBLE");
				continue;
			}
			
			intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
			
			System.out.println("Case #" + c + ": " + intervals.stream()
			.sorted((a, b) -> Integer.compare(a[0], b[0]))
			.map(x -> (char) x[1])
			.map(String::valueOf)
			.collect(Collectors.joining()));
		}
	}
}
