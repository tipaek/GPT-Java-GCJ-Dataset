import java.util.*;

public class Solution {
	static Scanner CONSOLE = new Scanner(System.in);
	static class Act{
		int s;
		int e;
		int index;

		Act(int i, int s, int e){
			this.s = s;
			this.e = e;
			index = i;
		}
		int compareTo(Act act) {
			int compareQ = act.s;
			return this.s - compareQ;
		}
		static Comparator<Act> actCom= new Comparator<Act>(){
			public int compare(Act a1, Act a2) {
				return a1.compareTo(a2);
			}
		};
	}
	static class Time{
		int s;
		int e;
		Time(int s,int e){
			this.s= s;
			this.e= e;
		}
	}
	static class Timeline {
		
		ArrayList<Time> time = new ArrayList<Time>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		void addTo(Act a) {
			time.add(new Time(a.s,a.e));			
			index.add(a.index);
		}
	}
	static String Schedule(ArrayList<Act> act,int n) {
		Timeline tl = new Timeline();
		Timeline tl2 = new Timeline();
		for (Act a:act) {
			if (tl.time.isEmpty()) {
				tl.addTo(a);
				continue;
			}
			Act promise=null;
			Iterator<Time> iter = tl.time.iterator();
			Time t = iter.next();
			do {
				if (a.s>=t.e) {
					Time tNext=iter.hasNext()?iter.next():null;
					if (tNext==null||a.e<=tNext.s) {
						tl.addTo(a);
						promise = a;
						break;
					}
					t=tNext;
					continue;
				}
				t=iter.hasNext()?iter.next():null;
				
			}while (iter.hasNext()||t!=null);
			if (promise!=null) continue;
			if (tl2.time.isEmpty()) {
				tl2.addTo(a);
				continue;
			}
			iter = tl2.time.iterator();
			t = iter.next();
			do {
				if (a.s>=t.e) {
					Time tNext = iter.hasNext()?iter.next():null;
					if (tNext==null||a.e<=tNext.s) {	
						tl2.addTo(a);
						promise = a;
						break;
					}
					t=tNext;	
					continue;
				}
				t=iter.hasNext()?iter.next():null;
			}while (iter.hasNext()||t!=null);
			if (promise==null) return "IMPOSSIBLE";
		}
		char[] result = new char[n];
		Arrays.fill(result, 'J');
		for (Integer i: tl.index) result[i]='C';
		String resultString = "";
		for (char c:result) resultString +=c;
		return resultString;
	}
	static String getTest() {
		int n = CONSOLE.nextInt();
		ArrayList<Act> activities = new ArrayList<Act>();
		for (int i=0;i<n;i++) {
			int s = CONSOLE.nextInt();
			int e = CONSOLE.nextInt();
			activities.add(new Act(i,s,e));
		}
		Collections.sort(activities, Act.actCom);;
		return Schedule(activities,n);
	}
	static void printResult(String[] result) {
		int index=1;
		for (String s:result) {
			System.out.printf("Case #%d: %s\n", index, s);
			index++;
		}
	}
	public static void main(String[]args) {
		int test = CONSOLE.nextInt();
		String[] result = new String[test];
		for (int i=0;i<test;i++) {
			result[i] = getTest();
		}
		printResult(result);
	}
}
