import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int t=1;t<=test_case;t++) {
			int l,r,flag=0;
			int[] user = new int[2];
			int n = sc.nextInt();
			char[] res = new char[n];
			Map<Integer, Integer> map = new HashMap<Integer,Integer>();
			Map<Integer, Integer> order = new HashMap<Integer,Integer>();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				l = sc.nextInt();
				r = sc.nextInt();
				list.add(l);
				map.put(l,r);
				order.put(l,i);
			}
			list.sort(null);
			for (int e : list) {
				if(e >= user[flag]) {
					user[flag] = map.get(e);
					if(flag==0) res[order.get(e)] = 'C';
					else res[order.get(e)] = 'J';
				}else {
					flag = (flag+1)%2;
					if(e < user[flag]) {
						flag = -1;
						break;
					}
					user[flag] = map.get(e);
					if(flag==0) res[order.get(e)] = 'C';
					else res[order.get(e)] = 'J';
				}
			}
			if(flag == -1) System.out.println("Case #" + t + ": IMPOSSIBLE");
			else System.out.println("Case #" + t + ": " + String.copyValueOf(res));
		}
		
	}
}
