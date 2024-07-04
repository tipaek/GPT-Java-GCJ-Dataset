import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


class Pair implements Comparable<Pair> {
	
	int start;
	int end;
	
	public Pair(int start,int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Pair o) {
		if(this.start!=o.start) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
	
}


public class Solution {
	

		
	public static void solve(Pair[] arr,int n,Pair[] initial,int k ,int t) {
		int cEnd = 0;
		int jEnd =0;
		
		HashMap<String, Character> map = new HashMap<String, Character>();
		for(int i = 0;i<n;i++) {
			if(cEnd<=arr[i].start) {
				
				if(map.containsKey(arr[i].start+"-"+arr[i].end+"-")) {
					//Impossible
					return;
				}else if(map.containsKey(arr[i].start+"-"+arr[i].end)) {
					map.put(arr[i].start+"-"+arr[i].end+"-", 'C');
				}else {
					map.put(arr[i].start+"-"+arr[i].end, 'C');
				}
				
				cEnd = arr[i].end;
				
			}else if(jEnd<=arr[i].start) {
				if(map.containsKey(arr[i].start+"-"+arr[i].end+"-")) {
					//Impossible
					System.out.println("Case #"+(k-t+1)+": IMPOSSIBLE");
					return;
				}else if(map.containsKey(arr[i].start+"-"+arr[i].end)) {
					map.put(arr[i].start+"-"+arr[i].end+"-", 'J');
				}else {
					map.put(arr[i].start+"-"+arr[i].end, 'J');
				}
				
				jEnd = arr[i].end;
				
			}else {
				//imposible
				System.out.println("Case #"+(k-t+1)+": IMPOSSIBLE");
				return;
				
			}
				
			
		}
		
		System.out.print("Case #"+(k-t+1)+": ");
		
		
		for(int i =0;i<n;i++) {
			
			if(map.containsKey(initial[i].start+"-"+initial[i].end+"-")) {
				
				System.out.print(map.get(initial[i].start+"-"+initial[i].end+"-"));
				map.remove(initial[i].start+"-"+initial[i].end+"-");
			}else if (map.containsKey(initial[i].start+"-"+initial[i].end)){
				System.out.print(map.get(initial[i].start+"-"+initial[i].end));
			}
			
			
		}
		
		
	}
	

    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int  t= s.nextInt();
	int k = t;
	
	while(t>0) {
		int n = s.nextInt();
		
		Pair[] arr = new Pair[n];
		Pair[] initial = new Pair[n];
		for(int i =0;i<n;i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			arr[i] = new Pair(start, end);
			initial[i] = new Pair(start, end);
		}
		
		Arrays.sort(arr);
		
		
		solve(arr,n , initial,k,t);
		System.out.println();
		
		t--;
	}
	s.close();
	
	
	}

}