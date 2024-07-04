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
			double[] num = new double[n];
			st = new StringTokenizer(br.readLine());
			int x = 1;
			for (int i = 0; i < n; i++) {
				num[i]= Double.parseDouble(st.nextToken());
			}
			int answer = d-1;
			Arrays.sort(num);
			key1:for (int i = 0; i < n; i++) {
				int cutcnt=0;
				int person=0;
				double key1=num[i];
				for (int j = i; j < n; j++) {
					double key2=num[j];
					if(key1> key2) continue; 
					if(key1==key2) {
						person++;
						if(person==d) {
							break;
						}
					}else {
						int slice = (int) (key2/key1);
						if(slice==1) {
							person++;
							cutcnt++;
						}else {
							person+=slice;
							if(key1*(double) slice ==key2) {
								cutcnt+=(slice-1);
								if(person>d) {
									cutcnt=cutcnt-(person-d)+1;
									break;
								}
							}else {
								cutcnt+=slice;
								if(person>d) {
									cutcnt=cutcnt-(person-d);
									break;
								}
							}
						}
					}
					if(answer<cutcnt) continue key1;
					if(person==d) {
						break;
					}
				}
				if(person>=d && answer>cutcnt) answer=cutcnt;
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

1
10 2
3 4 5 6 7 8 9 10 11 12

1
10 3
4 4 5 6 7 8 9 10 11 7

1
10 3
1 2 1 1 1 1 1 1 1 1

*/
}