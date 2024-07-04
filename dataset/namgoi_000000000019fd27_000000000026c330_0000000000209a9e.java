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
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <=b; i++) {
				sb.append("2");
			}
			int cnt = 0;
			TreeSet<StringBuilder> list = new TreeSet<StringBuilder>(new Comparator<StringBuilder>() {
				@Override
				public int compare(StringBuilder o1, StringBuilder o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			TreeSet<StringBuilder> remove_list = new TreeSet<StringBuilder>(new Comparator<StringBuilder>() {
				@Override
				public int compare(StringBuilder o1, StringBuilder o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			list.add(sb);
			StringBuilder answer = new StringBuilder();
			int kkk = b-1;
			while_loop:while (true) {
				for (int i = 0; i <b; i++) {
					cnt=(cnt+1)%b;
					int cur = kkk-i;
					if(list.size()==1) {
						for(StringBuilder y:list) {
							if(y.indexOf("2")>=0) {
								if(y.charAt(cur)=='2') {
									break;
								}
								cur=(cur+1)%b;
							}
						}
					}					
					System.out.println(cur+1);
					System.out.flush();
					char read = br.readLine().charAt(0);
					for(StringBuilder y:list) {
						if(y.charAt(cur)=='2') {
							y.setCharAt(cur, read);
						}else if(y.charAt(cur)!=read) {
							remove_list.add(y);
						}
					}
					for(StringBuilder y:remove_list) {
						list.remove(y);
					}
					remove_list.clear();
					if(list.size()==1) {
						for(StringBuilder y:list) {
							if(y.indexOf("2")<0) {
								answer=y;
								break while_loop;	
							}
						}
					}
					if(cnt==0) {
						for(StringBuilder y:list) {
							list.add(trans_a(y));
							list.add(trans_b(y));
							list.add(trans_a(trans_b(y)));
						}
					}
				}
			}
			System.out.println(answer);
			System.out.flush();
			String result = br.readLine();
		}
	}

	private static StringBuilder trans_a(StringBuilder x) {
		StringBuilder y= new StringBuilder(x);
		for (int i = 0; i <b; i++) {
			if(y.charAt(i)=='0') {
				y.setCharAt(i, '1'); 
			}else if(y.charAt(i)=='1') {
				y.setCharAt(i, '0'); 
			}
		}
		return y;
	}
	private static StringBuilder trans_b(StringBuilder x) {
		return new StringBuilder(x).reverse();
	}
}
