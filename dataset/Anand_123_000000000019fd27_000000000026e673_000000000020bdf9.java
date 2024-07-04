import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int p = 1;
		while(t-->0) {
			int n = sc.nextInt();
			ArrayList<Activity> activity = new ArrayList<Activity>();
			ArrayList<Activity> original = new ArrayList<Activity>();
			for(int i=0;i<n;i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				Activity a = new Activity(s, e);
				activity.add(a);
				original.add(a);
			}
			Collections.sort(activity, new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					if(o1.s!=o2.s)
						return o1.s-o2.s;
					return o1.e-o2.e;
				}
			});
			HashMap<Integer,String> map = new HashMap<Integer, String>();
			int c_end = 0;
			int j_end = 0;
			String schedule = "";
			boolean impossible = false;
			for(int i=0;i<activity.size();i++) {
					if(activity.get(i).s>=c_end) {
						c_end = activity.get(i).e;
						map.put(activity.get(i).s, "C");
					}else if(activity.get(i).s>=j_end){
						j_end = activity.get(i).e;
						map.put(activity.get(i).s, "J");
					}else {
						impossible = true;
						break;
				}
			}
			for(int i=0;i<original.size();i++) {
				schedule = schedule + map.get(original.get(i).s);
			}
			if(!impossible)
				System.out.println("Case #"+p+": "+schedule);
			else
				System.out.println("Case #"+p+": "+"IMPOSSIBLE");
			p++;
		}
	}

}
class Activity{
	int s;
	int e;
	Activity(int s, int e){
		this.s = s;
		this.e = e;
	}
}