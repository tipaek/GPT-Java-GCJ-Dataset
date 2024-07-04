import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		
		for (int x = 1; x <= T; ++x) {
			int N = in.nextInt();
			List<Activity> activities = new ArrayList<>();
			Map<Integer,List<Activity>> sortedActivities = new TreeMap<>();
			boolean isImpossible = false;
			
			for (int i=0;i<N;i++){
				int S = in.nextInt();
				int E = in.nextInt();
				Activity act = new Activity(S,E);
				if (!isImpossible && !sortedActivities.containsKey(S)) {
					List<Activity> acts = new ArrayList<>();
					acts.add(act);
					sortedActivities.put(S, acts);
					activities.add(act);
				}
				else if (!isImpossible && sortedActivities.containsKey(S) && sortedActivities.get(S).size()==1) {
					List<Activity> acts = sortedActivities.get(S);
					acts.add(act);
					activities.add(act);
				}
				else if (!isImpossible){
					isImpossible = true;
				}
			}
			
			Iterator<Integer> it = sortedActivities.keySet().iterator();
			int Ec=0;
			int Ej=0;
			while (!isImpossible && it.hasNext()){
				int S = it.next();
				List<Activity> acts = sortedActivities.get(S);
				for(Activity act:acts){
					if(Ec<=S){
						act.P='C';
						Ec = act.E;
					} else if(Ej<=S){
						act.P='J';
						Ej = act.E;
					} else {
						isImpossible = true;
						break;
					}
				}
			}
			if(isImpossible)
				System.out.println("Case #" + x + ": IMPOSSIBLE");
			else{
				StringBuffer sb = new StringBuffer();
				for (int i=0;i<activities.size();i++){
					Activity act = activities.get(i);
					sb.append(act.P);
				}
				
				System.out.println("Case #" + x + ": " + sb.toString());
			}
		}
	}
	
	static class Activity{
		public Activity(int s, int e) {
			S=s;
			E=e;
		}
		int S;
		int E;
		char P;
	}
}
