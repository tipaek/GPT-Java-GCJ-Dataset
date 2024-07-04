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
			while_loop:while (true) {
				for (int i = 0; i <b; i++) {
					cnt++;
					System.out.println(i+1);
					System.out.flush();
					char read = br.readLine().charAt(0);
					if(cnt>1 && (cnt)%10==1) {
						for(StringBuilder y:list) {
							list.add(trans_a(y));
							list.add(trans_b(y));
							list.add(trans_a(trans_b(y)));
						}
					}
					for(StringBuilder y:list) {
						if(y.charAt(i)=='2') {
							y.setCharAt(i, read);
						}else if(y.charAt(i)!=read) {
							remove_list.add(y);
							continue;
						}
					}
					for(StringBuilder y:remove_list) {
						list.remove(y);
					}
					remove_list.clear();
					if(list.size()==1 && (cnt%10)>5) {
						for(StringBuilder y:list) {
							if(y.indexOf("2")<0) {
								answer=y;
								break while_loop;	
							}
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
