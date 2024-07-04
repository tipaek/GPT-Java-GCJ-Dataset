import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S = new Scanner(System.in);
		int T = S.nextInt();
		int case_num = 1;
		while (T > 0) {
			int N = S.nextInt();
			ArrayList<Pair> arr = new ArrayList<Pair>();
			for (int i = 0; i < N; i++) {
				Pair p = new Pair(S.nextInt(), S.nextInt(), i);
				arr.add(p);
			}
			solve(N, arr, case_num);
			T--;
			case_num++;
		}
	}

	static void solve(int N, ArrayList<Pair> list, int case_num) {
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				if (o1.S > o2.S) {
					return 1;
				} else if (o1.S == o2.S) {
					if (o1.E > o2.E) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});

		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<ans> res =new ArrayList<>();
		ans a = new ans('J', list.get(0).index);
		res.add(a);
		map.put('J', list.get(0).E);
		
		for (int i = 1; i < list.size(); i++) {
			if (map.get('J') <= list.get(i).S) {
				map.put('J', list.get(i).E);
				ans temp=new ans('J',list.get(i).index);
				res.add(temp);
				continue;
			} else {
				if (!map.containsKey('C')) {
					map.put('C', list.get(i).E);
					ans temp=new ans('C',list.get(i).index);
					res.add(temp);
					continue;
				} else if (map.get('C') <= list.get(i).S) {
					ans temp=new ans('C',list.get(i).index);
					map.put('C', list.get(i).E);
					res.add(temp);
					continue;
				} else {
					String temp = "IMPOSSIBLE";
					System.out.println("Case #" + case_num + ": " + temp);
					return;
				}
			}
		}

		Collections.sort(res,new Comparator<ans>() {

			@Override
			public int compare(ans o1, ans o2) {
				// TODO Auto-generated method stub
				if(o1.idx>o2.idx) {
					return 1;
				}else {
					return -1;
				}
			}
			
		});
		
		String endres="";
		for(int i=0;i<res.size();i++) {
			endres+=res.get(i).c;
		}
		System.out.println("Case #" + case_num + ": " + endres);

	}

}

class Pair {
	int S, E, index;

	Pair(int S, int E, int index) {
		this.S = S;
		this.E = E;
		this.index = index;
	}
}

class ans {
	char c;
	int idx;

	ans(char c, int idx) {
		this.c = c;
		this.idx = idx;
	}
}
