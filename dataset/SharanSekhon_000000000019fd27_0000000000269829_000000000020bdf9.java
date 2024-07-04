public class Solution {
	public static class pair{
		int start;
		int end;
		public pair(int x,int y) {
			// TODO Auto-generated constructor stub
			start = x;
			end = y;
		}
	}
	public static boolean can_hold(pair k,pair m) {
		if(k.end<=m.start) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test = sf.nextInt();
		for (int i = 1; i <=test; i++) {
			int act = sf.nextInt();
			int[][] activities = new int[act][3];
			for (int j = 0; j < activities.length; j++) {
				activities[j][0] = sf.nextInt();
				activities[j][1] = sf.nextInt();
				activities[j][2] = j;
			}
			Arrays.parallelSort(activities,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[1]<o2[1]) {
						return -1;
					}
					else if(o1[1]>o2[1]) {
						return 1;
					}
					return 0;
				}
			});
			Stack<pair> sc1 = new Stack<pair>();
			Stack<pair> sc2 = new Stack<pair>();
			sc1.add(new pair(0,0));
			sc2.add(new pair(0,0));
			int flag = 0;
			StringBuilder ans = new StringBuilder();
			for (int j = 0; j < activities.length; j++) {
				ans.append("A");
			}
			for (int j = 0; j < activities.length; j++) {
				pair temp = new pair(activities[j][0], activities[j][1]);
				if(can_hold(sc1.peek(),temp)) {
					sc1.pop();
					sc1.add(temp);
					ans.replace(activities[j][2], activities[j][2]+1, "J");
				}
				else if(can_hold(sc2.peek(),temp)) {
					sc2.pop();
					sc2.add(temp);
					ans.replace(activities[j][2], activities[j][2]+1, "C");
					}
				else {
					flag = 1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("Case #"+i+": "+ans);
			}
			else {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
		}
		sf.close();
	}

}
