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
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i <=b; i++) {
				sb.append("2");
			}
			int cnt = 0;
			TreeSet<StringBuffer> list = new TreeSet<StringBuffer>(new Comparator<StringBuffer>() {
				@Override
				public int compare(StringBuffer o1, StringBuffer o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			ArrayList<StringBuffer> remove_list = new ArrayList<StringBuffer>();
			list.add(sb);
			StringBuffer answer = new StringBuffer();
			int rev = b-1;
			int tmp =0;
			while_loop:while (true) {
				tmp++;
				if(list.size()==0) throw new Exception("list size 0");
				if(tmp>150) throw new Exception("query over 150");
				for (int i = 0; i <b; i++) {
					cnt=(cnt+1)%b;
					int cur = i;
					if(rev!=0) {
						cur = rev-cur;
						rev=0;
					}else {
						rev=b-1;
					}
					if(list.size()==1) {
						for(StringBuffer y:list) {
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
					for(StringBuffer y:list) {
						if(y.charAt(cur)=='2') {
							y.setCharAt(cur, read);
						}else if(y.charAt(cur)!=read) {
							remove_list.add(y);
						}
					}
					for(StringBuffer y:remove_list) {
						list.remove(y);
					}
					remove_list.clear();
					if(list.size()==1) {
						for(StringBuffer y:list) {
							if(y.indexOf("2")<0) {
								answer=y;
								break while_loop;	
							}
						}
					}
					if(cnt==0) {
						for(StringBuffer y:list) {
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

	private static StringBuffer trans_a(StringBuffer x) {
		StringBuffer y= new StringBuffer(x);
		for (int i = 0; i <b; i++) {
			if(y.charAt(i)=='0') {
				y.setCharAt(i, '1'); 
			}else if(y.charAt(i)=='1') {
				y.setCharAt(i, '0'); 
			}
		}
		return y;
	}
	private static StringBuffer trans_b(StringBuffer x) {
		return new StringBuffer(x).reverse();
	}
}
