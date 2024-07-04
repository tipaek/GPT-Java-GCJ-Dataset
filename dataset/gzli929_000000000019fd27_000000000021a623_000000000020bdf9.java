import java.util.*;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static Time[] nums;
	static int len;

	public static void main(String[] args) {
		int tC = sc.nextInt();
		//sc.nextLine();

		for (int t = 1; t <= tC; t++) {
			
			System.out.print("Case #" + t + ": ");
			int d = sc.nextInt();
			
			nums = new Time[d];
			for(int i = 0; i < d; i++) {
				int c = sc.nextInt();
				int e = sc.nextInt();
				nums[i] = new Time(c,e);
				//System.out.println(nums[i]);
			}
			
			boolean a = exp(new ArrayList<Time>(d),new ArrayList<Time>(d),"",d);

			if(!a) {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
	
	public static boolean exp(ArrayList<Time> c, ArrayList<Time> j,String print, int depth) {
		if(depth == 0) {
			System.out.println(print);
			return true;
		}
		
		Time p = nums[nums.length-depth];
		//System.out.println(nums.length + " " + depth);
		//System.out.println(nums[0]);
		
		boolean worked = false;
		boolean yes = works(c,p);
		
		if(yes) {
			c.add(p);
			Collections.sort(c);
			print += "C";
			worked = exp(c,j,print,depth-1);
		}
		
		c.remove(p);
		
		if(worked) {
			return true;
		}
		
		yes = works(j,p);
		
		if(yes) {
			j.add(p);
			Collections.sort(j);
			print += "J";
			worked = exp(c,j,print,depth-1);
		}
		
		j.remove(p);
		
		return worked;
	}
	
	public static boolean works(ArrayList<Time> a, Time b) {
		a.add(b);
		Collections.sort(a);
		
		for(int i = 0; i < a.size()-1; i++) {
			if(a.get(i).end > a.get(i+1).start) {
				//System.out.println("no" + a);
				a.remove(b);
				
				return false;
			}
		}
		//System.out.println("yes" + a);

		a.remove(b);
		return true;
	}
	
	public static class Time implements Comparable{
		
		int start;
		int end;
		
		public Time(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Object o) {
			Time t = (Time) o;
			return start - t.start;
		}
		
		public String toString() {
			return start + " " + end;
		}
		
	}
}
