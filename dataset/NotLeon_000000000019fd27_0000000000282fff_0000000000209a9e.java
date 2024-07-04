import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), b = sc.nextInt();
		for(int l = 1; l <= t; ++l){
			int same = -1, dif = -1;
			int ps = -1, pd = -1;
			int [] cur = new int[b];
			int cnt = 0;
			for(int i = 0; i < b; ++i)cur[i] = -1;
			for(int i = 0; i < b/2 ; ++i){
				if(cnt == 5){
					if(same > -1 && dif > -1){
						System.out.println(same+1);
						System.out.flush();
						int cs = sc.nextInt();
						System.out.println(dif+1);
						System.out.flush();
						cnt++;
						int cd = sc.nextInt();
						if(cs == ps && cd != pd)rev(cur);
						else if(cs != ps && cd != pd)comp(cur);
						else if(cs != ps && cd == pd){
							comp(cur);
							rev(cur);
						}
						ps = cs;
						pd = cd;
					}else if(same > -1){
						System.out.println(same+1);
						System.out.flush();
						int cs = sc.nextInt();
						System.out.println(same+1);
						System.out.flush();
						int thr = sc.nextInt();
						cnt++;
						if(cs != ps) comp(cur);
						ps = cs;
					}else if(dif > -1){
						System.out.println(dif+1);
						System.out.flush();
						int cd = sc.nextInt();
						System.out.println(dif+1);
						System.out.flush();
						int thr = sc.nextInt();
						cnt++;
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
				cnt ++;
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
			if(ok.equals("N"))break;
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