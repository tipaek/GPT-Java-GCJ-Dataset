import java.util.*;
import java.io.*;

public class Solution {
	
	static char[] answer;
	static HashMap<Integer,HashSet<Integer>> hm;
	static HashSet<Character> letters;
	static HashSet<Character> used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int cases = 1; cases <= T; cases++) {
		     answer = new char[10];
		     Arrays.fill(answer, '!');
	         System.out.print("Case #" + cases + ": " );
	         hm = new HashMap<Integer, HashSet<Integer>>();
	         letters = new HashSet<Character>();
	         used = new HashSet<Character>();
	         int  U = Integer.parseInt(br.readLine());
	         for (int i = 0; i < 26; i++) {
	        	 hm.put(i, new HashSet<Integer>());
	        	 for (int j = 0; j < 10; j++) {
	        		 hm.get(i).add(j);
	        	 }
	         }
	         boolean flag = false;
	         for (int i =0; i < 10000; i++) {
	        	 StringTokenizer st = new StringTokenizer(br.readLine());
	        	 int num = Integer.parseInt(st.nextToken());
	        	 String s = st.nextToken();
	        	 if (num == -1) {
	        		 flag = true;
	        		 if (s.length() > 1) {
	        			 if (hm.get(s.charAt(0)-'A').contains(0))
		        			 hm.get(s.charAt(0)-'A').remove(0);
	        		 }
	        	 } else if (num < 10) {
	        		 HashSet<Integer> temp = new HashSet<Integer>();
	        		 for (int k = 0; k <= num; k++) {
	        			 temp.add(k);
        			 }
	        		 hm.get(s.charAt(0)-'A').retainAll(temp);
	        		 
	        		 
	        	 } else if ((num+"").length() > s.length() && s.length() > 1) {
	        		 if (hm.get(s.charAt(0)-'A').contains(0))
	        			 hm.get(s.charAt(0)-'A').remove(0);
	        	 } else if (!((num+"").length() > s.length())) {
	        		 int check = Integer.parseInt((num+"").charAt(0)+"");
	        		 HashSet<Integer> temp = new HashSet<Integer>();
	        		 for (int k = 1; k <= check; k++) {
	        			 temp.add(k);
        			 }
	        		 if (s.length() == 1)
	        			 temp.add(0);
	        		 hm.get(s.charAt(0)-'A').retainAll(temp);
	        		 
	        	 }
	        	 for (int k = 0; k < s.length(); k++) {
	        		 letters.add(s.charAt(k));
	        	 }
	        	 if (letters.size() != 10) {
	        		 for (int key : hm.keySet()) {
	        			 if (!letters.contains((char)(key+'A')))
	        				 letters.add((char)(key+'A'));
	        			 if (letters.size() == 10) {
	        				 break;
	        			 }
	        		 }
	        	 }
	         }
	         if (flag) {
	        	 String ans = "";
	        	 for (int i : hm.keySet()) {
	        		 if (!hm.get(i).contains(0)) {
	        			 ans += (char)(i+'A');
	        			 letters.remove(ans.charAt(0));
	        			 break;
	        		 }
	        	 }
	        	 for (char c : letters)
	        		 ans += c;
	        	 System.out.println(ans);
	         } else {
	        	 for (char c : letters) {
	        		 if (hm.get(c-'A').size() == 1) {
	        			 int help = 0;
	        			 for (int i : hm.get(c-'A'))
	        				 help = i;
	        			 answer[help] = c;
	        			 used.add(c);
	        		 }
	        			 
	        	 }
	        	 doThing(0);
	        	 System.out.println(new String(answer));
	        	 
	        	 
	         }
	         
	         
		}
		pw.close();
	}
	
	private static boolean doThing(int i) {
		if (i == 10) {
			return true;
		}
		if (answer[i] != '!')
			return doThing(i+1);
		for (char c : letters) {
			if (hm.get(c-'A').contains(i)) {
				if (!used.contains(c)) {
					used.add(c);
					for (int num : hm.keySet()) {
						if (hm.get(num).contains(i))
						hm.get(num).remove(i);
					}
					answer[i] = c;
					if (doThing(i+1))
						return true;
					answer[i] = '!';
					used.remove(c);
					for (int num : hm.keySet()) {
						hm.get(num).add(i);
					}
				}
			}
		}
		return false;
	}
	
	
}
