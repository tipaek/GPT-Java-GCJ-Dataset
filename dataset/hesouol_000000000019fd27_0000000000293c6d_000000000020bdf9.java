import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int t1=0; t1<t; t1++) {
			int n = in.nextInt();
			List<Activity> list = new ArrayList<>();
			for(int n1=0; n1<n; n1++) {
				list.add(new Activity(in.nextInt(), in.nextInt()));
			}
			System.out.format("Case #%d: %s\n",t1+1, solve(list));
			
		}
		in.close();
	}
	
	public static String solve(List<Activity> l) {
		//Estrategia gulosa, pegar a que termina mais cedo e jogar pra 1 ou pra outro
		
		List<Activity> sorted = l.parallelStream().sorted().collect(Collectors.toList());
		
//		sorted.forEach(System.out::println);
		
		StringBuilder builder = new StringBuilder();
		
		Activity lastCameron = new Activity(-1,-1);
		Activity lastJamie = new Activity(-1,-1);
		
		for(Activity act: sorted) {
			
			if(act.start>=lastCameron.end && act.start>=lastJamie.end) {
				//ambos podem
				if(lastCameron.end < lastJamie.end) {
					builder.append("J");
					lastJamie=act;
					continue;
				}
				builder.append("C");
				lastCameron=act;
				continue;
			}

			if(act.start>=lastJamie.end) {
				builder.append("J");
				lastJamie=act;
				continue;
			}
			
			if(act.start>=lastCameron.end) {
				builder.append("C");
				lastCameron=act;
				continue;
			}
			
			return "IMPOSSIBLE";
		}
		
		return builder.toString();
		
	}
	
	
	private static class Activity implements Comparable<Activity>{
		public int start;
		public int end;

		public Activity(int start, int end) {
			this.start=start;
			this.end=end;
		}

		@Override
		public int compareTo(Activity arg0) {
			if(arg0.end > end) {
				return -1;
			}
			if(arg0.end < end) {
				return 1;
			}
			
			if(arg0.start > start) {
				return -1;
			}
			
			if(arg0.start > start) {
				return 1;
			}
			
			return 0;
		}

		@Override
		public String toString() {
			return "Activity [start=" + start + ", end=" + end + "]";
		}

	}
}


