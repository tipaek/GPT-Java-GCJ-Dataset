import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static List<int[]> sort(List<int[]> list, int i) {
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] x, int[] y) {
				return x[i] - y[i];
			}
		});
		return list;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTests = input.nextInt();
		for (int i = 0; i < numTests; i++) {
			int N = input.nextInt();//Number of activities
			List<int[]> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String start = input.next();
				String end = input.next();
				int[] interim = new int[4];
				interim[0] = Integer.parseInt(start);
				interim[1] = Integer.parseInt(end);
				interim[2] = j;
				list.add(interim);
			}
			sort(list,0);
				int endC = 0; int endJ = 0;
				boolean isImpossible = false;
				StringBuilder sb = new StringBuilder();
				for(int[] activity: list) {
					if(activity[0]>=endC) { activity[3]=1; endC = activity[1];}//This is for C
					else if(activity[0]>=endJ) { activity[3]=-1; endJ = activity[1];}//This is for J
					else {isImpossible=true;break;}
				}
				if(isImpossible) {
					System.out.printf("Case #%d: ",i+1);
					System.out.println("IMPOSSIBLE");
					continue;
				}else {
					sort(list,2);
					for(int[] array: list) {
						char c = (array[3]==1)?'C':'J';
						sb.append(c);
					}
					System.out.printf("Case #%d: ",i+1);
					System.out.println(sb.toString());
				}
			}
		}
}
