import java.util.Scanner;

public class Solution {

	static boolean checkCalender(int[] calender,int start,int end) {
		for(int i=start;i<end;i++) {
			if(calender[i]==1) {
				return false;
			}
		}
		return true;
	}
	
	static int[] fillCalender(int[] calender,int start,int end) {
		for(int i=start;i<end;i++) {
			calender[i]=1;
		}
		return calender;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c=0;c<t;c++) { // for each case
			int[] C = new int[1440];
			int[] J = new int[1440];
			String order = "";
			int events = sc.nextInt();
			for(int i=0;i<events;i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if(checkCalender(C,start,end)) {
					fillCalender(C,start,end);
					order = order+"C";
				}else if(checkCalender(J,start,end)) {
					fillCalender(J,start,end);
					order = order+"J";
				}else {
					order = "IMPOSSIBLE";
					break;
				}
			}
			System.out.printf("Case #%d: %s\n",c+1,order);
		}
		sc.close();
	}
	
	
}
