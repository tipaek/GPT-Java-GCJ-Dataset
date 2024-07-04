import java.util.*;
import java.io.*;

public class Solution {
	private static int b;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			int[] x = new int[b+1];
			Arrays.fill(x,-1);
			x[0]=0;
			int cnt = 0;
			ArrayList<int[]> list = new ArrayList<int[]>();
			list.add(x);
			int[] answer = null;
			while_loop:while (true) {
				for (int i = 1; i <=b; i++) {
					System.out.println(i);
					System.out.flush();
					cnt=(cnt+1)%10;
					int read = Integer.parseInt(br.readLine());
					if(cnt>1 && cnt==1) {
						for(int[] y:list) {
							list.add(trans_a(y));
							list.add(trans_b(y));
							list.add(trans_b(trans_a(y)));
						}
					}
					for(int index=0;index<list.size();index++) {
						int[] y = list.get(index);
						if(y[i]==-1) {
							y[i]=read;
							y[0]++;
						}else if(y[i]!=read) {
							list.remove(index);
							index--;
						}else if(y[0]==b) {
							answer=y;
							break while_loop;
						}
					}
				}
			}
			for (int i = 1; i <=b; i++) {
				System.out.print(answer[i]);
			}
			System.out.println();
			System.out.flush();
		}
	}

	private static int[] trans_a(int[] x) {
		int[] new_int = new int[b+1];
		for (int i = 1; i <=b; i++) {
			if(x[i]==0) {
				new_int[i]=1; 
			}
		}
		return new_int;
	}
	private static int[] trans_b(int[] x) {
		int[] new_int = new int[b+1];
		int swap =0;
		for (int i = 1; i <=b/2; i++) {
			swap=new_int[i]; 
			new_int[i]=new_int[b-i+1];
			new_int[b-i+1]=swap;
		}
		return new_int;
	}
}
