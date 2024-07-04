import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			ArrayList<Activity> list = new ArrayList<>();
			for (int j=0;j<n;j++) {
				Activity a = new Activity();
				a.id=j;
				a.start=sc.nextInt();
				a.end=sc.nextInt();
				list.add(a);
			}
			System.out.println("Case #"+i+": "+solve(list));
		}
	}
	
	static String solve (List<Activity> list) {
		int n = list.size();
		char[] a = new char[n];
		int cEnd = 0;
		int jEnd = 0;
		list.sort(Comparator.comparing(x -> x.start));
		for (Activity x : list) {
			if (cEnd <= jEnd) {
				if (x.start >= jEnd) {
					a[x.id]='J';
					jEnd=x.end;
				} else if (x.start >= cEnd) {
					a[x.id]='C';
					cEnd=x.end;
				} else {
					return "IMPOSSIBLE";
				}
			} else {
				if (x.start >= cEnd) {
					a[x.id]='C';
					cEnd=x.end;
				} else if (x.start >= jEnd) {
					a[x.id]='J';
					jEnd=x.end;
				} else {
					return "IMPOSSIBLE";
				}
			}
		}
		return String.valueOf(a);
	}

}


class Activity {
	int id;
	int start;
	int end;
}
