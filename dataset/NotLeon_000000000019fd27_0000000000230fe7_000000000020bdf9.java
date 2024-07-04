import java.util.*;
public class Solution {
	static public class event implements Comparable<event>{
		int st, end, ind;
		event(int a, int b, int c){
			st = a;
			end = b;
			ind = c;
		}
		public int compareTo(event e){
			return this.st-e.st;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int l = 1; l <= t; ++l){
			int n = sc.nextInt();
			event [] evs = new event[n];
			int [] ans = new int[n];
			for(int i = 0; i < n; ++i){
				evs[i] = new event(sc.nextInt(), sc.nextInt(), i);
			}
			Arrays.sort(evs);
			int [] c = new int[24*60+5];
			int [] j = new int[24*60+5];
			boolean fl = false;
			for(int i = 0; i < n; ++i){
				if(c[evs[i].st] == 0){
					for(int k = evs[i].st; k < evs[i].end; ++k){
						c[k] = 1;
					}
					ans[evs[i].ind] = 0;
				}else if(j[evs[i].st] == 0){
					for(int k = evs[i].st; k < evs[i].end; ++k){
						j[k] = 1;
					}
					ans[evs[i].ind] = 1;
				}else{
					fl = true;
					break;
				}
			}
			System.out.print("Case #" + l + ": ");
			if(fl)System.out.print("IMPOSSIBLE");
			else{
				for(int i = 0; i < n; ++i){
					if(ans[i] == 0)System.out.print("C");
					else System.out.print("J");
				}
			}
			System.out.println();
		}
		
	}
}