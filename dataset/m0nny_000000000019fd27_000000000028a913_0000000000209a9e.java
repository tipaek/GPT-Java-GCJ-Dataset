import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int b = sc.nextInt();
		for(int i = 1; i <= t; i++){
			int[] res = new int[b];
			Arrays.fill(res, -1);
			int queries = 0;
			int index = 1;
			int same = -1;
			int diff = -1;
			while(queries <= 150 && index <= b/2) {
				if(queries%10 == 0) {
					boolean sChange = false;
					boolean dChange = false;
					if(same != -1 && diff != -1) {
						int beforeS = res[same];
						queries++;
						query(same+1);
						int afterS = sc.nextInt();
						if(beforeS != afterS) sChange = true;
						int beforeD = res[diff];
						queries++;
						query(diff+1);
						int afterD = sc.nextInt();
						if(beforeD != afterD) dChange = true;
						if(sChange && dChange) res = update(res, false, true);
						else if (sChange && !dChange) res = update(res, true, true);
						else if (!sChange && dChange) res = update(res, true, false);
					}
					else if(same != -1 && diff == -1) {
						int beforeS = res[same];
						queries+=2;
						query(same+1);
						int afterS = sc.nextInt();
						query(same+1);
						afterS = sc.nextInt();
						if(beforeS != afterS) res = update(res, false, true);
					}
					else if(same == -1 && diff != -1) {
						int beforeD = res[diff];
						queries+=2;
						query(diff+1);
						int afterD = sc.nextInt();
						query(diff+1);
						afterD = sc.nextInt();
						if(beforeD != afterD) res = update(res, true, false); 
					}
					
				}
				queries++;
				query(index);
				int cur = sc.nextInt();
				res[index-1] = cur;
				queries++;
				query(b+1-index);
				int opp = sc.nextInt();
				res[b-index] = opp;
				if(cur == opp) same = index-1;
				else		   diff = index-1;
				index++;
			}
			String ans = "";
			for(int j = 0; j < b; j++) {
				ans += Integer.toString(res[j]);
			}
			System.out.println(ans);
			System.out.flush();
			if(sc.next().charAt(0) == 'N') break;
		}
	}
	static int[] update(int[] res, boolean r, boolean c) {
		if(c) {
			for(int i = 0; i < res.length; i++) {
				if(res[i] != -1) {
					if(res[i] == 0) res[i] = 1;
					else			res[i] = 0;
				}
			}
		}
		if(r) {
			for(int i = 0; i < res.length/2; i++) {
				if(res[i] != -1) {
					int temp = res[i];
					res[i] = res[res.length-i-1];
					res[res.length-i-1] = temp;
				}
			}
		}
		return res;
	}
	static void query(int index) {
		System.out.println(index);
		System.out.flush();
	}
}