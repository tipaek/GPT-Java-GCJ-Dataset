import java.util.*;
import java.io.*;

public class Solution {
//public class codejam3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			ArrayList<int[]> arr = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new int[] {i, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			arr.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1]>o2[1]) return 1;
					if(o1[1]<o2[1]) return -1;
					if(o1[2]>o2[2]) return 1;
					if(o1[2]<o2[2]) return -1;
					return 0;
				}
			});
			int J = 0;
			int C = 0;
			char[] answer = new char[N];
			boolean ispossible = true;
			for (int[] is : arr) {
				if(C>J) {
					if(is[1] >= J) {
						J=is[2];
						answer[is[0]]='J';
					}else {
						ispossible=false;
						break;
					}
				}else {
					if(is[1] >= C) {
						C=is[2];
						answer[is[0]]='C';
					}else {
						ispossible=false;
						break;
					}
				}
			}
			if(ispossible) {
				System.out.println("Case #"+testcase+": "+ new String(answer) );
			}else {
				System.out.println("Case #"+testcase+": IMPOSSIBLE");
			}
		}
	}
}
