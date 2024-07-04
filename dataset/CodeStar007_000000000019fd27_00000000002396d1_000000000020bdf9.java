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
		int case_num = 0;
		while (T > 0) {
			int N = S.nextInt();
			ArrayList<Pair> arr = new ArrayList<Pair>();
			for (int i = 0; i < N; i++) {
				Pair p = new Pair(S.nextInt(), S.nextInt());
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

		String ans = "J";
		map.put('J', list.get(0).E);

		for (int i = 1; i < list.size(); i++) {
			if (map.get('J') <= list.get(i).S) {
				map.put('J', list.get(i).E);
				ans += "J";
				continue;
			} else {
				if (!map.containsKey('C')) {
					map.put('C',list.get(i).E);
					ans += "C";
					continue;
				}else if(map.get('C')<=list.get(i).E){
					map.put('C', list.get(i).E);
					ans+="C";
					continue;
				}else {
					ans = "IMPOSSIBLE";
					break;
				}
			}
		}

		System.out.println("Case #" + case_num + ": " + ans);

	}

}

class Pair {
	int S, E;

	Pair(int S, int E) {
		this.S = S;
		this.E = E;
	}
}
