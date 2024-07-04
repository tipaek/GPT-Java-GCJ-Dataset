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
		int t = sc.nextInt(), b = sc.nextInt();
		for(int l = 1; l <= t; ++l){
			System.out.println(1);
			System.out.flush();
			int thr = sc.nextInt();
			int same = -1, dif = -1;
			int ps = -1, pd = -1;
			int [] cur = new int[b];
			int cnt = 0;
			for(int i = 0; i < b; ++i)cur[i] = -1;
			for(int i = 0; i < b/2 ; ++i){
				if(cnt >= 10){
					if(same > 0 && dif > 0){
						System.out.println(same+1);
						System.out.flush();
						int cs = sc.nextInt();
						System.out.println(dif+1);
						cnt+=2;
						System.out.flush();
						int cd = sc.nextInt();
						if(cs == ps && cd != pd)rev(cur);
						else if(cs != ps && cd != pd)comp(cur);
						else if(cs != ps && cd == pd){
							comp(cur);
							rev(cur);
						}
						ps = cs;
						pd = cd;
					}else if(same > 0){
						System.out.println(same+1);
						cnt++;
						System.out.flush();
						int cs = sc.nextInt();
						if(cs != ps) comp(cur);
						ps = cs;
					}else if(dif > 0){
						System.out.println(dif+1);
						cnt++;
						System.out.flush();
						int cd = sc.nextInt();
						if(cd != pd) comp(cur);
						pd = cd;
					}
					cnt = 0;
				}
				System.out.println(i+1);
				System.out.flush();
				cur[i] = sc.nextInt();
				System.out.println(b-i);
				System.out.flush();
				cur[b-i-1] = sc.nextInt();
				cnt += 2;
				if(same == -1 && cur[i] == cur[b-i-1]){
					same = i;
					ps = cur[i];
				}
				if(dif == -1 && cur[i] != cur[b-i-1]){
					dif = i;
					pd = cur[i];
				}
			}
			for(int i = 0; i < b; ++i){
				System.out.print(cur[i]);
			}
			System.out.println();
			System.out.flush();
			sc.nextLine();
			String ok = sc.nextLine();
		}
	}
	static void comp(int [] cur){
		for(int i = 0; i < cur.length; ++i){
			if(cur[i] != -1)cur[i] = (cur[i]==0?1:0);
		}
	}
	static void rev(int [] cur){
		int sz = cur.length;
		for(int i = 0; i < sz/2; ++i){
			if(cur[i] != -1){
				int temp = cur[i];
				cur[i] = cur[sz-i-1];
				cur[sz-i-1] = temp;
			}
		}
	}
}