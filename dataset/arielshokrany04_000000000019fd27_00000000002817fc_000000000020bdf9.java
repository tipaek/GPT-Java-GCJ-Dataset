import java.util.Scanner;
import java.io.*;
class Solution {
	public static String out;
	public static int[] start;
	public static int[] end;
		static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {
		    int T = Integer.valueOf(input.nextLine());
		    String out = "";
		    for (int i = 1; i <= T; ++i) {
		    	int N =Integer.valueOf(input.nextLine());
		    	start = new int[N];
		    	end = new int[N];
		    	for (int j = 0; j < N; j++) {
					addTime(input.nextLine(),j);
				}
		    	out+=solve(i,N)+"\n";
		    }
		    System.out.println(out);
	}
	public static void addTime(String time,int place) {
		String[] times = time.split(" ");
		start[place] = Integer.valueOf(times[0]);
		end[place] = Integer.valueOf(times[1]);
	}
	public static String solve(int num,int count) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < end.length; i++) {
			for (int j = 1; j < end.length; j++) {
					if(start[j] > start[i] && start[j-1] > start[i] && start[j] < end[i] && start[j-1] < end[i]) {
						return "Case #"+num+": IMPOSSIBLE";
				}
			}
		}
		for (int i = 0; i < end.length; i++) {
			System.out.println(start[i]+ " "+end[i]);
		}
		out.append('C');
		char temp = ' ';
			for (int j = 1; j < count; j++) {
				if(start[j] <= end[j-1] && end[j] >= start[j-1])
					temp = 'J';
				else
					temp = 'C';
				out.append(temp);
			}
		return "Case #"+num+": "+out.toString();
	}

}
