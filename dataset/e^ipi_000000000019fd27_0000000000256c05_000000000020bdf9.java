import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        while (t-- > 0) {
            int N = sc.nextInt();
			List<Activity> activities = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				activities.add(new Activity(i, sc.nextInt(), sc.nextInt()));
			}
			
			activities.sort((a, b) -> Integer.compare(a.start, b.start));
			
			List<Activity> C = new ArrayList<>();
			List<Activity> J = new ArrayList<>();
			
			boolean impossible = false;
			for (Activity act : activities) {
				if (C.isEmpty() || (C.get(C.size() - 1).end <= act.start)) {
					C.add(act);
				} else if (J.isEmpty() || (J.get(J.size() - 1).end <= act.start)) {
					J.add(act);
				} else {
					System.out.println("Case #" + (T - t) + ": IMPOSSIBLE");
					impossible = true;
					break;
				}
			}
			
			if (!impossible) {
				C.sort((a, b) -> Integer.compare(a.id, b.id));
				J.sort((a, b) -> Integer.compare(a.id, b.id));
				StringBuilder output = new StringBuilder();
				while (!C.isEmpty() || !J.isEmpty()) {
					if (J.isEmpty()) {
						for (int i =0; i < C.size(); i++) {
							output.append("C");
						}
						break;
					}
					
					if (C.isEmpty()) {
						for (int i =0; i < J.size(); i++) {
							output.append("J");
						}
						break;
					}
					
					if (C.get(0).id < J.get(0).id) {
						output.append("C");
						C.remove(0);
					} else {
						output.append("J");
						J.remove(0);
					}
				}
				System.out.println("Case #" + (T - t) + ": " + output.toString());
			}
        }

    }
	
	public static class Activity {
		int id;
		int start;
		int end;
		
		Activity (int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
		
	}
}