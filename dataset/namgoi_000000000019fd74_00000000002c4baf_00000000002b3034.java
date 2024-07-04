import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] strlist = new String[N];
			int[] strlen1 = new int[N];
			int[] strlen2 = new int[N];
			int[] strlen3 = new int[N];
			int[] strlen4 = new int[N];
			for (int i = 0; i < N; i++) {
				strlist[i] = br.readLine();
				strlen1[i]=0;
				strlen2[i]=strlist[i].length()-1;
				strlen3[i]=0;
				strlen4[i]=0;
			}
			StringBuilder a = new StringBuilder();
			StringBuilder b = new StringBuilder();
			Arrays.sort(strlist, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					char[] o1_tmp = o1.toCharArray();
					int o1_tmp_count = 0;
					for(int i=0;i<o1_tmp.length;i++){
						if(o1_tmp[i] == '*') o1_tmp_count++;
					}
					char[] o2_tmp = o2.toCharArray();
					int o2_tmp_count = 0;
					for(int i=0;i<o2_tmp.length;i++){
						if(o2_tmp[i] == '*') o2_tmp_count++;
					}
					return o1_tmp_count-o2_tmp_count;
				}
				
			});
			boolean run=true; 
			boolean ispossible = false;
			while_loop: while(run) {
				boolean change = false;
				for (int i = 0; i < strlist.length; i++) {
					for (int j = strlen1[i]; j <=strlen2[i]; j++) {
						char cur = strlist[i].charAt(j);
						if(cur!='*' && strlen3[i]>=a.length()) {
							a.append(cur);
							strlen1[i]++;
							strlen3[i]++;
							if(strlen1[i]>=strlen2[i]) {
								strlen1[i]=strlen2[i]+1;
							}
							change=true;
						}else if(cur!='*' && strlen3[i]<a.length() && a.charAt(strlen3[i])==cur){
							strlen1[i]++;
							strlen3[i]++;
							if(strlen1[i]>=strlen2[i]) {
								strlen1[i]=strlen2[i]+1;
							}
							change=true;
						}else if(cur!='*' && strlen3[i]<a.length() && a.charAt(strlen3[i])!=cur){
							run = false;
							break while_loop;
						}
						if(cur=='*') break;
					} 
					for (int j = strlen2[i]; j >= strlen1[i]; j--) {
						char cur = strlist[i].charAt(j);
						if(cur!='*' && strlen4[i]>=b.length()) {
							b.append(cur);
							strlen2[i]--;
							strlen4[i]++;
							if(strlen1[i]>=strlen2[i]) {
								strlen1[i]=strlen2[i]+1;
							}
							change=true;
						}else if(cur!='*' && strlen4[i]<b.length() && b.charAt(strlen4[i])==cur){
							strlen2[i]--;
							strlen4[i]++;
							if(strlen1[i]>=strlen2[i]) {
								strlen1[i]=strlen2[i]+1;
							}
							change=true;
						}else if(cur!='*' && strlen4[i]<b.length() && b.charAt(strlen4[i])!=cur){
							run = false;
							break while_loop;
						}
						if(cur=='*') break;
					} 
				}
				for (int i = 0; i < strlist.length; i++) {
					for (int j = strlen1[i]; j <=strlen2[i]; j++) {
						char cur = strlist[i].charAt(j);
						if(cur!='*') break;
						char x= '*';
						for (int k = j+1; k <=strlen2[i]; k++) {
							char next = strlist[i].charAt(k);
							if(next!='*') {
								x=next;
								break;
							}
						}
						if(x=='*') {
							strlen1[i]=strlen2[i]+1;
							break;
						}
						if(strlen3[i]>a.length()-1) break;
						for (int k = strlen3[i]; k < a.length(); k++) {
							if(a.charAt(k)==x) {
								break;
							}else {
								strlen3[i]++;
								change=true;
							}
						}
					}
					for (int j = strlen2[i]; j >=strlen1[i]; j--) {
						char cur = strlist[i].charAt(j);
						if(cur!='*') break;
						char x= '*';
						for (int k = j-1; k >=strlen1[i]; k--) {
							char next = strlist[i].charAt(k);
							if(next!='*') {
								x=next;
								break;
							}
						}
						if(x=='*') {
							strlen1[i]=strlen2[i]+1;
							strlen3[i]=strlen4[i]+1;
							change=true;
							break;
						}
						if(strlen4[i]>b.length()-1) break;
						for (int k = strlen4[i]; k < b.length(); k++) {
							if(b.charAt(k)==x) {
								break;
							}else {
								strlen4[i]++;
								change=true;
							}
						}
					}
				}
				if(!change) {
					for_i:for (int i = 0; i < strlist.length; i++) {
						int x = 0;
						for (int j = strlen1[i]; j <=strlen2[i]; j++) {
							char cur = strlist[i].charAt(j);
							x++;
							if(cur=='*') continue;
							strlen1[i]+=x;
							strlen3[i]++;
							a.append(cur);
							if(strlen1[i]>=strlen2[i]) {
								strlen1[i]=strlen2[i]+1;
							}
							break for_i;
						} 
					}
					for_i:for (int i = 0; i < strlist.length; i++) {
						int x = 0;
						for (int j = strlen2[i]; j >=strlen1[i]; j--) {
							char cur = strlist[i].charAt(j);
							x++;
							if(cur=='*') continue;
							strlen2[i]-=x;
							strlen4[i]++;
							a.append(cur);
							if(strlen1[i]>=strlen2[i]) {
								strlen1[i]=strlen2[i]+1;
							}
							break for_i;
						} 
					}
				}
				for (int i = 0; i < strlist.length; i++) {
					if(strlen1[i]<=strlen2[i]) continue while_loop;
				}
				ispossible = true;
				run=false;
			}
			if(ispossible) {
				System.out.println("Case #"+testcase+": "+a+b.reverse());	
			}else {
				System.out.println("Case #"+testcase+": *");
			}
			
		}
	}
}