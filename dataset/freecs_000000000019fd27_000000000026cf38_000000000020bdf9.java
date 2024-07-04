import java.util.*;
import java.io.*;

public class Solution{
	
	public void solve(int test, Scanner sc){
		int n = sc.nextInt();
		
		Pair[] times = new Pair[2*n];
		for(int i=0; i<n; i++){
			times[i] = new Pair(sc.nextInt(), true, i);
			times[n+i] = new Pair(sc.nextInt(), false, i);
		}
		
		Arrays.sort(times, new Comparator<Pair>(){
			public int compare(Pair p1, Pair p2){
				if(p1.time < p2.time){
					return -1;
				}
				else if(p1.time > p2.time){
					return 1;
				}
				else if(p1.start && !p2.start){
					return 1;
				}
				else if(!p1.start && p2.start){
					return -1;
				}
				else{
					return 0;
				}
			}
		});
		
		boolean cam = false;
		boolean jam = false;
		boolean possible = true;
		
		char[] res = new char[n];
		
		for(int i=0; i<(2*n); i++){
			if(times[i].start){
				if(!cam){
					cam = true;
					res[times[i].index] = 'C';
				}
				else if(!jam){
					jam = true;
					res[times[i].index] = 'J';
				}
				else{
					possible = false;
					break;
				}
			}
			else{
				if(res[times[i].index] == 'C'){
					cam = false;
				}
				else{
					jam = false;
				}
			}
		}
		
		String result = "IMPOSSIBLE";
		if(possible){
			result = new String(res);
		}
		
		System.out.println("Case #"+test+": "+result);
	}
	
	public Solution(){
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
        
        for(int t=1; t<=tests; t++){
			solve(t, sc);
        }
	}
	
	public static void main(String[] args){
		new Solution();
	}
}
class Pair{
	public int time;
	public boolean start;
	public int index;
	
	public Pair(int time, boolean start, int index){
		this.time = time;
		this.start = start;
		this.index = index;
	}
}