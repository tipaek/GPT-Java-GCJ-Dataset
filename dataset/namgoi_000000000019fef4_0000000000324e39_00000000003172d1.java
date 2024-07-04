import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			HashMap<Double , Integer> cut = new HashMap<Double, Integer>();
			st = new StringTokenizer(br.readLine());
			int x = 1;
			for (int i = 0; i < n; i++) {
				double tmp = Double.parseDouble(st.nextToken());
				if(cut.containsKey(tmp)) {
					cut.put(tmp, cut.get(tmp)+1);
					if(cut.get(tmp)>x) {
						x=cut.get(tmp);
					}
				}else {
					cut.put(tmp, 1);	
				}
			}
			int answer = d-1;
			if(x>=d) {
				answer =0;
			}else{
				key1:for (Double key1 :cut.keySet()) {
					int cutcnt=0;
					int person=0;
					for (Double key2 :cut.keySet()) {
						if(key1> key2) continue; 
						if(key1==key2) {
							person+=cut.get(key2);
							continue;
						}
						int slice = (int) (key2/key1);
						if(slice==1) {
							person+=cut.get(key2);
							cutcnt+=cut.get(key2);
							continue;
						}else {
							person+=slice*cut.get(key2);
							if(key1*(double) slice ==key2) {
								cutcnt+=(slice-1)*cut.get(key2);	
							}else {
								cutcnt+=slice*cut.get(key2);
							}
						}
						if(answer<cutcnt) continue key1;
						if(person>=d) break;
					}
					if(person>=d && answer>cutcnt) answer=cutcnt;
				}
			}
			System.out.println("Case #"+testcase+": "+answer);	
		}
	}
	/*
4
1 3
1
5 2
10 5 359999999999 123456789 10
2 3
8 4
3 2
1 2 3


1
3 3
1 2 3

6
1 3
100
2 3
100 100
3 3
100 100 100
1 3
1
2 3
1 2
3 3
1 2 3

*/
}