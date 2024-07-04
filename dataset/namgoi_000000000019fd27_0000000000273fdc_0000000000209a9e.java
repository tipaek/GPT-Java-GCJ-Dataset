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
			ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
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
					if(list.get(0).indexOf("2")>=0) {
						cur = list.get(0).indexOf("2");
					}					
					System.out.println(cur+1);
					System.out.flush();
					char read = br.readLine().charAt(0);
					for (int index = 0; index < list.size(); index++) {
						StringBuffer y=list.get(index);
						if(y.charAt(cur)=='2') {
							y.setCharAt(cur, read);
						}else if(y.charAt(cur)!=read) {
							list.remove(index);
							index--;
						}
					}
					if(list.size()==1) {
						for(StringBuffer y:list) {
							if(y.indexOf("2")<0) {
								answer=y;
								break while_loop;	
							}
						}
					}
					if(cnt==0) {
						int list_size= list.size();
						for (int index = 0; index < list_size; index++) {
							StringBuffer y=list.get(index);
							StringBuffer ta=trans_a(y);
							StringBuffer tb=trans_b(y);
							StringBuffer tc=trans_b(ta);
							boolean ta_contain=false;
							boolean tb_contain=false;
							boolean tc_contain=false;
							if(ta.toString().contentEquals(tb.toString())) tb_contain=true;
							if(ta.toString().contentEquals(tc.toString())) tc_contain=true;
							if(tb.toString().contentEquals(tc.toString())) tc_contain=true;
							for(StringBuffer yy:list) {
								if(!ta_contain && yy.toString().contentEquals(ta.toString())) ta_contain=true;
								if(!tb_contain && yy.toString().contentEquals(tb.toString())) tb_contain=true;
								if(!tc_contain && yy.toString().contentEquals(tc.toString())) tc_contain=true;
							}
							if(!ta_contain){
								list.add(ta);	
							}
							if(!tb_contain) {
								list.add(tb);
							}
							if(!tc_contain) {
								list.add(tc);
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
