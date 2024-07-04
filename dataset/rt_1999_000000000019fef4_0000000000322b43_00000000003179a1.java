import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int q = 1;q<=t ;q++){
			HashMap<Character,Long> hm = new HashMap<>();
			Set<Character> s2 = new HashSet<>();
			int n = 0;
			String s = "";
			for(int i=0;i<10000;i++){
				n = in.nextInt();
				s = in.next();
				String st = String.valueOf(n);
				int l1 = s.length();
				if(s.length()==st.length()){
					for(int j=0;j<l1;j++){
						s2.add(s.charAt(j));
						if(j==0){
							if(!hm.containsKey(s.charAt(j))){
								hm.put(s.charAt(j), (long)(st.charAt(j)-'0'));
							}else{
								hm.put(s.charAt(j), Math.min(hm.get(s.charAt(j)), 
								(long)(st.charAt(j)-'0')));
							}
						}
					}
				}
			}
			Set<pair> st = new HashSet<>();
			ArrayList<Character> al = new ArrayList<>(hm.keySet());
			for(char ch : al){
				pair p = new pair();
				p.a=hm.get(ch);
				p.b=ch;
				st.add(p);
				s2.remove(ch);
			}
			StringBuilder sb = new StringBuilder();
			for(char gh : s2){
				pair p = new pair();
				p.a=hm.get(gh);
				p.b=gh;
				st.add(p);
			}
			for(char gh : s2){
				sb.append(hm.get(gh));
			}
			System.out.println("Case #"+q+": "+sb.toString());
			
		}		
	}   
	
	public static class pair{
		long a=0l;
		char b=' ';
	}
}