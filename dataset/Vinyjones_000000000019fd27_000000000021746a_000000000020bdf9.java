
	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

	
	public class Solution {
	
		public static void main(String[] args) throws IOException {
			Solution solver = new Solution();
	
			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
				int nbCaseToSolve = Integer.parseInt(br.readLine().trim());
				for (int i = 1; i <= nbCaseToSolve; i++) {
					int nbActivity= Integer.parseInt(br.readLine().trim());
					List<Activity> activities = new ArrayList<>();
					for (int j = 0; j < nbActivity; j++) {
						String line = br.readLine();
						int [] tab = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
						activities.add(new Activity( j, tab[0], tab[1]));
					}
					
					System.out.println( solver.solve(i, activities));
				}
				while (br.readLine() != null) {
				}
			}
		}
	
	
	


		private String solve(int x, List<Activity> activities) {
			int N = activities.size();
			Collections.sort(activities);
			int endJ = 0, endC = 0;
			boolean stillOkSofar = true;
			for (Activity activity : activities) {
				if(activity.S>=endJ) {
					activity.who="J";
					endJ = activity.E;
				} else if(activity.S>=endC) {
					activity.who="C";
					endC = activity.E;
				} else {
					stillOkSofar = false;
					break;
				}
 				
				
				
			}	
			
			String rep;
			if(stillOkSofar) {
				rep = activities.stream().sorted(Comparator.comparing(Activity::getId)).map(Activity::getWho).collect(Collectors.joining());
			} else {
				rep = "IMPOSSIBLE";
			}
			return print(x, rep);
			
		}





		String print(int x, String path) {
	
			return String.format("Case #%d: %s", x, path);
	
		}
		
		static class Activity implements Comparable<Activity>{
			int S;
			int E;
			int size; 
			String who;
			int id;
			
			public int getId() {
				return id;
			}
			public String getWho() {
				return who;
			}
			
			
			public Activity(int id, int s, int e) {
				super();
				this.id = id;
				S = s;
				E = e;
				size = e-s;
			}
			@Override
			public int compareTo(Activity o) {
				int r = S - o.S;
				if (r!=0) {
					return r;
				}
				return size - o.size;
			}


			@Override
			public String toString() {
				return String.format(" [S=%s, E=%s]", S, E);
			}
			
			
		}
	
	}
