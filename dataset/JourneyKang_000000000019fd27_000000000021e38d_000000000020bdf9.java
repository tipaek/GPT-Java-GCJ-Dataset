import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	static class Activity{
		int n;
		int s;
		int e;
	}
	static int T, N, S, E;
	static Activity a[] = new Activity[1002];
	static int p[] = new int[2];
	static char s[] = new char[1002];
	public static void main(String[] args) throws NumberFormatException, IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   	StringTokenizer st;
		T = Integer.parseInt(br.readLine());
	   	for(int i = 1; i <= 1000; i ++) {
	   		a[i] = new Activity();
	   	}
		for(int testcase = 1; testcase <= T; testcase++) {
	   		N = Integer.parseInt(br.readLine());
	   		p[0] = p[1] = 0; // C, J
	   		for(int n = 1; n <= N; n++) {
	   			st = new StringTokenizer(br.readLine());
	   			a[n].s = Integer.parseInt(st.nextToken());
	   			a[n].e = Integer.parseInt(st.nextToken());
	   			a[n].n = n;
	   		}
	   		Arrays.sort(a, 1, N+1, new Comparator<Activity>() {
				@Override
				public int compare(Activity a, Activity b) {
					return a.e - b.e;
				}
	   			
	   		});
	   		
	   		boolean possible = true;
	   		for(int i = 1; i <= N; i++) {
	   			if( p[0] <= a[i].s && p[1] <= a[i].s) {
	   				if(p[0] < p[1]) {
		   				p[1] = a[i].e;
		   				s[a[i].n] = 'J';
	   				}else {
		   				p[0] = a[i].e;
		   				s[a[i].n] = 'C';
	   				}
	   			}
	   			else if( p[0] <= a[i].s ) {
	   				p[0] = a[i].e;
	   				s[a[i].n] = 'C';
	   			}
	   			else if(p[1] <= a[i].s) {
	   				p[1] = a[i].e;
	   				s[a[i].n] = 'J';
	   			}
	   			else {
	   				possible = false;
	   				break;
	   			}
	   		}
	   		bw.write("Case #"+ testcase + ": ");
	   		if(!possible) {
	   			bw.write("IMPOSSIBLE");
	   		}else {
	   			for(int i = 1; i <= N; i++) {
	   				bw.write(s[i]);
	   			}
	   		}
   			bw.newLine();
	   		bw.flush();
	   	}
	   
	    br.close();
	    bw.close();
	
	}  
}
