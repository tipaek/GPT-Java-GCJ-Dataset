import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int n;
	static Activity[] acts;
	static class Activity{
		
		public Activity() {
			
		}
		
		public Activity(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int x,y;
	}
	
	static ArrayList<Activity> listA;
	static ArrayList<Activity> listaB;
	
	private static boolean isNotOverlap(Activity a, Activity b) {
		return a.x > b.y || b.x > a.y;
	}
	
	private static boolean isNotOverlap(ArrayList<Activity> list, Activity act) {
		for(Activity a : list) {
			if(!isNotOverlap(a, act)) {
				return false;
			}
		}
		return true;
	}
	
	
	private static String testCase(Scanner in) {
		
		n = in.nextInt();
		acts = new Activity[n+1];
		listA = new ArrayList<>();
		listaB = new ArrayList<>();
		String s = "";
		
		for(int i = 1; i <= n; i++) {
			acts[i] = new Activity();
			acts[i].x = in.nextInt();
			acts[i].y = in.nextInt();
		}
		
		listA.add(acts[1]);
		s+="C";
		
		for(int i = 2; i <= n; i++) {
			if(isNotOverlap(listA, acts[i])) {
				listA.add(acts[i]);
				s+= "C";
			}else if (isNotOverlap(listaB, acts[i])) {
				listaB.add(acts[i]);
				s+="J";
			}else {
				return "IMPOSSIBLE";
			}
		}
		
		
		
		
		return s;
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			System.out.println("Case #"+ i + ": "+  testCase(in));
	    }
		
		

	}

	
}