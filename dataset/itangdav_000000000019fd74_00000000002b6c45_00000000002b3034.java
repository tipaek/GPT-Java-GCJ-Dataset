
import java.io.*;
import java.util.*;

public class Solution {
	public static String trim(String s){
		for(int i=0;i<s.length();i++){
			if(s.substring(i,i+1).equals("*")){
				String temp = s.substring(0,i);
				if(i+1<s.length()) temp+=s.substring(i+1);
				s=temp;
			}
		}
		return s;
	}
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			String ans1 = "";
			String ans2 = "";
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] words = new String[N];
			String[] prefix = new String[N];
			String[] suffix = new String[N];
			String longestPre = "";
			String longestSuf="";
			String ans="";
			String mid="";
			for(int i=0;i<N;i++){
				words[i]= br.readLine();
				int first = words[i].indexOf("*");
				prefix[i]=words[i].substring(0, first);
				
				if(prefix[i].length()>longestPre.length()) longestPre = prefix[i];
				
				int last = words[i].lastIndexOf("*");
				suffix[i]=words[i].substring(last+1,words[i].length());
				if(suffix[i].length()>longestSuf.length()) longestSuf = suffix[i];
				
				words[i]=words[i].substring(first, last);
				mid += trim(words[i]);
			}
			boolean fail = false;
			for(int i=0;i<N;i++){
				if(!longestPre.startsWith(prefix[i])||!longestSuf.endsWith(suffix[i])){
					fail=true;
					break;
				}
			}
			if(!fail){
				ans = longestPre+mid+longestSuf;
			}
			else{
				ans="*";
			}
			
			
			
			System.out.println("Case #" + test + ": "+ ans);
		}
	}
}