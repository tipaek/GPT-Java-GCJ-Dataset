import java.io.*;
import java.util.*;
import java.util.Arrays;
public class Solution{
	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=t;i++) {
			int N = Integer.parseInt(sc.nextLine());
			Activity[]test=new Activity[N];
			
			for(int j=0;j<N;j++) {
				String []st = (sc.nextLine().split(" "));
				int start = Integer.parseInt(st[0]);
				int end = Integer.parseInt(st[1]);
				test[j]=new Activity(start,end,j);
			}
			Arrays.sort(test,(a,b)->a.start-b.start);
			
			
			char []output=new char[N];
			boolean []C=new boolean[1440];
			boolean[]J = new boolean[1440];
			
			boolean possible = true;
			int lastAssigned = 0;
			for(int a=0;a<N;a++) {
				
				
				if(test[a].start>=lastAssigned) {
					test[a].person="C";
					lastAssigned = test[a].end;
				}
				
				
		
			}
			lastAssigned=0;
			for(int a=0;a<N;a++) {
				if(test[a].person==null&&test[a].start>=lastAssigned) {
					test[a].person="J";
					lastAssigned = test[a].end;
				}
			}
			for(int a=0;a<N;a++) {
				if(test[a].person==null) {
					possible=false;
				}
			}
			Arrays.sort(test,(a,b)->a.index-b.index);
				if(possible) {
					StringBuilder real =new StringBuilder();
					for(int o=0;o<test.length;o++) {
						real.append(test[o].person);
					}
					System.out.println("Case #"+i+": "+real);
					

				}
				else {
					System.out.println("Case #"+i+": IMPOSSIBLE");
				}
			
		}
		
	}
	
	
}
class Activity {
	int start;
	int end;
	int index;
	String person;
	public Activity(int start, int end, int index) {
		this.start=start;
		this.end=end;
		this.index=index;
		
	}
}